package ex07;
import javax.swing.*;
public class BorderExam extends JFrame {
	public BorderExam() {
		setTitle("BorderLayout 테스트");
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");
		JButton button5 = new JButton("버튼5");
		JButton button6 = new JButton("버튼6");
		
		add(button1, "North");
		add(button2, "West");
		add(button6, "South");
		add(button5, "East");
		
		JPanel p1 = new JPanel();
		p1.add(button3);
		p1.add(button4);
		add(p1, "Center");
		
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderExam();
	}

}
