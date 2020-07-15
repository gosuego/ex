package ex00;

import java.awt.Color;

import javax.swing.JFrame;

public class TenSecondsFrame extends JFrame {
	public TenSecondsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 150);
		setVisible(true);
		TenSecondsThread th = new TenSecondsThread();
		th.start();
	}
	class TenSecondsThread extends Thread{
		public void run() {
			setTitle("실행 시작");
			getContentPane().setBackground(Color.YELLOW);
			try {
				sleep(3000);
			}catch (InterruptedException e) {return;}
			setTitle("실행 종료");
			getContentPane().setBackground(Color.blue);
		}
	}

	public static void main(String[] args) {
		new TenSecondsFrame();
	}

}
