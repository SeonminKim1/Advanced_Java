import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;

// �뷡���� (txt����) �ҷ�����.
// scrollPanel�߰��ϰ� ������ �� 
public class FileExersise_Swing extends JFrame{
	private String txtpath="";
	private JFileChooser chooser;
	private JTextArea jta = new JTextArea();
	private JScrollPane scrollPane;
	private Scanner scanner;
	public FileExersise_Swing() {
		setTitle("�뷡���� �ҷ�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		jta.setSize(400,450);		
		c.add(jta);
		createMenu();				// �޴��� �߰�
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
				chooser = new JFileChooser();  // ���� ���̾�α� ����.
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ���� ���ø�� ����. �Ʒ������ ��Ʈ
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt"); // ���� �̸� ĭ(����Ʈ)�� ��µ� ���ڿ� , ���� ���ͷ� ���Ǵ� Ȯ���� *.txt�� ������ + ������ ������.
				chooser.setFileFilter(filter); // ���� ����.
				int ret= chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
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
