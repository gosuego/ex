package ex04;
import java.awt.*;
import javax.swing.*;
public class GraphicsDrawRoundRectEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawRoundRectEx() {
		setTitle("drawPoundRect 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200, 170);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawRoundRect(20, 20, 120, 80, 40, 60);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawRoundRectEx();
	}

}
