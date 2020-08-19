package ex01;
import java.sql.*;
import java.util.*;
public class EventRegist {
	Scanner scanner = new Scanner(System.in);
	
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public EventRegist() {
		System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요");
		System.out.println("이름: ");
		String uname = scanner.next();
		System.out.print("이메일: ");
		String email = scanner.next();
		
		connectDB();
		registUser(uname,email);
		printList();
		closeDB();
	}
	
	public void connectDB() {
		try {
			Class.forName(jdbcDriver);
			
			conn = DriverManager.getConnection(jdbcUrl,"exdb","12345");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void registUser(String uname, String email) {
		String sql = "insert into event values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printList() {
		System.out.println("# 등록자 명단");
		String sql = "select * from event";
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("uname")+","+rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EventRegist();
	}

}
