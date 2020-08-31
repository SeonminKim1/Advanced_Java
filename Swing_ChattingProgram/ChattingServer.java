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
				serversocket = new ServerSocket(8888); // ��Ʈ�� 8888�� ���ϻ���
				socket=serversocket.accept(); // Ŭ���̾�Ʈ�� �����Ҷ����� ��ٸ�.
				servergui.appendText(socket.getInetAddress() +"���� Ŭ���̾�Ʈ�� ����Ǿ����ϴ�\n");
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				while(true) {
					String s = in.readUTF();
					servergui.appendText("Ŭ���̾�Ʈ : "+s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		public void sendText(String str) { // ���濡�� ������ Servergui�� �ؽ�Ʈ���� ����ĥ������ ����.
			try {
				out.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}