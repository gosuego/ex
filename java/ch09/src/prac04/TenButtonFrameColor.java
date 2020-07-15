package prac04;
import java.awt.*;
import javax.swing.*;

public class TenButtonFrameColor extends JFrame {
	public TenButtonFrameColor() {
		super("Ten Button Frame Color");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		Container c = getContentPane(); 
		c.setLayout(new GridLayout(1, 10));
		
		JButton [] btn = new JButton [10]; 
		Color [] color = {Color.red, Color.orange, Color.YELLOW, Color.GREEN, Color.cyan,
				Color.BLUE, Color.magenta, Color.gray, Color.pink, Color.LIGHT_GRAY};
		
		for(int i = 0; i<btn.length; i++) {
			btn[i] = new JButton(Integer.toString(i));
			btn[i].setBackground(color[i]);   //컬러가 들어간 컴포넌트
			c.add(btn[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TenButtonFrameColor();
	}

}
