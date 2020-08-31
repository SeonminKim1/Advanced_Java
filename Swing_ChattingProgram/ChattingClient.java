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
				clientgui.appendText("������ ����Ǿ����ϴ�.\n");
				out = new DataOutputStream(socket.getOutputStream()); // getOutputStream���� DataOutputStream �̶� �濡 ����.
				in = new DataInputStream(socket.getInputStream()); // getInputStream���� DataInputStream �̶� �濡 ����.
				while(true) {
					String s = in.readUTF();
					clientgui.appendText("���� : "+s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void sendText(String str) { // ���濡�� ������ Clientgui�� �ؽ�Ʈ���� ����ĥ������ ����.
			try {
				out.writeUTF(str);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
