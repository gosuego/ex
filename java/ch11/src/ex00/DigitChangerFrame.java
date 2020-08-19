package ex00;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class DigitChangerFrame extends JFrame {
	JTextField src = new JTextField(8);  //입력용 텍스트 필드
	JTextField dest = new JTextField(8); //출력룔 텍스트 필드
	JRadioButton radio [] = new JRadioButton [4];
	String [] text = {"delcimal", "binary", "octal", "hex"};
	
	public DigitChangerFrame() {
		super("Digit Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();
		MyItemListener listener = new MyItemListener();
		
		add(src);
		add(new JLabel("==>"));
		add(dest);
		
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			radio[i].addItemListener(listener);
			add(radio[i]);
			g.add(radio[i]);
		}
		
		setSize(280, 150);
		setVisible(true);
		
	}
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() != ItemEvent.SELECTED)
				return;
			int n;
			String text = ((JRadioButton)e.getItem()).getText();
			try {
				switch(text) {
				case "decimal":
					n= Integer.parseInt(src.getText());
					dest.setText(Integer.toString(n));
					break;
				case "octal" :
					n = Integer.parseInt(src.getText());
					dest.setText(Integer.toOctalString(n));
					break;
				case "hex" :
					n= Integer.parseInt(src.getText());
					dest.setText(Integer.toHexString(n));
					break;
				}
			}catch(NumberFormatException exp) {
				dest.setText("변환할 수 없습니다.");
			}
	}
	}
public static void main(String[] args) {
	new DigitChangerFrame();
}
}
