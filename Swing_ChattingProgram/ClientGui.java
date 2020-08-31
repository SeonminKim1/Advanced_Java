import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClientGui extends JFrame{
	private JButton btn = new JButton("채 ~ 팅 ~ 시 ~ 작");
	private JTextField Clientjt = new JTextField(30);
	private JTextArea Clientja = new JTextArea(40,30);
	private String jatext="";
	
	public ClientGui() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChattingClient cc = new ChattingClient(this);
		setTitle("클라이언트 GUI");
		add(btn,BorderLayout.NORTH);
		add(Clientja,BorderLayout.CENTER); 
		add(Clientjt,BorderLayout.SOUTH);
		Clientjt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = Clientjt.getText()+"\n"; // 텍스트박스 쓴거 내용 읽음.
				appendText("나 : "+str); // 내 gui(Clientgui)에  내용 추가됨.
				cc.sendText(str); // 내 outputstream 에 담음으로써 상대방 inputstream 으로 읽어들이게 해줌.
				
				Clientjt.setText(""); // 텍스트박스 null로
				
			}
		});
		setSize(300,600);
		setVisible(true);
		cc.connect();
	}
	public void appendText(String text) { // gui기존의 내용 합해서 나타내줌.
		jatext=jatext+text;
		Clientja.setText(jatext);
	}
	public static void main(String[] args) {
		new ClientGui();
	}
}
