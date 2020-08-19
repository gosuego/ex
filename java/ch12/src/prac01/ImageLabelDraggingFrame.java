package prac01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ImageLabelDraggingFrame extends JFrame {
	public ImageLabelDraggingFrame() {
		super("이미지 레이즐 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/apple.jpg");
		JLabel imageLabel = new JLabel(icon);
		
		imageLabel.setSize(icon.getIconHeight(), icon.getIconWidth());
		imageLabel.setLocation(100,100);
		
		MyMouseListener ml = new MyMouseListener();
		imageLabel.addMouseListener(ml);
		imageLabel.addMouseMotionListener(ml);
		
		c.add(imageLabel);
		setSize(300, 300);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter {
		private Point startP = null;
		
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}
		public void mouseDragged(MouseEvent e) {
			Point endP = e.getPoint();
			Component la = (JComponent)(e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x+endP.x - startP.x, p.y + endP.y - startP.y);
			la.getParent().repaint();
		}
	}

	public static void main(String[] args) {
		new ImageLabelDraggingFrame();
	}

}
