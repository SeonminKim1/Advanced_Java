package udpChatting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerSample {
	public static void main(String args[]) {
		DatagramServerSample sample = new DatagramServerSample();
		sample.startServer();
	}
	public void startServer() {
		DatagramSocket server = null;
		try {
			server=new DatagramSocket(9999); // ��ü�� port ��ȣ �����ؼ� ��.
		int bufferLength = 256;
		byte[] buffer = new byte[bufferLength];
		DatagramPacket packet = new DatagramPacket(buffer, bufferLength); // ��ü �����͸� �ޱ� ���� byte�迭�� ũ�� ����
		while(true) {
			System.out.println("���� ����� ... !!");
			server.receive(packet); 				// ���� ����ϴٰ� packet���� �Ѿ���� �׶� ����.
			int dataLength = packet.getLength();	// ������ ���� �������ְ�.
			System.out.println("���� �ޱ� �Ϸ� ����Ÿ ũ��� : " + dataLength);
			String data = new String(packet.getData(),0,dataLength); // ������ ���ڿ��� �ް�.
			System.out.println("Received data: " + data);
			if(data.equals("EXIT")) { // ���࿡ �Ѿ�� �����Ͱ� EXIT�� ���� ����(break). 
				System.out.println("Stop DatagramServer");
				break;
			}
			System.out.println("--------------");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(server!=null) {
				server.close(); // ��� ������ ������ socket��ü�� ����.
			}
		}
	}
}

