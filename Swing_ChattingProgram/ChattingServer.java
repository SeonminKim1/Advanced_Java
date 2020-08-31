import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer {
		private ServerSocket serversocket;
		private Socket socket;
		private ServerGui servergui;
		private DataInputStream in;
		private DataOutputStream out;
		
		public ChattingServer(ServerGui servergui) {
			this.servergui=servergui;
		}
		public void OpenServer() {
			try {
				serversocket = new ServerSocket(8888); // 포트가 8888인 소켓생성
				socket=serversocket.accept(); // 클라이언트가 접속할때까지 기다림.
				servergui.appendText(socket.getInetAddress() +"에서 클라이언트와 연결되엇습니다\n");
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				while(true) {
					String s = in.readUTF();
					servergui.appendText("클라이언트 : "+s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		public void sendText(String str) { // 상대방에게 보내줌 Servergui가 텍스트상자 엔터칠때마다 보냄.
			try {
				out.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}