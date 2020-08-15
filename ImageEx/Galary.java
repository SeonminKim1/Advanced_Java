import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Galary extends JFrame {
	private JLabel la[] = new JLabel[9];
	private String imgpath[] = {
			"img\\bono1.jpg","img\\bono2.jfif","img\\bono3.jfif",
			"img\\bono4.jpg","img\\bono5.png","img\\bono6.jfif",
			"img\\bono7.jfif","img\\bono8.jfif","img\\bono9.jpg"};
	public Galary() {
		setTitle("Galary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		for(int i=0; i<la.length; i++) {
			la[i]=new JLabel(new ImageIcon(imgpath[i]));
			pack();
			add(la[i]);
			la[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JLabel la = (JLabel)e.getSource();
					if(e.getClickCount()==2) {
						la.setSize(300,300);
					}
					else if (e.getClickCount()==1) {
						la.setBounds(0,0,900,900);
					}
				}
			});
		}
		
		setSize(900, 900);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Galary(); // label을 이용한 갤러리 .... -> drawImage를 이용해서 하나 더만들기..
	}
}
