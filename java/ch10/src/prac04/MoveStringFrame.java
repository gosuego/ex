package prac04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MoveStringFrame extends JFrame {
	public MoveStringFrame() {
		super("LEFT키고 문자열 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel la = (JLabel)e.getSource();
					String text = la.getText(); //텍스트 하나씩 밀려남
					String front = text.substring(0,1);
					String last = text.substring(1);
					la.setText(last.concat(front));
				}
			}
		});
		c.add(label);
		setSize(250, 100);
		setVisible(true);
		
		label.setFocusable(true); //레이블이 포커스를 받을 수 있도록 지정
		label.requestFocus(); //레이블에 키 이벤트 포커스 설정
	}

	public static void main(String[] args) {
		new MoveStringFrame();
	}

}


//JLabel = la = new JLabel("Love java");
//la.setFont(new Font("Arial", Font.PLAIN, 10));
//Font f = la.getFont();
//int size = f.getSize();
//la.setFont(new Font("Arial", Font.PLAIN, size+5));
