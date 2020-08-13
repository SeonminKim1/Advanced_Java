import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDataEx {
	FileInputStream fin;
	FileOutputStream fout;
	DataInputStream dis;
	DataOutputStream dos;
	
	public StreamDataEx() throws IOException {
		dataWrite();
		dataRead();
	} // »ý¼ºÀÚ
	
	private void dataRead() throws IOException {
		fin = new FileInputStream("FileEx2");
		dis = new DataInputStream(fin); 
		System.out.println(dis.readBoolean());
		for(int i=1; i<10; i++) {
			System.out.println(dis.readInt());
		}
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readChar());
	}
	
	private void dataWrite() throws IOException {
		fout = new FileOutputStream("FileEx2");
		dos = new DataOutputStream(fout);
		dos.writeBoolean(true);
		for(int i=1; i<10; i++){
			dos.writeInt(i);
		}
		dos.writeDouble(3.54);
		dos.writeUTF("ÈïÄ©»×");
		dos.writeChar('A');
	}
}
