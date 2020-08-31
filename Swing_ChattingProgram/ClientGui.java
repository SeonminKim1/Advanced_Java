import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClientGui extends JFrame{
	private JButton btn = new JButton("ä ~ �� ~ �� ~ ��");
	private JTextField Clientjt = new JTextField(30);
	private JTextArea Clientja = new JTextArea(40,30);
	private String jatext="";
	
	public ClientGui() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChattingClient cc = new ChattingClient(this);
		setTitle("Ŭ���̾�Ʈ GUI");
		add(btn,BorderLayout.NORTH);
		add(Clientja,BorderLayout.CENTER); 
		add(Clientjt,BorderLayout.SOUTH);
		Clientjt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = Clientjt.getText()+"\n"; // �ؽ�Ʈ�ڽ� ���� ���� ����.
				appendText("�� : "+str); // �� gui(Clientgui)��  ���� �߰���.
				cc.sendText(str); // �� outputstream �� �������ν� ���� inputstream ���� �о���̰� ����.
				
				Clientjt.setText(""); // �ؽ�Ʈ�ڽ� null��
				
			}
		});
		setSize(300,600);
		setVisible(true);
		cc.connect();
	}
	public void appendText(String text) { // gui������ ���� ���ؼ� ��Ÿ����.
		jatext=jatext+text;
		Clientja.setText(jatext);
	}
	public static void main(String[] args) {
		new ClientGui();
	}
}
