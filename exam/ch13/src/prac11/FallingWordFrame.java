package prac11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FallingWordFrame extends JFrame{
	private GamePanel gamePanel = null;
	private ControlPanel controlPanel = null;
	
	public FallingWordFrame() {
		super("떨어지는 단어 맞추기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		gamePanel = new GamePanel();
		c.add(gamePanel, BorderLayout.CENTER);
		controlPanel = new ControlPanel(gamePanel);
		c.add(controlPanel, BorderLayout.SOUTH);
		
		setSize(300, 400);
		setVisible(true);
		gamePanel.startGame();
	}
	class ControlPanel extends JPanel{
		private GamePanel gamePanel;
		private JTextField input = new JTextField(15);
		
		public ControlPanel(GamePanel gamePanel) {
			this.gamePanel = gamePanel;
			this.setLayout(new FlowLayout());
			this.setBackground(Color.LIGHT_GRAY);
			add(input);
			
			input.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField tf = (JTextField)e.getSource();
					String text = tf.getText();
					if(text.equals("그만"))
						System.exit(0);
					if(!gamePanel.isGameOn())
						return;
					
					boolean match = gamePanel.matchWord(text);
					if(match == true) {
						gamePanel.printResult("성공");
						gamePanel.stopGame();
						gamePanel.startGame();
						tf.setText("");
					}else {
						gamePanel.printResult(tf.getText() + " 틀림");
					}
				}
			});
		}
	}
	class GamePanel extends JPanel{
		private JLabel label = new JLabel();
		private JLabel resLabel = new JLabel();
		private Words words = null;
		private String fallingWord = null;
		private FallingThread thread = null;
		private boolean gameOn = false;
		
		public GamePanel() {
			setLayout(null);
			add(label);
			
			resLabel.setLocation(0,0);
			resLabel.setSize(100,30);
			add(resLabel);
			words = new Words("images/words.txt");
		}
		public boolean isGameOn() {
			return gameOn;
		}
		public void stopGame() {
			if(thread == null)
				return;
			thread.interrupt();
			thread = null;
			gameOn = false;
		}
		public void stopSelfAndNewGame() {
			startGame();
		}
		public void printResult(String text) {
			resLabel.setText(text);
		}
		public void startGame() {
			fallingWord = words.getRandomWord();
			label.setText(fallingWord);
			label.setSize(200, 30);
			label.setLocation((getWidth()-200)/2, 0);
			label.setForeground(Color.magenta);
			label.setFont(new Font("Tahoma", Font.ITALIC, 20));
			
			thread = new FallingThread(this, label);
			thread.start();
			gameOn = true;
		}
		public boolean matchWord(String text) {
			if(fallingWord != null && fallingWord.equals(text))
				return true;
			else
				return false;
		}
		
		class FallingThread extends Thread{
			private GamePanel panel;
			private JLabel label;
			private long delay = 200;
			private boolean falling = false;
			
			public FallingThread(GamePanel panel, JLabel label) {
				this.panel = panel;
				this.label = label;
			}
			public boolean isFalling() {
				return falling;
			}
			public void run() {
				falling = true;
				while(true) {
					try {
						sleep(delay);
						int y = label.getY() +5;
						if(y >= panel.getHeight()-label.getHeight()) {
							falling = false;
							label.setText("");
							panel.printResult("시간초과실패");
							panel.stopSelfAndNewGame();
							break;
						}
						label.setLocation(label.getX(), y);
						GamePanel.this.repaint();
					}catch (InterruptedException e) {
						falling = false;
						return;
					}
				}
			}
		}
	}
	class Words {
		private Vector<String> wordVector = new Vector<String>();
		
		public Words(String fileName) {
			try {
				Scanner scanner = new Scanner(new FileReader(fileName));
				while(scanner.hasNext()) {
					String word = scanner.nextLine();
					wordVector.add(word);
				}
				scanner.close();
			} catch(FileNotFoundException e) {
				System.out.println("file not found error");
				System.exit(0);
			}
		}
		public String getRandomWord() {
			final int WORDMAX = wordVector.size();
			int index = (int)(Math.random()*WORDMAX);
			return wordVector.get(index);
		}
	}
	public static void main(String[] args) {
		new FallingWordFrame();
	}

}
