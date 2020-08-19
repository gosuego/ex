package ex03;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
public class ImageLabelTest extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public ImageLabelTest() {
		setTitle("이미지 레이블");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		label = new JLabel("이미지를 보려면 아래 버튼을 누르세요");
		
		button = new JButton("이미지 레이블");
		ImageIcon icon = new ImageIcon("image/icon/gif");
		button.setIcon(icon);
		
		button.addActionListener(this);
		panel.add(label);
		panel.add(button);
		
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		ImageLabelTest t = new ImageLabelTest();
	}
	public void actionPerformed(ActionEvent e) {
		ImageIcon dog = new ImageIcon("images/dog.gif");
		
		label.setIcon(dog);    //출력
		label.setText(null);
	}

}
