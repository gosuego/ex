package prac03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalculationServerFrame extends JFrame {
	private JTextArea log = new JTextArea();
	public CalculationServerFrame() {
		super("멀티스레드 계산 서버");
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("계산 서버 입니다"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		new ServerThread().start();
	}
		class ServerThread extends Thread{
			public void run() {
				ServerSocket listener = null;
				Socket socket = null;
				try {
					listener = new ServerSocket(9997);
					while (true) {
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
						String first = in.readLine();
						String operator = in.readLine();
						String second = in.readLine();
						int a = Integer.parseInt(first);
						int b = Integer.parseInt(second);
						
						String resText = "";
						int res = 0;
						switch(operator) {
						case "+" : res = a + b; resText = Integer.toString(res); break;
						case "-" : res = a - b; resText = Integer.toString(res); break;
						case "*" : res = a * b; resText = Integer.toString(res); break;
						case "/" : 
							if(b == 0)resText = "0으로 나눌 수 없음";
							else {
								res = a / b;
								resText = Integer.toString(res);
							}
							break;
							default:
								resText = "잘못된 연산";
						}
						
						out.write(resText+"\n");
						out.flush();
						log.append(first + operator + second + "=" + resText+ "\n");
					}catch (IOException e) {
						log.append("연결 종료\n");
						System.out.println("연결 종료");
						return;
					}
				}
			}
		}
		public static void main(String[] args) {
			new CalculationServerFrame();
		
	}
}
