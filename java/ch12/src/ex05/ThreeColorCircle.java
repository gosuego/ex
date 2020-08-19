package ex05;

import java.awt.*;
import javax.swing.*;

public class ThreeColorCircle extends JFrame {
	public ThreeColorCircle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(400, 300);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillArc(50, 50, 100, 100, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(50, 50, 100, 100, 210, 120);
			g.setColor(Color.YELLOW);
			g.fillArc(50, 50, 100, 100, 330, 120);

			g.setColor(Color.blue);
			g.fillArc(200, 50, 100, 100, 90, 90);
			g.setColor(Color.YELLOW);
			g.fillArc(200, 50, 100, 100, 180, 90);
			g.setColor(Color.green);
			g.fillArc(200, 50, 100, 100, 270, 90);
			g.setColor(Color.red);
			g.fillArc(200, 50, 100, 100, 360, 90);

		}
	}

	public static void main(String[] args) {
		new ThreeColorCircle();
	}

}
