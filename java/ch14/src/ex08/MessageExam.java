package ex08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MessageExam extends JFrame { //제이프레임 상속
	private JPanel contentPane;
	public MessageExam() {
		setTitle("다이얼로그 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button1 = new JButton("Message");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//단순하게 안내문만 출력하는 대화상자
				//showMessageDialog(부모컴포넌트, 메시지)
				JOptionPane.showMessageDialog(MessageExam.this, "Message");
			}
		});
		contentPane.add(button1);
		JButton button2 = new JButton("Confirm");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MessageExam.this, "종료할까요?", null, JOptionPane.YES_NO_OPTION);
				if(result ==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(MessageExam.this, "프로그램을 종료합니다.");
					System.exit(0);
				}
			}
		});
		contentPane.add(button2);
		
		JButton button3 = new JButton("Input");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name =JOptionPane.showInputDialog(MessageExam.this, "이름을 입력하세요.");
				JOptionPane.showInternalMessageDialog(MessageExam.this, name+"님 환영합니다.");
			}
		});
		contentPane.add(button3);
		JButton button4 = new JButton("Option");
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] str = {"추가","수정","삭제"};
				JOptionPane.showOptionDialog(MessageExam.this, "선택하세요.", "작업선택", JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE, null, str, str[2]);
				
			}
		});
		contentPane.add(button4);
		setVisible(true);
	}
	public static void main(String[] args) {


	}

}
