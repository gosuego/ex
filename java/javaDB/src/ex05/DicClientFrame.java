package ex05;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DicClientFrame extends JFrame{
	private Socket socket = null;
	private JTextField eng = new JTextField(10); //영어 입력창
	private JTextField kor = new JTextField(10); //한글이 뜨는 창
	private JButton searchBtn = new JButton("찾기"); // 찾기 버튼 생성
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	public DicClientFrame() {
		super("단어 검색");  // 프레임 제목 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창을 닫으면 프로그램 종료
		
		Container c = getContentPane();// 컨텐트팬을 알아낸다.
		c.setBackground(Color.pink); // 창배경색을 분홍색으로 설정
		c.setLayout(new FlowLayout());//컨텐트팬에 FlowLayout 배치관리자 달기
		c.add(new JLabel("영어")); //툴바에 부착
		c.add(eng);
		c.add(new JLabel("한글"));  //툴바에 부착
		c.add(kor);
		
		c.add(searchBtn);
		try {
			setupConnection();
		}catch (IOException e) {
			handleError(e.getMessage());
		}
		searchBtn.addActionListener(new MyActionListener());
		searchBtn.setBackground(Color.white); // 찾기 버튼을 하얀색으로 변경
		
		setSize(400, 120);
		setVisible(true);
	}
	
	private void setupConnection() throws IOException {
		socket = new Socket("localhost", 9993); //클라이언트 소켓 생성. 서버의 9993번에 포트 연결
		System.out.println("연결됨");  //서버에 연결해서 정보를 확인함
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //소켓 입력스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //소켓 출력 스트림
	}

	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			out.write(eng.getText()+"\n"); //키보드에서 읽은 문자열 전송
			out.flush();
			String text = in.readLine();  //서버로 부터 검색 결과 수신
			kor.setText(text);
		}catch(IOException e2) {
			handleError(e2.getMessage());
		}
	}
	}
	public static void main(String[] args) {
		new DicClientFrame();  //실행문
	}

}
