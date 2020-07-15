package prac07;
//글씨 위에 마우스를 올리고 휠을 돌려 크기를 조절하는 프로그램
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseWheelFrame extends JFrame {
	public MouseWheelFrame() {
		super ("마우스 휠을 굴려 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		c.add(label);
		
		label.setFont(new Font("Arial", Font.PLAIN, 15));  // 15 픽셀 크기
		
		label.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int n = e.getWheelRotation();
				if(n<0) {  //up direction 폰트 작게
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if(size <= 5)
						return;
					la.setFont(new Font("Arial", Font.PLAIN, size-5));
				} else { //폰트 크게
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TomesRoman", Font.PLAIN, size+5));
				}
			}
		});
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseWheelFrame();
	}

}
