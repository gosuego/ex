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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DicServerFrame extends JFrame{
	private JTextField eng = new JTextField(10);   //영어단어 입력
	private JTextField kor = new JTextField(10);   //한국어 단어 입력
	private JButton saveBtn = new JButton("저장");  //저장 버튼
	private JButton searchBtn = new JButton("찾기");  //찾기 버튼
	private JTextArea ta = new JTextArea(7, 25);    
	private HashMap<String, String> dic = new HashMap<String, String>();
	
	
	public DicServerFrame() {
		super("단어 저장기");  // 프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우를 닫으면 프로그램을 종료하도록 설정
		setSize(350, 300); //창 사이즈
		
		Container c = getContentPane();// 컨텐트팬을 알아낸다.
		c.setBackground(Color.CYAN); // 창배경색을 하늘색으로 설정
		c.setLayout(new FlowLayout()); //컨텐트팬에 FlowLayout 배치관리자 달기
		c.add(new JLabel("영어")); // 툴바에 영어 달기
		c.add(eng);
		c.add(new JLabel("한글")); //툴바에 한글 달기
		c.add(kor);
		c.add(saveBtn);  //저장 버튼 달기
		c.add(searchBtn); //검색버튼 달기
		
		saveBtn.setBackground(Color.yellow);  //저장 버튼 배경색 설정
		searchBtn.setBackground(Color.GREEN);  //검색 버튼 배경색 설정
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("삽입(" + eng.getText() + "," + kor.getText() + ")\n"); //저장되는 단어 출력
				dic.put(eng.getText(), kor.getText()); //입력되는 값 저장
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = dic.get(eng.getText());
						if(s == null)
							s = "없음";   // 단어가 없을 때  한국어 칸에 없음 출력
						kor.setText(s);
			}
		});
		
		c.add(new JScrollPane(ta));
		setVisible(true);
		
		startService();
	}

	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
	}
	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class ServerThread extends Thread {
		
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			
			try {
				listener = new ServerSocket(9993);  //서버 소켓 생성. 서버의 9993번에 포트 연결
			}catch (IOException e1) {
				handleError(e1.getMessage());
			}
			while(true) {
				try {
					socket = listener.accept(); //클라이언트로부터 연결 요청 대기
					
					ServiceThread th = new ServiceThread(socket);
					th.start();
				}
				catch(IOException e) {
					handleError(e.getMessage());
					break;
				}
			}
			try {
				listener.close(); //서버 소켓 닫기
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	
		
	}
	
	class ServiceThread extends Thread{
		private Socket socket;
		
		public ServiceThread(Socket socket) {
			this.socket = socket;
		}
	
	public void run() {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));  // 입출력 스트림 생성
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String engText = in.readLine();
				String korText = dic.get(engText);
				if(korText == null)
					korText = "없음";
				
				out.write(korText+"\n");
				out.flush();
				
				ta.append("검색 (" + korText + ")\n"); //클라이언트에서 검색했을 때 한글 출력
				int pos = ta.getText().length();
				ta.setCaretPosition(pos);
			}
		}
		catch (IOException e) {
			return;
		}
	}
}
	
	public static void main(String[] args) {
		new DicServerFrame();  //실행문
	}

}
