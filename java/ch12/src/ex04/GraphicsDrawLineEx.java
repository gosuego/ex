package ex04;
import java.awt.*;
import javax.swing.*;
public class GraphicsDrawLineEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineEx() {
		setTitle("darwLine 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200, 170);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 30, 100, 100);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}

}
