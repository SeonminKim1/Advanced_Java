import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamWriterReaderEx {
	String text = "한글입니다.\n한글인가요";
	String text2 = "한글아닙니다.";
	public StreamWriterReaderEx() throws IOException {
		writemethod();
		readmethod(); // 디폴트 유니코드 방식이라 한글은 읽을 수 없음.
		readmethodupgrade();
		bufwritemethod();
		bufreadmethod();
	}

	private void writemethod() throws IOException {
		FileWriter fw = new FileWriter("hangul.txt");
		fw.write(text,0,text.length());
		fw.flush();
		fw.close();
	}
	
	private void readmethod() throws IOException {
		FileReader fr = new FileReader("hangul.txt");
		int number;
		char buffer[] = new char[80];
		//String buffer;
		while((number=fr.read(buffer))>-1) {
			System.out.println(buffer);
		}
		fr.close();
	}
	
	// FilerReader는 한글을 못읽기 때문에 InputStreamReader 이용.
	private void readmethodupgrade() throws IOException {
		int number;
		char[] buffer = new char[80];
		FileInputStream fis = new FileInputStream("hangul.txt");
		InputStreamReader isr = new InputStreamReader(fis, "KSC5601");
		
		while((number = isr.read(buffer,0,buffer.length))!=-1)
			System.out.println(buffer);
	
	}
	
	// buf 쓰기.
	private void bufwritemethod() throws IOException {
		FileWriter fw2 = new FileWriter("hangul2.txt");
		BufferedWriter bw2 = new BufferedWriter(fw2); // 디폴트 (유니코드) 인코딩 방식을 사용하여 저장한다.
		
		bw2.write(text2,0,text2.length());
		bw2.flush(); // 버퍼의 내용을 쓴다.
		bw2.close();
	}

	// buf 읽기.
	private void bufreadmethod() throws IOException {
		String data;
		
		FileReader fr2 = new FileReader("hangul2.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		while((data = br2.readLine()) != null) {
			System.out.println(data);
		}
	}

}
