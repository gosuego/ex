package ex03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class GameScoreTest extends JFrame implements ActionListener {
	JTable table;
	JTextField namef;
	JTextField scoref;
	JButton button;
	
	MyTableModel model;
	
	public GameScoreTest() {
		super("명예의 전당");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model = new MyTableModel();
		model.fillTable();
		
		JLabel label = new JLabel("명예의 전당" + JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		table =new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("이름"));
		namef = new JTextField(10);
		panel.add(namef);
		
		panel.add(new JLabel("점수"));
		scoref = new JTextField(10);
		panel.add(scoref);
		
		button = new JButton("점수 제출");
		button.addActionListener(this);
		panel.add(button);
		
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
	}
	//버튼이 눌려지면 필드에서 이름과 점수를 읽어서 데이터베이스에 추가. 그리고 테이블을 채우는 메소드를 호출.
	public void actionPerformed(ActionEvent event) {
		String name = namef.getText();
		String score = scoref.getText();
		
		try {
			Connection conn = makeConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into scores values ( '" + name + "',"+ score + ")");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Caught Exception : " + e.getMessage());
		}
		model.fillTable();
	}
	
	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "exdb";
		String password = "12345";
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc driver 로딩 성공");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		return con;
	}
	public static void main(String[] args) {
		GameScoreTest mainApp = new GameScoreTest();
	}
	
	public class MyTableModel extends AbstractTableModel{
		private String[] columnNames = {"이름", "점수"};
		private static final int ROWS = 10;
		private static final int COLS =2;
		Object[][] data = new String[ROWS][COLS];
		
		public int getColumnCount() {
			return columnNames.length;
		}
		public int getRowCount() {
			return data.length;
		}
		public String getColumnName(int col) {
			return columnNames[col].toString();
		}
		
		public void fillTable() {
			try {
				Connection conn = makeConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM scores ORDER BY score DESC");
				int row = 0;
				while (rs.next()) {
					data[row][0] = rs.getString("name");
					data[row][1] = rs.getString("score");
					row++;
				}
				conn.close();
			} catch (SQLException e) {
				System.err.println("Caught Exception : " + e.getMessage());
			}
			fireTableDataChanged();
		}
		public void getValueAt(Object value, int row, int col) {
			data[row][col]= value;
			fireTableCellUpdated(row, col);
		}
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
	}

}
