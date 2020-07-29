package ex02;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInsertTest {
	public static Connection makeConnection()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "exdb";
		String password ="12345";
		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		return con;
	}
	public static void main(String[] args) {
		addBook("kkk","bbb","2005",35000);
	}
	
	private static void addBook(String title, String publisher, String year, int price) {
		Connection con = makeConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "insert into books (book_id,title,publisher, year, price) values ";
					s += "(book_no_seq.nextval,'" + title + "','" + publisher + "','"+year + "','" + price + "')";
					System.out.println(s);
					int i =stmt.executeUpdate(s);
					if (i==1)
						System.out.println("레코드 추가 성공");
					else
						System.out.println("레코드 추가 실패");
					
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

}
