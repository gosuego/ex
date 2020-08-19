package ex00;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TwoRadioFrame extends JFrame {
	JRadioButton red = new JRadioButton("빨강");
	JRadioButton blue = new JRadioButton("파랑");
	JRadioButton green = new JRadioButton("연두");
	
	public TwoRadioFrame() {
		super("Two Radio Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		ButtonGroup g = new ButtonGroup();
		g.add(red);
		g.add(blue);
		g.add(green);
		
		add(red);
		add(blue);
		add(green);
		MyItemListener listener = new MyItemListener();
		red.addItemListener(listener);
		blue.addItemListener(listener);
		green.addItemListener(listener);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() != ItemEvent.SELECTED)
				return;
			if(e.getItem() == red) {
				getContentPane().setBackground(Color.RED);
			}if(e.getItem() == blue) {
				getContentPane().setBackground(Color.blue);
				
			}else if(e.getItem() == green) {
				getContentPane().setBackground(Color.GREEN);
			}
		}
		
	}
	public static void main(String[] args) {
		new TwoRadioFrame();
	}

}
