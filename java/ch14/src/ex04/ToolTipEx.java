package ex04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolTipEx extends JFrame {
	private Container contentPane;
	public ToolTipEx() {
		setTitle("툴팁 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 150);
		setVisible(true);
	}
	private void createToolBar() {
		JToolBar bar = new JToolBar("Kitea Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("파일을 생성합니다.");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("파일을 엽니다.");
		bar.add(openBtn);
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));
		saveBtn.setToolTipText("파일을 저장합니다.");
		bar.add(saveBtn);
		bar.add(new JLabel("search"));
		
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("찾고자 하는 문자열을 입력하세요");
		bar.add(tf);
		contentPane.add(bar, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new ToolTipEx();
	}

}
