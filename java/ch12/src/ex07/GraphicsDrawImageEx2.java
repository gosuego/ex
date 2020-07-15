package ex07;
import java.awt.*;
import javax.swing.*;
public class GraphicsDrawImageEx2 extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx2() {
		setTitle("패널의 크기에 맞추어 이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("Images/image0.jpg");
		private Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawImageEx2();
	}

}
