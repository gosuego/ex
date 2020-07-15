package prac02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseDraggingFrame extends JFrame {
	public MouseDraggingFrame() {
		super("드래깅동안 YELLOW로 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.green);
		
		MyMouseListener ml = new MyMouseListener();
		c.addMouseMotionListener(ml);
		c.addMouseListener(ml);
		
		setSize(250, 150);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			JComponent c = (JComponent)e.getSource();
			c.setBackground(Color.yellow);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			JComponent c = (JComponent)e.getSource();
			c.setBackground(Color.GREEN);
		}
	}

	public static void main(String[] args) {
		new MouseDraggingFrame();
	}

}
