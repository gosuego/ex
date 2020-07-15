package prac06;
//출력 된 "C"를 마우스로 클릭 할 때 마다 랜덤하게 위치가 바뀌는 프로그램
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClickPracticeFrame extends JFrame {
	public ClickPracticeFrame() {
		super("틀릭 연습 용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel label = new JLabel("C");
		c.add(label);
		
		label.setLocation(100,100);
		label.setSize(20,20);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				Container c = la.getParent();
				
				int xBound = c.getWidth() - la.getWidth();
				int yBound = c.getHeight() - la.getHeight();
				int x = (int)(Math.random()*xBound);
				int y = (int)(Math.random()*yBound);
				la.setLocation(x, y);
			}
			
		});
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClickPracticeFrame();
	}

}
