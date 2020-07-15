package ex00;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;

public class TabelExam extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public TabelExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		String[] title = {"번호", "이름", "입사일"};
		String[][] data = {
				{"1", "홍길동", "2010-03-10"},{"2", "김철호", "2011-10-17"}, {"3", "박민경", "2015-05-20"}};
		table = new JTable(data, title);
		scrollPane.setViewportView(table);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new TabelExam();
	}

}
