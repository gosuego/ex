package ex07;
import java.awt.*;
import javax.swing.*;
public class ConCompEx extends JFrame {
	ConCompEx(){
		setTitle("Container & Componet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		setBackground(Color.gray);
		
		Panel1 p1 = new Panel1();
		p1.setSize(150, 150);
		p1.setLocation(10,10);
		add(p1);
		Panel2 p2 = new Panel2();
		p2.setSize(150, 150);
		p2.setLocation(170, 10);
		add(p2);
		
		JButton btn = new JButton("OK");
		btn.setLocation(130, 170);
		btn.setSize(70, 30);
		add(btn);
		setSize(350, 250);
		setVisible(true);
	}
	class Panel1 extends JPanel{
		Panel1(){
			setBackground(Color.YELLOW);
			add(new JLabel("Type ID"));
			add(new JTextField(10));
			add(new JLabel("Type Password"));
			add(new JTextField(10));
		}
	}
	class Panel2 extends JPanel{
		Panel2(){
			setBackground(Color.green);
			add(new JLabel("Please Check"));
			add(new JCheckBox("C# JCheckBox"));
			add(new JCheckBox("C++ JcheckBox"));
		}
		
	}
	public static void main(String[] args) {
		new ConCompEx();
	}

}
