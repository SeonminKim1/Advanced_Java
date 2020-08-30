package application;
	
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;


// 쓰레드 풀이 필요없음. 여러개 스레드를 생성하는 일이 없기 때문.
// runnable 대신 스레드 사용. 여러개 스레드 사용할 필요가 없으니까.
// 즉 채팅구조는 계속 읽어들이는 스레드 1 그냥 보낼때 잠깐 사용하는 스레드 1 총 2개 필요. 단 계속 돌아가는건 읽어들이는거 하나
public class ChatClient extends Application {
	
	Socket socket;
	TextArea textArea;
	
	// start가 제일 먼저 시작됨.
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		HBox hbox = new HBox();
		hbox.setSpacing(5); // 여백주기.
		
		TextField userName = new TextField();
		userName.setPrefWidth(150);
		userName.setPromptText("닉네임을 입력하세요.");
		HBox.setHgrow(userName, Priority.ALWAYS);
		
		TextField IPText = new TextField("127.0.0.1");
		TextField portText = new TextField("20000");
		portText.setPrefWidth(80);
		
		hbox.getChildren().addAll(userName, IPText, portText); // hbox내부에 3개의 textfield 추가
		root.setTop(hbox); // borderPane의 위쪽에 달음.
		
		// 가운데 채팅 창.
		textArea = new TextArea();
		textArea.setEditable(false);
		root.setCenter(textArea);
		
		// 접속하기, 채팅 입력창, 보내기 버튼.
		TextField input = new TextField();
		input.setPrefWidth(Double.MAX_VALUE);
		input.setDisable(true); // 전송버튼 누르기전에는 사용 불가능하게.
		
		input.setOnAction(event->{
			send(userName.getText()+": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});
		
		Button sendButton = new Button("보내기");
		sendButton.setDisable(true);
		sendButton.setOnAction(event->{
			send(userName.getText()+": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});
		
		Button connectionButton = new Button("접속하기");
		connectionButton.setOnAction(event->{
			if(connectionButton.getText().contentEquals("접속하기")) {
				int port = 20000;
				try {
					port = Integer.parseInt(portText.getText());
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(port);
				startClient(IPText.getText(), port);
				Platform.runLater(()->{
					textArea.appendText("[채팅방 접속]\n");
					
				});
				connectionButton.setText("종료하기");;
				input.setDisable(false);
				sendButton.setDisable(false);
				input.requestFocus();
			}else {
				stopClient();
				Platform.runLater(()->{
					textArea.appendText("[채팅방 퇴장]\n");
				});
				connectionButton.setText("접속하기");
				input.setDisable(true);
				sendButton.setDisable(true);
			}
		});
		BorderPane pane = new BorderPane();
		pane.setLeft(connectionButton);;
		pane.setCenter(input);
		pane.setRight(sendButton);;
		
		root.setBottom(pane);
		Scene scene = new Scene(root,400,400);
		primaryStage.setTitle("[ 채팅 클라이언트]");;
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event->stopClient());
		primaryStage.show();
		
		connectionButton.requestFocus();
	}
	
	// 클라이언트 프로그램 시작 메소드.
	public void startClient(String IP, int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 20000);
					receive();
					
				}catch (Exception e) { 
					if(!socket.isClosed()) {
						stopClient();
						System.out.println("[서버 접속 실패]");
						Platform.exit(); // 프로그램 자체 종료하기.
					}
				}
			}
		};
		thread.start();
	}
	
	// 클라이언트 프로그램 종료 메소드
	public void stopClient() {
		try {
			if(socket!=null && !socket.isClosed()) {
				socket.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 서버로부터 메시지를 전달받는 메소드입니다.
	public void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if(length==-1) throw new IOException();
				String message = new String(buffer, 0 , length, "UTF-8");
				Platform.runLater(()->{
					textArea.appendText(message);
				});
			}catch (Exception e) {
				stopClient();
				break;
			}
		}
	}
	
	// 서버로 내용을 전송하는 메소드 입니다. 
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte buffer[] = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				}catch(Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
