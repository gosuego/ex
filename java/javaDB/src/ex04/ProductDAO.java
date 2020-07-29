package ex04;
import java.sql.*;
import java.util.*;
public class ProductDAO {
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	Vector<String> items = null;
	String sql;
	
	//콤보박스의 상품관리 번호 목록을 위한 백터 리턴
	public Vector<String> getItems(){
		return items;
	}
	
	// 전체 상품 목록을 가지고 오는  메서드
	public ArrayList<Product> getAll(){
		connectDB();
		sql = "select * from product";
		
		//전제 검색 데이터를 전달하기 위한 ArryList
		ArrayList<Product> datas = new ArrayList<Product>();
		
		//관리코드 콤보박스 데이터를 위한 벡터 초기화
		items = new Vector<String>();
		items.add("전체");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//검색된 데이터수 만큼 루프를 돌며 Product 객체를 만들고 이를 다시 ArrayList에 추가함.
			while(rs.next()) {
				Product p = new Product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeDB();
		}
		return datas;
	}
	
	//선택한 상품 코드에 해당하는 상품 정보를 가지고 오는 메서드
	public Product getProduct(int prcode) {
		connectDB();
		sql = "select *from product where prcode=?";
		Product p = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();
			rs.next();
			p = new Product();
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeDB();
		}
		return p;
	}
	public boolean newProduct(Product product) {
		connectDB();
		
		sql="insert into product"
				+"(prcode,prname,price,manufacture) values(prcode_seq.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeDB();
		}
		return true;
	}
	
	public boolean delProduct(int prcode) {
		connectDB();
		sql = "delete from product where prcode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeDB();
		}
		return true;
	}
	
	//수정한 정보로 상품정보를 업데이트 하는 메서드
	public boolean updateProduct(Product product) {
		connectDB();
		sql="update product set prname =?, price = ?, manufacture=? where prcode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeDB();
		}
		return true;
	}
	//DB 연결 메서드
	private void connectDB() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "exdb","12345");
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	private void closeDB() {
		try {
			pstmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}