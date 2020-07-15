package ex08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OptionPaneEx extends JFrame{
	public OptionPaneEx() {
		setTitle("옵션 팬 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setSize(500, 200);
		c.add(new MyPanel(), BorderLayout.NORTH);
		setVisible(true);
	}
	class MyPanel extends Panel{
		private JButton inputBtn = new JButton("Input name");
		private JTextField tf = new JTextField(10);
		private JButton confirmBtn = new JButton("Confirm");
		private JButton messageBtn = new JButton("Message");
	
	public MyPanel() {
		setBackground(Color.LIGHT_GRAY);
		add(inputBtn);
		add(confirmBtn);
		add(messageBtn);
		add(tf);
		
		inputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("이름을 입력하세요.");
				if(name != null)
					tf.setText(name);
				}
		});
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "계속할 것입니까?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.CLOSED_OPTION)
					tf.setText("Just Close without Selection");
				else if(result == JOptionPane.YES_OPTION)
					tf.setText("Yes");
					else
						tf.setText("No");
		
			
			}
		});
				
			
		messageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "조심하세요", "Message", JOptionPane.ERROR_MESSAGE);;
			}
		});
	}
}
	public static void main(String[] args) {
		new OptionPaneEx();
	}

}
