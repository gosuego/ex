package ex00;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame {
	class MyThread extends Thread {
		private JLabel label;
		private int x,y;
		
		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 100, 100);
			add(label);
		}
		public void run() {
			for (int i = 0; i<200; i++) {
				x+=10*Math.random();
				label.setBounds(x, y, 100, 100);
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public CarGame() {
		setTitle("CarRace");
		setSize(600, 600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		(new MyThread("./images/car1.gif", 100, 0)).start();
		(new MyThread("./images/car2.gif", 100, 50)).start();
		(new MyThread("./images/car3.gif", 100, 100)).start();
		(new MyThread("./images/car1.gif", 100, 150)).start();
		(new MyThread("./images/car2.gif", 100, 200)).start();
		(new MyThread("./images/car3.gif", 100, 250)).start();
		(new MyThread("./images/car2.gif", 100, 300)).start();
		(new MyThread("./images/car3.gif", 100, 350)).start();
		(new MyThread("./images/car1.gif", 100, 400)).start();
		(new MyThread("./images/car2.gif", 100, 450)).start();
		setVisible(true);
	}

	public static void main(String[] args) {
		new CarGame();
	}

}
