package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


// �ڱ��� ������ �ϳ� ������ �ִ� Ŭ���̾�Ʈ.
// Ŭ������ ��������� �ڵ����� receive() ��尡 �ߵ���.
// ��� �о���̴� ������� �޽����� �����ϴ� �����带 ������ Ǯ�� ���.
public class ChatServer_API {
	Socket socket;
	
	public ChatServer_API(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// Ŭ���̾�Ʈ�κ��� �޽����� ���޹޴� �޼ҵ� �Դϴ�.
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
						System.out.println("[�޽��� ���� ����]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						
						String message = new String(buffer, 0, length, "UTF-8"); // �ѱ۵� ���� �� �ְ�.
						for(ChatServer_API client : ChatServer.clients) {
							client.send(message);
						}
					}
				}catch(Exception e) {
					try {
						System.out.println("[�޽��� ���� ����]" 
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
					}catch (Exception e2) {
						e2.printStackTrace();				
					}
				}
			}
		};
		ChatServer.threadPool.submit(thread); // �� �����带 threadPool�� ������.
	}
	
	// Ŭ���̾�Ʈ���� �޽����� �����ϴ� �޼ҵ��Դϴ�.
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte [] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush(); // flush() �� �� �����.
				}
				catch(Exception e) {
					try {
						System.out.println("[�޽��� �۽� ����]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						ChatServer.clients.remove(ChatServer_API.this); // ��ſ� ������ ���� Ŭ���̾�Ʈ ����.
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
