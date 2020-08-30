package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


// 자기의 소켓을 하나 가지고 있는 클라이언트.
// 클래스가 만들어지면 자동으로 receive() 모드가 발동됨.
// 계속 읽어들이는 스레드와 메시지를 전송하는 스레드를 스레드 풀에 등록.
public class ChatServer_API {
	Socket socket;
	
	public ChatServer_API(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// 클라이언트로부터 메시지를 전달받는 메소드 입니다.
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {		
						InputStream in = socket.getInputStream();
						byte [] buffer = new byte[512];
					
						int length = in.read(buffer);
						if(length==-1) throw new IOException();
						System.out.println("[메시지 수신 성공]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						
						String message = new String(buffer, 0, length, "UTF-8"); // 한글도 받을 수 있게.
						for(ChatServer_API client : ChatServer.clients) {
							client.send(message);
						}
					}
				}catch(Exception e) {
					try {
						System.out.println("[메시지 수신 오류]" 
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					}catch (Exception e2) {
						e2.printStackTrace();				
					}
				}
			}
		};
		ChatServer.threadPool.submit(thread); // 이 스레드를 threadPool에 저장함.
	}
	
	// 클라이언트에게 메시지를 전송하는 메소드입니다.
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte [] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush(); // flush() 는 꼭 써야함.
				}
				catch(Exception e) {
					try {
						System.out.println("[메시지 송신 오류]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						ChatServer.clients.remove(ChatServer_API.this); // 통신에 오류가 생긴 클라이언트 제거.
						socket.close();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		};
		ChatServer.threadPool.submit(thread);
	}
}
