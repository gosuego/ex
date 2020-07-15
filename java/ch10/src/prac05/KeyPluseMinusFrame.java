package prac05;
//출력된 "Love Java"를 -+키로 크기 조절하는 프로그램
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPluseMinusFrame extends JFrame {
	public KeyPluseMinusFrame() {
		super("+,- 키로 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label = new JLabel("Love Java");
		c.add(label);

		label.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '+') {
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));
				} else if (e.getKeyChar() == '-') {
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if (size <= 5)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));
				}
			}
		});
		c.add(label);
		setSize(300, 150);
		setVisible(true);

		label.setFocusable(true); // 레이블이 포커스를 받을 수 있도록 지정
		label.requestFocus(); // 레이블에 키 이벤트 포커스 설정
	}

	public static void main(String[] args) {
		new KeyPluseMinusFrame();
	}

}
