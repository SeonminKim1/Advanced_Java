package udpChatting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class DatagramClientSample {
	public static void main(String args[]) {
		DatagramClientSample sample = new DatagramClientSample();
		sample.sendDatagramSample();
	}
	public void sendDatagramSample() { // ���� ��¥ 3�� ������. ������ ���Ḧ ���� EXIT�� ����.
		for(int loop=0; loop<3; loop++) {
			sendDatagramData("UDP ���۹������ ���� ��¥�� �����ϴ� !!! " + new Date());
		}
		sendDatagramData("EXIT");
	}
	
	public void sendDatagramData(String data) {
		try {
			DatagramSocket client = new DatagramSocket(); // Ŭ���̾�Ʈ ��  ���� ����.
			InetAddress address = InetAddress.getByName("127.0.0.1");
			byte[] buffer = data.getBytes(); // ���� �������� �ϴ� ������ ũ�⸦ ��.
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, address, 9999); // ������ ��Ŷ���� �������ϱ� ��Ŷ�� �����. �� ���̸�ŭ.
			client.send(packet); // ������ ���� -> ���������� receive�� ����.
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ� ");
			client.close(); // ���� ������ �����Ѵ�.
			Thread.sleep(1000); // 1�ʵ��� ����. 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
