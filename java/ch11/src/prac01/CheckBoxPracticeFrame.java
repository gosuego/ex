package prac01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxPracticeFrame extends JFrame {
	private JButton btn = new JButton("test button");
	public CheckBoxPracticeFrame() {
		super("CheckBox Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox a = new JCheckBox("버튼 비활성화");
		JCheckBox b = new JCheckBox("버튼 감추기");
		c.add(a);
		c.add(b);
		c.add(btn);
		
		a.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
		});
		b.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
		});
		setSize(300, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxPracticeFrame();
	}

}
