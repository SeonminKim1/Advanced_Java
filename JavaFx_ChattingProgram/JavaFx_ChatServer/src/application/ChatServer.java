package application;
	
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// root = (BorderPane)FXMLLoader.load(getClass().getResource("app.fxml"));
// css란 디자인 파일
public class ChatServer extends Application {
	public static ExecutorService threadPool;  // 여러 스레드를 효과적으로 관리하기 때문에. 
	// 갑자기 스레드 숫자가 폭발적으로 증가해도 한정적인 자원으로 안정적으로 운영하기 위함. 
	public static Vector<ChatServer_API> clients = new Vector<ChatServer_API>();
	
	ServerSocket serverSocket;
	
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP,port));
		}catch(Exception e) { // 서버 열기 실패했을떄 
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		// 클라이언트가 접속할 때까지 계속 기다리는 쓰레드 .
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						clients.add(new ChatServer_API(socket));
						System.out.println("[클라이언트 접속]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					}catch(Exception e3) {
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool(); // Executors 클래스의 메소드
		//threadPool = Executors.newFixedThreadPool();
		// newCachedThreadPool()의 초기 스레드 수는 0 코어 스레드 수는 0 
		// newFixedThreadPool()의 초기 스레드 수는 0 코어 스레드 수는 nThreads - 스레드 다 종료되도 최소한의 스레드 남아있음.
		// threadPool은 main이 끝나도 남아있으니 shutdown()으로 종료해야함.
		// Runnable -> run() 이나 Callable -> call() 통해서 구현.
		
		threadPool.submit(thread); // Runnable 또는 Callable을 작업 큐에 저장.
		// threadPool.execute(Runnable thread); // 작업처리중 예외 발생시 스레드 종료 후 제거 후 새로 생성
		// thread.submit(Runnable thread) // 작업처리중 예외 발생시 스레드 종료안되고 바로 다음작업에 재사용.
	}
	
	// 서버의 작동을 중지시키는 메소드. 
	// 이런 예외처리가 서버 짜는 거에서 주로 고급 프로그래밍의 여부를 가짐.
	public void stopServer() {
		try {
			Iterator<ChatServer_API> iterator = clients.iterator();
			while(iterator.hasNext()) { // 모든 클라들 종료. socket해제. client벡터 비우기.
				ChatServer_API client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			// 서버 소켓 객체 닫기
			if(serverSocket != null & !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// 쓰레드 풀 종료하기. - main이 종료되도 종료되지 않음.
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// GUI 작업함.
	@Override
	public void start(Stage primaryStage) {
	try {
			// BorderPane에 Scene을 올리고 그 위에 css를 설정함. 
			// primaryStage를 통해 scene을 앞에 내세움.
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(5));
			
			TextArea textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setFont(new Font("굴림",15));
			root.setCenter(textArea);
			
			Button toggleButton = new Button("시작하기");
			toggleButton.setMaxWidth(Double.MAX_VALUE);
			BorderPane.setMargin(toggleButton, new Insets(1,0,0,0)); // 보다 디자인 이쁘게 마진주기
			root.setBottom(toggleButton); // 토글 버튼 닫기.
			
			String IP = "127.0.0.1";
			int port = 20000;
			
			toggleButton.setOnAction(event ->{
				if(toggleButton.getText().equals("시작하기")) {
					startServer(IP,port);
					Platform.runLater(()->{ // javafx에서는 runLater 등을 이용해서 gui를 출력해주어야 함.
						String message = String.format("[서버 시작]\n",IP,port);
						System.out.println("서버 시작");
						textArea.appendText(message);
						toggleButton.setText("종료하기");
					});
				}
				else {
					stopServer();
					Platform.runLater(()->{
						String message = String.format("[서버 종료]\n", IP,port);
						System.out.println("서버 종료");
						textArea.appendText(message);
						toggleButton.setText("시작하기");
					});
				}
			});
			
			Scene scene = new Scene(root, 400, 400); // 화면 크기.
			primaryStage.setTitle("[채팅 서버]");
			primaryStage.setOnCloseRequest(event->stopServer()); // 프로그램 아예 종료했을 시 stopServer()실행 후에 종료.
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
