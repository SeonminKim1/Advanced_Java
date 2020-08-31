import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChattingClient {
		Socket socket;
		ClientGui clientgui;
		
		private DataInputStream in;
		private DataOutputStream out;
		
		public ChattingClient(ClientGui clientgui) {
			this.clientgui=clientgui;
		}
		public void connect() {
			try {
				socket= new Socket("127.0.0.1",8888);
				clientgui.appendText("서버와 연결되었습니다.\n");
				out = new DataOutputStream(socket.getOutputStream()); // getOutputStream으로 DataOutputStream 이란 길에 적용.
				in = new DataInputStream(socket.getInputStream()); // getInputStream으로 DataInputStream 이란 길에 적용.
				while(true) {
					String s = in.readUTF();
					clientgui.appendText("서버 : "+s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void sendText(String str) { // 상대방에게 보내줌 Clientgui가 텍스트상자 엔터칠때마다 보냄.
			try {
				out.writeUTF(str);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
