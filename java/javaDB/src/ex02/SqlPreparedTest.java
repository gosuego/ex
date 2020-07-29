package ex02;

import java.sql.*;

public class SqlPreparedTest {
   public static Connection makeConnection() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "exdb";
      String password = "12345";
      Connection con = null;
      
      try {
         Class.forName(driver);
         System.out.println("jdbc 로딩 성공");
         con = DriverManager.getConnection(url, user, password);
         System.out.println("오라클 연결 성공");
      } catch (ClassNotFoundException e) {
         System.out.println("jdbc driver 로딩 실패");
      } catch (SQLException e) {
         System.out.println("오라클 연결 실패");
      }
      
      return con;
   }
   
   public static void main(String[] args) throws SQLException {
      Connection con = makeConnection();
      String query = "SELECT books.title, books.price" + " FROM books" + " WHERE publisher=?";
      
      PreparedStatement stmt = con.prepareStatement(query);
      stmt.setString(1, "Wiley");
      ResultSet rs = stmt.executeQuery();
      
      
      while (rs.next()) {
         String title = rs.getString("title");
         int price = rs.getInt("price");
         System.out.println(title + " " + price);
      }
      
   }
   
}
