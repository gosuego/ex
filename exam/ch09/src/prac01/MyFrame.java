package prac01;

import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		//Container c = getcontentPane();
		//c.setLayout(null);
		setSize(400, 200); //사이즈 지정
		setTitle("Let's study Java");  //제목 짓기
		setVisible(true);   //프레임 화면 출력
		//ctrl spacebar01
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
