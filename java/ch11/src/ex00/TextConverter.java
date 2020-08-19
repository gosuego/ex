package ex00;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextConverter extends JFrame {
	JButton converter;
	JButton canceler;
	JTextArea textIn;
	JTextArea textOut;
	//private Component buttonPanel;

	public TextConverter() {
		super("텍스트 변환");

		textIn = new JTextArea(10, 14);
		
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true); // 자동 줄바꿈
		textOut.setLineWrap(true);
		textOut.setLineWrap(false); // 비활성화

		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);

		converter = new JButton("변환");
		canceler = new JButton("취소");
		converter.addActionListener(new ButtonActionListener());
		canceler.addActionListener(new ButtonActionListener());
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(converter);
		buttonPanel.add(canceler);

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(BorderLayout.CENTER, textAreaPanel);
		mainPanel.add(BorderLayout.SOUTH, buttonPanel);

		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(mainPanel);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == converter) {
				if(e.getSource() == converter) {
					textOut.setText("");
					String result = toEnglish(textIn.getText());
					textOut.append(result);
				}
				if(e.getSource()== canceler) {
					textOut.setText("");
				}
				}
			}

		private String toEnglish(String korean) {
			String result = korean;
			result = result.replace("텍스트", "Text");
			result = result.replace("영어", "English");
			result = result.replace("사과", "Apple");
			result = result.replace("바나나", "Banana");
			return result;
		}

	}

	public static void main(String[] args) {
		TextConverter t = new TextConverter();
	}

}
