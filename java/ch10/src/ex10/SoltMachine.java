package ex10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCounter extends JFrame implements ActionListener{
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	
	public MyCounter() {
		setSize(500, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		labels =new JLabel[3];
		
		numbers = new int[3];
		
		for(int i = 0; i< 3; i++) {
			labels[i] = new JLabel(""+ numbers[i]);
			labels[i].setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 100));
			labels[i].setSize(100, 100);
			labels[i].setLocation(100 + 100 * i, 20);
			panel.add(labels[i]);
		}
		
		button = new JButton("스핀");
		button.setSize(250, 50);
		button.setLocation(100, 150);
		panel.add(button);
		button.addActionListener(this);
		
		add(panel);
		setTitle("My Game");
		
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i <3; i++) {
			numbers[i] = (int)(Math.random()*3);
			labels[i].setText(""+numbers[i]);
		}
		if(numbers[0]==numbers[1] && numbers[1]==numbers[2])
			System.out.println("당첨입니다");
		else
			System.out.println("다음기회에");
	}
}
public class SoltMachine {
	public static void main(String[] args) {
		new MyCounter();
	}

}
