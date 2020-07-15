package ex04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCounter extends JFrame implements ActionListener{
	private JLabel label, label1;
	private JButton button;
	private int count = 0;
	
	public MyCounter() {
		JPanel panel = new JPanel();
		label = new JLabel("Counter");
		panel.add(label);
		
		label1 = new JLabel(""+count);
		label1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));
		
		panel.add(label1);
		button = new JButton("카운터 증가");
		panel.add(button);
		button.addActionListener(this);
		
		add(panel);
		setSize(300, 200);
		setTitle("My counter");
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		count++;
		label1.setText(count +" ");
	}
}
public class CounterTest {
	public static void main(String[] args) {
		new MyCounter();
	}

}
