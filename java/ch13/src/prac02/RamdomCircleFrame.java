package prac02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RamdomCircleFrame extends JFrame {
	public RamdomCircleFrame() {
		super("원을 일정한 시간 간격으로 이동 시키기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new CirclePanel());
		setSize(300, 300);
		setVisible(true);
	}
	class CirclePanel extends JPanel implements Runnable{
		int x = 100;
		int y = 100;
		
		public CirclePanel() {
			new Thread(this).start();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.drawOval(x, y, 50, 50);
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {return;}
				x = (int)(Math.random()*this.getWidth());
				y = (int)(Math.random()*this.getHeight());
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		new RamdomCircleFrame();
	}

}
