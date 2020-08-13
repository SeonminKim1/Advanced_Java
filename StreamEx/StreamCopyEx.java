import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StreamCopyEx {
	public StreamCopyEx() {
		try {
			copy(System.in, System.out);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("스트림 읽어들이기 오류");
		}
	}

	private void copy(InputStream in, PrintStream out) throws IOException {
		int bytesRead;
		byte[] buffer = new byte[256];
		synchronized (in) {
			synchronized (out) {
				while((bytesRead = in.read(buffer))>=0){
					out.write(buffer,0,bytesRead);
				}
			}
		}
	}
	
	
}
