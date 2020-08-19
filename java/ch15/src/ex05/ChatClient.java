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
import java.net.Socket;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	// JTextField 를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private Receiver receiver = null;
	// JTextField 객체로서 보내는 정보를 담는 객체
	private JTextField sender = null;
	
	public ChatClient() {
		setTitle("클라이언트 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		c.add(new JScrollPane(receiver), BorderLayout.CENTER);
		c.add(sender, BorderLayout.SOUTH);
		
		setSize(400, 200);
		setVisible(true);
		
		try {
			setupConnection();
		}catch (IOException e) {
			handleError(e.getMessage());
		}
		//상대로부터 메시지 수신을 위한 스레드 생성
		Thread th = new Thread(receiver);
		th.start();
	}
	private void setupConnection() throws IOException{
		socket = new Socket("localhost", 7777);
		receiver.append("서버에 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
	}
	private static void handleError (String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable{
		
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine();
				}catch(IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n 서버 : " + msg); // 받은 문자열을 JTextArea에 출력
				int pos = this.getText().length();
				this.setCaretPosition(pos); //caret(커서)을 가장 마지막으로 이동
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg+ "\n");
				out.flush();
				
				receiver.append("\n클라이언트 : " + msg);
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null);// 입력창의 문자열 지움
			}catch (IOException e1) {
				handleError(e1.getMessage());
				
			}
		}
	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
