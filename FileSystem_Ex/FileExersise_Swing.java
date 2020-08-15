import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;

// 노래가사 (txt기준) 불러오기.
// scrollPanel추가하고 싶으면 그 
public class FileExersise_Swing extends JFrame{
	private String txtpath="";
	private JFileChooser chooser;
	private JTextArea jta = new JTextArea();
	private JScrollPane scrollPane;
	private Scanner scanner;
	public FileExersise_Swing() {
		setTitle("노래가사 불러오기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		jta.setSize(400,450);		
		c.add(jta);
		createMenu();				// 메뉴바 추가
		setSize(600,600);
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openitem = new JMenuItem("Open");
		fileMenu.add(openitem);
		
		openitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();  // 파일 다이얼로그 생성.
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 선택모드 적용. 아랫문장과 셋트
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt"); // 파일 이름 칸(리스트)에 출력될 문자열 , 파일 필터로 사용되는 확장자 *.txt만 나열됨 + 폴더도 나열됨.
				chooser.setFileFilter(filter); // 필터 적용.
				int ret= chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
				return;
				}
				txtpath = chooser.getSelectedFile().getPath();
				try {
					scanner= new Scanner(new FileInputStream(txtpath));
					while(scanner.hasNext()) {
						jta.setText(jta.getText()+scanner.nextLine()+"\n");
					}
					scanner.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				scrollPane= new JScrollPane(jta);
				add(scrollPane);
			}
		});
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new FileExersise_Swing();
	}
}
