package ex00;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FocusPracticeFrame extends JFrame {
	JTextField tf = new JTextField(10);
	
	public FocusPracticeFrame() {
		setTitle("Focus Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(new JLabel("입력한 후 다른 창에 마우스를 클릭하면 대문자로 변합니다."));
		add(tf);
		
		tf.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				JTextField t = (JTextField)e.getSource();
				t.setText(t.getText().toUpperCase());
			}
		});
		
		setSize(400,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FocusPracticeFrame();
	}

}
