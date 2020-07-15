package prac04;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VibratingFrame extends JFrame{
	public VibratingFrame() {
		setTitle("진동하는 레이블 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel label = new JLabel("진동 레이블");
		label.setFont(new Font("고딕", Font.PLAIN, 20));
		label.setLocation(100, 100);
		label.setSize(150, 20);
		c.add(label);
		
		setSize(300,300);
		setLocation(100,100);
		setVisible(true);
		
		VibratingThread thread = new VibratingThread(label);
		thread.start();
	}
	
	class VibratingThread extends Thread{
		private Component comp;
		public VibratingThread(Component comp) {
			this.comp = comp;
		}
		public void run() {
			Random r = new Random();
			int y = comp.getY();
			int x = comp.getX();
			
			while(true) {
				try {
					Thread.sleep(10);
				}catch(InterruptedException e) {return;}
				int sign = (r.nextBoolean())? 1 : -1;
				int tmpX = x + r.nextInt(5)*sign;
				
				sign = (r.nextBoolean())? 1 : -1;
				int tmpY = x + r.nextInt(5)*sign;
				
				comp.setLocation(tmpX, tmpY);
				
			}
		}
	}

	public static void main(String[] args) {
		new VibratingFrame();
	}

}
