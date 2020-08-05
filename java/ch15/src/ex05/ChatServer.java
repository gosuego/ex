package ex05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	//JTextArea를 상속받고 Runnable 인처페이스를 구현한 클래스로 받은 정보를 담는 객체
	private Receiver receiver;
	private JTextField sender; //JTeextField 객체로서 보내는 정보를 담는 객체
	private int pos; // 내가 빼먹은 pos>?!
	
	public ChatServer() {
		setTitle("서버 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		//스크롤바를 위해 ScrollPane 이용
		add(new JScrollPane(receiver), BorderLayout.CENTER);
		add(sender, BorderLayout.SOUTH);
		
		setSize(400, 200);
		setVisible(true);
		
		try {
			setupConnection();
			
		}catch (IOException e) {
			handleError(e.getMessage());
		}
		// 상대로부터 메시지 수진을 위한 스레그 생성
		Thread th = new Thread(receiver);
		th.start();
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(7777); //서버 소켓 생성
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable{
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg= in.readLine();
				}catch (IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n  클라이언트 : " + msg);
				int pos = this.getText().length();
				this.setCaretPosition(pos);
			}
		}
	}
	
	
	// JTextfield 에 <Enter> 키 처리
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg+"\n");
				out.flush();
				
				receiver.append("\n서버: " + msg);
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null);
			}catch (IOException e1) {
				handleError(e1.getMessage());
			}
		}
	}
	

	public static void main(String[] args) {
		new ChatServer();
	}

}
