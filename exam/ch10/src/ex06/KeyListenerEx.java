package ex06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class KeyListenerEx extends JFrame {
	private JLabel [] keyMessage;
	
	public KeyListenerEx() {
		setTitle("kryListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		
		keyMessage = new JLabel [3];
		keyMessage [0] = new JLabel(" getkeycode() ");
		keyMessage [1] = new JLabel(" getkeyChar() ");
		keyMessage [2] = new JLabel(" getkeyText() ");
		
		for(int i = 0; i<keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.yellow);
		}
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("KeyPressed");
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("KeyReleased");
		}
		public void keyTyped(KeyEvent e) {
			System.out.println("KeyTyped");
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}
