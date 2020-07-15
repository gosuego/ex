package ex00;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuExam extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		MenuExam frame = new MenuExam();
		frame.setVisible(true);
	}
	public MenuExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnNewMenuItem_2 = new JMenuItem("새파일");
		mnNewMenu.add(mnNewMenuItem_2);
		
		JMenuItem mnNewMenuItem = new JMenuItem("열기");
		mnNewMenu.add(mnNewMenuItem);
		
		JMenuItem mnNewMenuItem_1 = new JMenuItem("저장");
		mnNewMenu.add(mnNewMenuItem_1);
		
		JMenuItem miExit = new JMenuItem("종료");
		miExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MenuExam.this, "종료할까요?");
				if(result==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(miExit);
		
		JMenu mnNewMenu_1 = new JMenu("색상");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem miRed = new JMenuItem("Red");
		miRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				getContentPane().setBackground(Color.red);
				
					}
				});
				mnNewMenu_1.add(miRed);
				
				JMenuItem miGreen = new JMenuItem("Green");
				miGreen.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						getContentPane().setBackground(Color.green);
					}
				});
				mnNewMenu_1.add(miGreen);
				
				JMenuItem miBlue = new JMenuItem("Blue");
				miBlue.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						getContentPane().setBackground(Color.blue);
					}
				});
				mnNewMenu_1.add(miBlue);
				
				JMenu mnNewMenu_2 = new JMenu("도움말");
				menuBar.add(mnNewMenu_2);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0,0));
				setContentPane(contentPane);
			}
		//});
	//}

}
