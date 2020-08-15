import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;

public class FileExersise {
	private String paper = "";

	public FileExersise() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("��ȣ�� ���ϼ���.");
			System.out.println("1. ���� �б�, 2. ���� ����, 3.���� �����ϱ�  4.���� ��� ���  5.txt���ϸ� ã��   6.��Ÿ��ɵ�");
			int n = scanner.nextInt();
			switch (n) {
			case 1: // ���� ���� �о����.
				File hwp = new File("exersise1.txt");
				try {
					FileReader fr = new FileReader(hwp);
					BufferedReader br = new BufferedReader(fr);
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;
						paper = paper + line + '\n';
					}
					System.out.println(paper);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2: // ���� ����
				File hwp2 = new File("exersise2.txt");
				try {
					FileWriter fw = new FileWriter(hwp2);
					fw.write(paper);
					System.out.println();
					fw.close();
					System.out.println("exersise2 ���� ���� �Ϸ�");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3: // ���� ����
				File hwp3 = new File("exersise2.txt");
				if (hwp3.delete()) {
					System.out.println("exersise2.txt ��������� �Ϸ�");
				} else {
					System.out.println("���� ����� ����");
				}
				break;

			case 4: // �������� ��� ���� ���.
				File f = new File(".");
				String filename[] = f.list();
				for (int i = 0; i < filename.length; i++) {
					System.out.println(filename[i]);
				}
				break;

			case 5: // �������� txt���ϸ� ã��.
				File f2 = new File(".");
				String filename2[] = f2.list();
				for (int i = 0; i < filename2.length; i++) {
					if (filename2[i].contains(".txt")) {
						System.out.println(filename2[i]);
					}
				}
				break;
				
			case 6: // ��Ÿ ��ɵ� 
				File f3 = new File("exersise1.txt");
				System.out.println("�����ο� exersise1.txt ������ �����ϴ���? "+f3.exists());
				System.out.println("exersise1.txt ȣ���� ��ü�� ��������? "+ f3.isFile());
				System.out.println("exersise1.txt ȣ���� ��ü�� ��������? "+ f3.isDirectory());
				System.out.println("exersise1.txt ȣ���� ���ϰ�ü���� �����̸��� ��ȯ : "+f3.getName());	
				System.out.println("exersise1.txt ȣ���� ���ϰ�ü�� ����Ű�� ��� �� �����̸� : " + f3.getPath());
				System.out.println("exersise1.txt ���� �ý����� ��Ʈ�������� �����ϴ� ������ ���� ��δ�? "+ f3.getAbsolutePath());
				System.out.println("exersise1.txt Path �ʵ� �ȿ� �ִ� �����̸��� ������ �����̸��� ? : "+f3.getParent());
				System.out.println("exersise1.txt ������ ���� ��������? : " + f3.isHidden());
				System.out.println("exersise1.txt ������ ũ��� (����Ʈ ��) " + f3.length());

				break;
			} // switch
		} // while
	} // ������

	public static void main(String args[]) throws IOException {
		new FileExersise();
	}
}
