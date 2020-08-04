package prac04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class SpellCheckerServerFrame extends JFrame {
	private SpellChecker spellChecker = null;
	private JTextArea log = new JTextArea();
	public SpellCheckerServerFrame() {
		super("영어 스펠 체크 서버");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("영어 스펠 체크 서버입니다."));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		spellChecker = new SpellChecker("words.txt");
		if(spellChecker.isFileRead()) {
			log.setText("words.txt 읽기 완료\n");
			new ServerThread().start();
		}
	}
	
	class ServerThread extends Thread {
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9995);
				while(true) {
					socket = listener.accept();
					log.append("클라이언트 연결됨\n");
					new ServiceThread(socket).start();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class SpellChecker {
		private Vector<String> v = new Vector<String>();
		private boolean fileOn = false;
		
		public SpellChecker(String fileName) {
			try {
				Scanner reader = new Scanner(new FileReader(fileName));
				while(reader.hasNext()) {
					String word = reader.nextLine();
					v.add(word);
				}
				reader.close();
				fileOn = true;
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				fileOn = false;
			}
		}

		public boolean isFileRead() {
			return fileOn;
		}
		
		public boolean check(String word) {
			if(v.contains(word))
				return true;
			else
				return false;
		}
	}
	
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		public ServiceThread(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void run() {
			while(true) {
				try {
					String word = in.readLine();
					boolean res = spellChecker.check(word);
					if(res == true) {
						out.write("YES\n");
						log.append(word + "=YES\n");
					}
					else {
						out.write("NO\n");
						log.append(word + "=NO\n");
					}
					out.flush();
				}catch (IOException e) {
					log.append("연결 종료\n");
					System.out.println("연결종료");
					try {
						socket.close();
					}catch (IOException e1) {
						e1.printStackTrace();
					}
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		new SpellCheckerServerFrame();
	}

}
