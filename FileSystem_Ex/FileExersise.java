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
			System.out.println("번호를 정하세요.");
			System.out.println("1. 파일 읽기, 2. 파일 쓰기, 3.파일 삭제하기  4.파일 목록 출력  5.txt파일만 찾기   6.기타기능들");
			int n = scanner.nextInt();
			switch (n) {
			case 1: // 파일 내용 읽어오기.
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

			case 2: // 파일 쓰기
				File hwp2 = new File("exersise2.txt");
				try {
					FileWriter fw = new FileWriter(hwp2);
					fw.write(paper);
					System.out.println();
					fw.close();
					System.out.println("exersise2 파일 생성 완료");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3: // 파일 삭제
				File hwp3 = new File("exersise2.txt");
				if (hwp3.delete()) {
					System.out.println("exersise2.txt 파일지우기 완료");
				} else {
					System.out.println("파일 지우기 실패");
				}
				break;

			case 4: // 현재경로의 모든 파일 출력.
				File f = new File(".");
				String filename[] = f.list();
				for (int i = 0; i < filename.length; i++) {
					System.out.println(filename[i]);
				}
				break;

			case 5: // 현재경로의 txt파일만 찾기.
				File f2 = new File(".");
				String filename2[] = f2.list();
				for (int i = 0; i < filename2.length; i++) {
					if (filename2[i].contains(".txt")) {
						System.out.println(filename2[i]);
					}
				}
				break;
				
			case 6: // 기타 기능들 
				File f3 = new File("exersise1.txt");
				System.out.println("현재경로에 exersise1.txt 파일이 존재하는지? "+f3.exists());
				System.out.println("exersise1.txt 호출한 객체가 파일인지? "+ f3.isFile());
				System.out.println("exersise1.txt 호출한 객체가 폴더인지? "+ f3.isDirectory());
				System.out.println("exersise1.txt 호출한 파일객체에서 파일이름만 반환 : "+f3.getName());	
				System.out.println("exersise1.txt 호출한 파일객체가 가리키는 경로 및 파일이름 : " + f3.getPath());
				System.out.println("exersise1.txt 파일 시스템의 루트에서부터 시작하는 파일의 절대 경로는? "+ f3.getAbsolutePath());
				System.out.println("exersise1.txt Path 필드 안에 있는 파일이름을 제외한 폴더이름은 ? : "+f3.getParent());
				System.out.println("exersise1.txt 파일이 숨긴 파일인지? : " + f3.isHidden());
				System.out.println("exersise1.txt 파일의 크기는 (바이트 수) " + f3.length());

				break;
			} // switch
		} // while
	} // 생성자

	public static void main(String args[]) throws IOException {
		new FileExersise();
	}
}
