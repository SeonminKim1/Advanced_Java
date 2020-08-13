import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamFileReadWriteEx {
	FileOutputStream fout ;
	FileInputStream fin;
	
	public StreamFileReadWriteEx() throws IOException {
		FileWrite();
		FileRead();
	}
	
	// 모니터(System.in)에서 읽어서 파일에 쓰기.
	public void FileWrite() throws IOException {
		int bytesRead;
		byte[] buffer = new byte[256];
		fout = new FileOutputStream("FileEx1.txt");
		while((bytesRead = System.in.read(buffer))>=0) {
			fout.write(buffer,0,bytesRead);
		}
	}
	
	// 파일에서 읽어서 출력하기(System.out).
	public void FileRead() throws IOException {
		int bytesRead;
		byte[] buffer= new byte[256];
		fin = new FileInputStream("FileEx1.txt");
		while((bytesRead = fin.read(buffer))>=0){
			System.out.write(buffer,0,bytesRead);
		}
	}
}
