package prac06;

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
	private JTextField eng = new JTextField(10);   
	private JTextField kor = new JTextField(10);
	private JButton saveBtn = new JButton("저장");
	private JButton searchBtn = new JButton("찾기");
	private JTextArea ta = new JTextArea(7, 25);
	private HashMap<String, String> dic = new HashMap<String, String>();
	public DicServerFrame() {
		super("Dic Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 300);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(saveBtn);
		c.add(searchBtn);
		
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("삽입(" + eng.getText() + "," + kor.getText() + "\n");
				dic.put(eng.getText(), kor.getText());
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = dic.get(eng.getText());
						if(s == null)
							s = "없음";
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
				listener = new ServerSocket(9993);
			}catch (IOException e1) {
				handleError(e1.getMessage());
			}
			while(true) {
				try {
					socket = listener.accept();
					
					ServiceThread th = new ServiceThread(socket);
					th.start();
				}
				catch(IOException e) {
					handleError(e.getMessage());
					break;
				}
			}
			try {
				listener.close();
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
					new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String engText = in.readLine();
				String korText = dic.get(engText);
				if(korText == null)
					korText = "없음";
				
				out.write(korText+"\n");
				out.flush();
				
				ta.append("검색 (" + engText + ")\n");
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
		new DicServerFrame();
	}

}
