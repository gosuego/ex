package prac03;
import java.awt.*;
import javax.swing.*;
public class TenButtonFrame extends JFrame {
	public TenButtonFrame() {
		super("Ten Button Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //닫으면 끝
		
		Container c = getContentPane(); 
		c.setLayout(new GridLayout(1, 10)); //배치관리자
		
		JButton [] btn = new JButton [10];   //10개의 버튼
		for(int i = 0; i<btn.length; i++) {
			btn[i] = new JButton(Integer.toString(i)); //toString
			c.add(btn[i]);
		}
		setSize(500,200);  //화면 사이즈
		setVisible(true);  //화면 출력
	}
	public static void main(String[] args) {
		new TenButtonFrame();
	}

}
