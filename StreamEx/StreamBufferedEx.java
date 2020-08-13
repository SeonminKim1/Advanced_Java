import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class StreamBufferedEx {
	// 버퍼가 다 차지 않았을 경우 버퍼에 있는 데이터를 강제적으로 스트림으로 전송하게 되는 메소드가 flush() 메소드.
	// 보다 빠름.
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
