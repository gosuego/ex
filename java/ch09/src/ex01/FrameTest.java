package ex01;
import javax.swing.*;
public class FrameTest {

	public static void main(String[] args) {
		JFrame f = new JFrame("Frame Test");
		
		f.setSize(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
