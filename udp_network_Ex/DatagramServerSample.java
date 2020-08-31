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
			server=new DatagramSocket(9999); // 객체에 port 번호 지정해서 감.
		int bufferLength = 256;
		byte[] buffer = new byte[bufferLength];
		DatagramPacket packet = new DatagramPacket(buffer, bufferLength); // 객체 데이터를 받기 위한 byte배열과 크기 생성
		while(true) {
			System.out.println("서버 대기중 ... !!");
			server.receive(packet); 				// 서버 대기하다가 packet으로 넘어오면 그때 받음.
			int dataLength = packet.getLength();	// 데이터 길이 측정해주고.
			System.out.println("서버 받기 완료 데이타 크기는 : " + dataLength);
			String data = new String(packet.getData(),0,dataLength); // 데이터 문자열로 받고.
			System.out.println("Received data: " + data);
			if(data.equals("EXIT")) { // 만약에 넘어온 데이터가 EXIT면 서버 종료(break). 
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
				server.close(); // 모든 과정이 끝나면 socket객체를 닫음.
			}
		}
	}
}

