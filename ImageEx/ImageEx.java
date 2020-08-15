import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEx extends JFrame{
	public ImageEx() {
		setTitle("이미지연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		ImagePanel ip = new ImagePanel();
		c.add(ip);
		pack();
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageEx();
	}
}

class ImagePanel extends JPanel{
	private ImageIcon imageicon = new ImageIcon("img\\mars.jfif");
	private Image img = imageicon.getImage();
	public ImagePanel() {
		repaint();	
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		
	}
}
