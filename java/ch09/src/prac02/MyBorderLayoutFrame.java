package prac02;
import java.awt.*;
import javax.swing.*;
public class MyBorderLayoutFrame extends JFrame {
	public MyBorderLayoutFrame() {
		super("BorderLayout Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 7));
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		
		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyBorderLayoutFrame();
	}

}
