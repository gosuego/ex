package ex04;
import java.awt.Color;
import javax.swing.*;
public class MyFrame extends JFrame{
	
	public MyFrame() {
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		
		panel.setBackground(Color.YELLOW);
		
		panelA.setBackground(Color.green);
		JLabel label1 = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
		panelA.add(label1);
		
		JButton button = new JButton("콤보피자");
		JButton button2 = new JButton("포테토 피자");
		JButton button3 = new JButton("불고기 피자");
		
		panelB.add(button);
		panelB.add(button2);
		panelB.add(button3);
		
		JLabel label2 =new JLabel("개수");
		JTextField field1 = new JTextField(10);
		panelB.add(label2);
		panelB.add(field1);
		
		panelB.setBackground(Color.orange);
		
		panel.add(panelA);
		panel.add(panelB);
		add(panel);
		setVisible(true);
	}

}
