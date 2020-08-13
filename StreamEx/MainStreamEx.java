import java.io.IOException;

public class MainStreamEx {
	
	// 사용법 : 해당 번호의 주석을 풀고 사용하면됨
	// 해당 클래스 생성되면서 - 생성자 실행 - 생성자 실행되면서 해당 클래스 메소드 자동 실행
	public static void main(String[] args) throws IOException {
		// 1. Stream Copy Method - 스트림 카피 : in->out
		StreamCopyEx streamcopyex = new StreamCopyEx();

		// 2. Stream File read/write - FileInputStream , FileOutputStream
		// FileEx1.txt 에 기록됨
		// StreamFileReadWriteEx streamfilereadwriteex = new StreamFileReadWriteEx();
		// 유닉스에서는 \ , 윈도우는 / 인데 자바가상기계가 파일클래스 만 만들면 그 이하는 알아서 구분하여 처리해 주므로 파일 클래스만 신경 쓰면 된다.

		// 3. Filter Stream : 바이트 단위가 아닌, 2바이트 이상의 데이터(한글)나 숫자와 문자같은 데이터를 직접 전송할 수 있는 기능.
		// 바이트 단위로 데이터를 전송하는 기능을 수행하는 클래스들을 기반 입출력 스트림 클래스 라고 함.
		// Filter Stream 같은 경우는 연결된 기반 스트림을 거친다.
		
		// 3-1. DataInputStream, DataOutputStream : writexxx -> readxxx 가 같아야 한다.
		// 기본 자료형 데이터를 읽는다. - FileEx2 것을 읽음
		// StreamDataEx streamdataex = new StreamDataEx();
		
		// 3-2. BufferedInputStream, BufferedOutputStream : 직접 파일에서 읽는게 아니라 버퍼에서 데이터를 읽기 때문에 효율이 좋아진다. 기본 스트림에 버퍼를 추가한것.
		// 버퍼가 꽉 차면 한 번에 스트림에 전송함.
		// StreamBufferedEx streambufferedex = new StreamBufferedEx();
		
		// 4. Writer, Reader : 한글을 처리하는 인코딩 및 디코딩 기능을 추가하는 것보다 클래스 자체에 한글과 같은 2바이트 이상의 문자를 처리함.
		// hangul.txt읽어서 -> hangul2. txt에 저장
		// StreamWriterReaderEx streamwriterreaderex = new StreamWriterReaderEx();
		
		// InputStream / Reader : 기본 입력 스트림 클래스
		// FileInputStrean / FileReader : 파일 입력 스트림 클래스
		// FilterInputStream / FilterReader : 입력필터 스트림 클래스의 최상위 클래스
		// BufferedInputStream / BufferedReader : 기본 스트림에 버퍼를 추가한다.
		// DataInputStream / 없음 : 기본 자료형 데이터를 읽는다. 
		// OutputStream / Writer : 기본 출력 스트림 클래스
		// FileOutputStream / FileWriter : 파일 출력 스트림 클래스
		// FilterOutputStream / FilterWriter : 출력필터 스트림 클래스들의 최상위 클래스
		// BufferedOutputStream / BufferedWriter : 기본 스트림에 버퍼를 추가한다.
		// DataOutputSTream / 없음 : 기본 자료형 데이터를 출력한다.
		// PrintStream : 표준 시스템에 출력한다.
	
	}
}
