import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class StreamBufferedEx {
	// ���۰� �� ���� �ʾ��� ��� ���ۿ� �ִ� �����͸� ���������� ��Ʈ������ �����ϰ� �Ǵ� �޼ҵ尡 flush() �޼ҵ�.
	// ���� ����.
	public StreamBufferedEx() throws IOException {
		synchronized(System.in) {
			synchronized (System.out) {
				BufferedInputStream bin = new BufferedInputStream(System.in);
				BufferedOutputStream bout = new BufferedOutputStream(System.out);
				while(true) {
					int data = bin.read();
					if(data==-1)break;
					bout.write(data);
				}
				bout.flush();
			}
		}
	}
}
