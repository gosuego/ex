package ex07;
import javax.swing.*;
public class AbsoluteTest extends JFrame {
	
	public AbsoluteTest(){
		setTitle("Absoulute Posittion Test");  //super 아버지꺼 호출해서 쓰는거임
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		JPanel p = new JPanel();
		p.setLayout(null);
		
		JButton b1 = new JButton("Boutton #1");
		p.add(b1);
		JButton b2 = new JButton("Boutton #2");
		p.add(b2);
		JButton b3 = new JButton("Boutton #3");
		p.add(b3);
		
		b1.setBounds(20, 5, 95, 30);
		b2.setBounds(55, 45, 105, 90);
		b3.setBounds(180, 15, 105, 90);
		add(p);
		setVisible(true);
		
		//JButton b1 = new JButton
	}
public static void main(String[] args) {
	new AbsoluteTest();
}
}
