import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamWriterReaderEx {
	String text = "�ѱ��Դϴ�.\n�ѱ��ΰ���";
	String text2 = "�ѱ۾ƴմϴ�.";
	public StreamWriterReaderEx() throws IOException {
		writemethod();
		readmethod(); // ����Ʈ �����ڵ� ����̶� �ѱ��� ���� �� ����.
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
	
	// FilerReader�� �ѱ��� ���б� ������ InputStreamReader �̿�.
	private void readmethodupgrade() throws IOException {
		int number;
		char[] buffer = new char[80];
		FileInputStream fis = new FileInputStream("hangul.txt");
		InputStreamReader isr = new InputStreamReader(fis, "KSC5601");
		
		while((number = isr.read(buffer,0,buffer.length))!=-1)
			System.out.println(buffer);
	
	}
	
	// buf ����.
	private void bufwritemethod() throws IOException {
		FileWriter fw2 = new FileWriter("hangul2.txt");
		BufferedWriter bw2 = new BufferedWriter(fw2); // ����Ʈ (�����ڵ�) ���ڵ� ����� ����Ͽ� �����Ѵ�.
		
		bw2.write(text2,0,text2.length());
		bw2.flush(); // ������ ������ ����.
		bw2.close();
	}

	// buf �б�.
	private void bufreadmethod() throws IOException {
		String data;
		
		FileReader fr2 = new FileReader("hangul2.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		while((data = br2.readLine()) != null) {
			System.out.println(data);
		}
	}

}
