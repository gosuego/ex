package prac05;
import java.awt.*;
import javax.swing.*;
public class GridLayoutColor extends JFrame {
	public GridLayoutColor() {
		super("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 4));
		JLabel [] label = new JLabel [16];
		
		Color [] color = {Color.red, Color.orange, Color.yellow, Color.green,
				Color.cyan, Color.blue, Color.MAGENTA, Color.gray, Color.pink,
				Color.LIGHT_GRAY, Color.white, Color.darkGray, Color.black,
				Color.ORANGE, Color.blue, Color.MAGENTA};
		
		for(int i = 0; i<label.length; i++) {
			label[i] = new JLabel(Integer.toString(i));
			label[i].setOpaque(true);
			label[i].setBackground(color[i]);   //컬러가 들어간 컴포넌트
			c.add(label[i]);
		}
		setSize(500,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutColor();
	}

}
