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
// css�� ������ ����
public class ChatServer extends Application {
	public static ExecutorService threadPool;  // ���� �����带 ȿ�������� �����ϱ� ������. 
	// ���ڱ� ������ ���ڰ� ���������� �����ص� �������� �ڿ����� ���������� ��ϱ� ����. 
	public static Vector<ChatServer_API> clients = new Vector<ChatServer_API>();
	
	ServerSocket serverSocket;
	
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP,port));
		}catch(Exception e) { // ���� ���� ���������� 
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		// Ŭ���̾�Ʈ�� ������ ������ ��� ��ٸ��� ������ .
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						clients.add(new ChatServer_API(socket));
						System.out.println("[Ŭ���̾�Ʈ ����]"
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
		threadPool = Executors.newCachedThreadPool(); // Executors Ŭ������ �޼ҵ�
		//threadPool = Executors.newFixedThreadPool();
		// newCachedThreadPool()�� �ʱ� ������ ���� 0 �ھ� ������ ���� 0 
		// newFixedThreadPool()�� �ʱ� ������ ���� 0 �ھ� ������ ���� nThreads - ������ �� ����ǵ� �ּ����� ������ ��������.
		// threadPool�� main�� ������ ���������� shutdown()���� �����ؾ���.
		// Runnable -> run() �̳� Callable -> call() ���ؼ� ����.
		
		threadPool.submit(thread); // Runnable �Ǵ� Callable�� �۾� ť�� ����.
		// threadPool.execute(Runnable thread); // �۾�ó���� ���� �߻��� ������ ���� �� ���� �� ���� ����
		// thread.submit(Runnable thread) // �۾�ó���� ���� �߻��� ������ ����ȵǰ� �ٷ� �����۾��� ����.
	}
	
	// ������ �۵��� ������Ű�� �޼ҵ�. 
	// �̷� ����ó���� ���� ¥�� �ſ��� �ַ� ��� ���α׷����� ���θ� ����.
	public void stopServer() {
		try {
			Iterator<ChatServer_API> iterator = clients.iterator();
			while(iterator.hasNext()) { // ��� Ŭ��� ����. socket����. client���� ����.
				ChatServer_API client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			// ���� ���� ��ü �ݱ�
			if(serverSocket != null & !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// ������ Ǯ �����ϱ�. - main�� ����ǵ� ������� ����.
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// GUI �۾���.
	@Override
	public void start(Stage primaryStage) {
	try {
			// BorderPane�� Scene�� �ø��� �� ���� css�� ������. 
			// primaryStage�� ���� scene�� �տ� ������.
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(5));
			
			TextArea textArea = new TextArea();
			textArea.setEditable(false);
			textArea.setFont(new Font("����",15));
			root.setCenter(textArea);
			
			Button toggleButton = new Button("�����ϱ�");
			toggleButton.setMaxWidth(Double.MAX_VALUE);
			BorderPane.setMargin(toggleButton, new Insets(1,0,0,0)); // ���� ������ �̻ڰ� �����ֱ�
			root.setBottom(toggleButton); // ��� ��ư �ݱ�.
			
			String IP = "127.0.0.1";
			int port = 20000;
			
			toggleButton.setOnAction(event ->{
				if(toggleButton.getText().equals("�����ϱ�")) {
					startServer(IP,port);
					Platform.runLater(()->{ // javafx������ runLater ���� �̿��ؼ� gui�� ������־�� ��.
						String message = String.format("[���� ����]\n",IP,port);
						System.out.println("���� ����");
						textArea.appendText(message);
						toggleButton.setText("�����ϱ�");
					});
				}
				else {
					stopServer();
					Platform.runLater(()->{
						String message = String.format("[���� ����]\n", IP,port);
						System.out.println("���� ����");
						textArea.appendText(message);
						toggleButton.setText("�����ϱ�");
					});
				}
			});
			
			Scene scene = new Scene(root, 400, 400); // ȭ�� ũ��.
			primaryStage.setTitle("[ä�� ����]");
			primaryStage.setOnCloseRequest(event->stopServer()); // ���α׷� �ƿ� �������� �� stopServer()���� �Ŀ� ����.
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
