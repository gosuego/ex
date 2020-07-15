package ex08;
import java.awt.*;
import javax.swing.*;
public class TextFieldEx extends JFrame {
	public TextFieldEx() {
		setTitle("텍스트필드 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 "));
		c.add(new JTextField(20));
		c.add(new JLabel());
		c.add(new JTextField("문예창작과", 20));
		c.add(new JLabel("주소 "));
		c.add(new JTextField("서울시 ...", 20));
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
