package ex01;
import java.awt.*;
import javax.swing.*;
public class paintJPanelEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {
		setTitle("JPanel의 paintComponet() 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250, 220);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}
	public static void main(String[] args) {
		new paintJPanelEx();
	}

}
