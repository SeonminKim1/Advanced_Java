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
	public void sendDatagramSample() { // 현재 날짜 3번 보내고. 마지막 종료를 위해 EXIT를 보냄.
		for(int loop=0; loop<3; loop++) {
			sendDatagramData("UDP 전송방식으로 현재 날짜를 보냅니다 !!! " + new Date());
		}
		sendDatagramData("EXIT");
	}
	
	public void sendDatagramData(String data) {
		try {
			DatagramSocket client = new DatagramSocket(); // 클라이언트 꺼  소켓 생성.
			InetAddress address = InetAddress.getByName("127.0.0.1");
			byte[] buffer = data.getBytes(); // 내가 보내고자 하는 문장의 크기를 잼.
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, address, 9999); // 전송은 패킷으로 보낼꺼니까 패킷에 담아줌. 그 길이만큼.
			client.send(packet); // 데이터 전송 -> 서버에서는 receive로 받음.
			System.out.println("클라이언트 전송 완료 ");
			client.close(); // 소켓 연결을 종료한다.
			Thread.sleep(1000); // 1초동안 쉬고. 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
