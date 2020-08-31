import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ServerGui extends JFrame{
	private JButton btn = new JButton("채 ~ 팅 ~ 시 ~ 작");
	private JTextField Serverjt = new JTextField(30);
	private JTextArea Serverja = new JTextArea(40,30);
	private String jatext="";
	public ServerGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChattingServer cs = new ChattingServer(this);
		setTitle("서버 GUI");
		add(btn,BorderLayout.NORTH);
		add(Serverja,BorderLayout.CENTER); 
		add(Serverjt,BorderLayout.SOUTH);
		Serverjt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String str = Serverjt.getText()+"\n"; // 텍스트박스 쓴거 내용 읽음.
				appendText("나 : "+str); // 내 gui(Servergui)에  내용 추가됨.
				cs.sendText(str); // 내 outputstream 에 담음으로써 상대방 inputstream 으로 읽어들이게 해줌.
				
				Serverjt.setText(""); // 텍스트박스 null로
			}
		});
		setSize(300,600);
		setVisible(true);
		cs.OpenServer();
	}
	public void appendText(String text) { // gui 기존의 내용까지 다 합해서 나타내줌.
		jatext=jatext+text;
		Serverja.setText(jatext);
	}
	
	public static void main(String[] args) {
		new ServerGui();
	}
}
