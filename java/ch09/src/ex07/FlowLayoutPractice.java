package ex07;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutPractice extends JFrame {
	public FlowLayoutPractice() {
		super("FlowLayout Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setLayout(new FlowLayout());
		add(new JLabel("100"));
		add(new JLabel("+"));
		add(new JLabel("200"));
		add(new JButton("="));
		add(new JLabel("300"));

		setSize(400, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutPractice();
	}

}
