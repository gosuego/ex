package prac01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoveJava extends JFrame {
	public LoveJava() {
		super("마우스 올리기 내리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("Love Java");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("사랑해");
			}
		});
		setSize(250,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LoveJava();
	}

}
