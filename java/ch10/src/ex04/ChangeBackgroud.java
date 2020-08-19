package ex04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame  {
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel;
	MyListener listener = new MyListener();
	
	public MyFrame() {
	setSize(300, 200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setTitle("이벤트 예제");
	panel = new JPanel();
	button1 = new JButton("노란색");
	button1.addActionListener(listener);
	panel.add(button1);
	button2 = new JButton("분홍색");
	button2.addActionListener(listener);
	panel.add(button2);
	button3 = new JButton("연두색");
	button3.addActionListener(listener);
	panel.add(button3);
	
	add(panel);
	setVisible(true);
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				panel.setBackground(Color.yellow);
			}else if (e.getSource() == button2) {
				panel.setBackground(Color.pink);
			}else if (e.getSource() == button3) {
				panel.setBackground(Color.green);
			}
		}
	}
}
public class ChangeBackgroud {

	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}

}
