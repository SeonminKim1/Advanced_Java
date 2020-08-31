import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ServerGui extends JFrame{
	private JButton btn = new JButton("ä ~ �� ~ �� ~ ��");
	private JTextField Serverjt = new JTextField(30);
	private JTextArea Serverja = new JTextArea(40,30);
	private String jatext="";
	public ServerGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChattingServer cs = new ChattingServer(this);
		setTitle("���� GUI");
		add(btn,BorderLayout.NORTH);
		add(Serverja,BorderLayout.CENTER); 
		add(Serverjt,BorderLayout.SOUTH);
		Serverjt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String str = Serverjt.getText()+"\n"; // �ؽ�Ʈ�ڽ� ���� ���� ����.
				appendText("�� : "+str); // �� gui(Servergui)��  ���� �߰���.
				cs.sendText(str); // �� outputstream �� �������ν� ���� inputstream ���� �о���̰� ����.
				
				Serverjt.setText(""); // �ؽ�Ʈ�ڽ� null��
			}
		});
		setSize(300,600);
		setVisible(true);
		cs.OpenServer();
	}
	public void appendText(String text) { // gui ������ ������� �� ���ؼ� ��Ÿ����.
		jatext=jatext+text;
		Serverja.setText(jatext);
	}
	
	public static void main(String[] args) {
		new ServerGui();
	}
}
