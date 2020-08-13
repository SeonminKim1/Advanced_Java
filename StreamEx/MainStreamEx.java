import java.io.IOException;

public class MainStreamEx {
	
	// ���� : �ش� ��ȣ�� �ּ��� Ǯ�� ����ϸ��
	// �ش� Ŭ���� �����Ǹ鼭 - ������ ���� - ������ ����Ǹ鼭 �ش� Ŭ���� �޼ҵ� �ڵ� ����
	public static void main(String[] args) throws IOException {
		// 1. Stream Copy Method - ��Ʈ�� ī�� : in->out
		StreamCopyEx streamcopyex = new StreamCopyEx();

		// 2. Stream File read/write - FileInputStream , FileOutputStream
		// FileEx1.txt �� ��ϵ�
		// StreamFileReadWriteEx streamfilereadwriteex = new StreamFileReadWriteEx();
		// ���н������� \ , ������� / �ε� �ڹٰ����谡 ����Ŭ���� �� ����� �� ���ϴ� �˾Ƽ� �����Ͽ� ó���� �ֹǷ� ���� Ŭ������ �Ű� ���� �ȴ�.

		// 3. Filter Stream : ����Ʈ ������ �ƴ�, 2����Ʈ �̻��� ������(�ѱ�)�� ���ڿ� ���ڰ��� �����͸� ���� ������ �� �ִ� ���.
		// ����Ʈ ������ �����͸� �����ϴ� ����� �����ϴ� Ŭ�������� ��� ����� ��Ʈ�� Ŭ���� ��� ��.
		// Filter Stream ���� ���� ����� ��� ��Ʈ���� ��ģ��.
		
		// 3-1. DataInputStream, DataOutputStream : writexxx -> readxxx �� ���ƾ� �Ѵ�.
		// �⺻ �ڷ��� �����͸� �д´�. - FileEx2 ���� ����
		// StreamDataEx streamdataex = new StreamDataEx();
		
		// 3-2. BufferedInputStream, BufferedOutputStream : ���� ���Ͽ��� �д°� �ƴ϶� ���ۿ��� �����͸� �б� ������ ȿ���� ��������. �⺻ ��Ʈ���� ���۸� �߰��Ѱ�.
		// ���۰� �� ���� �� ���� ��Ʈ���� ������.
		// StreamBufferedEx streambufferedex = new StreamBufferedEx();
		
		// 4. Writer, Reader : �ѱ��� ó���ϴ� ���ڵ� �� ���ڵ� ����� �߰��ϴ� �ͺ��� Ŭ���� ��ü�� �ѱ۰� ���� 2����Ʈ �̻��� ���ڸ� ó����.
		// hangul.txt�о -> hangul2. txt�� ����
		// StreamWriterReaderEx streamwriterreaderex = new StreamWriterReaderEx();
		
		// InputStream / Reader : �⺻ �Է� ��Ʈ�� Ŭ����
		// FileInputStrean / FileReader : ���� �Է� ��Ʈ�� Ŭ����
		// FilterInputStream / FilterReader : �Է����� ��Ʈ�� Ŭ������ �ֻ��� Ŭ����
		// BufferedInputStream / BufferedReader : �⺻ ��Ʈ���� ���۸� �߰��Ѵ�.
		// DataInputStream / ���� : �⺻ �ڷ��� �����͸� �д´�. 
		// OutputStream / Writer : �⺻ ��� ��Ʈ�� Ŭ����
		// FileOutputStream / FileWriter : ���� ��� ��Ʈ�� Ŭ����
		// FilterOutputStream / FilterWriter : ������� ��Ʈ�� Ŭ�������� �ֻ��� Ŭ����
		// BufferedOutputStream / BufferedWriter : �⺻ ��Ʈ���� ���۸� �߰��Ѵ�.
		// DataOutputSTream / ���� : �⺻ �ڷ��� �����͸� ����Ѵ�.
		// PrintStream : ǥ�� �ý��ۿ� ����Ѵ�.
	
	}
}
