package ex00;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FourImageFrame extends JFrame {
	FourImageFrame(){
		super("4 Images");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,4,10,10));
		
		ImageIcon img [] = new ImageIcon [4];
		/*img[0] = new ImageIcon("images/icon1.png");
		img[1] = new ImageIcon("images/icon2.png");
		img[2] = new ImageIcon("images/icon3.png");
		img[3] = new ImageIcon("images/icon4.png");*/
		
		for(int i = 0; i<img.length; i++) {
			img[i] = new ImageIcon("images/icon"+(i+1)+".png");
			c.add(new JLabel(img[i]));
		}
		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FourImageFrame();
	}

}
