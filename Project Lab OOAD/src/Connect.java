import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private static Connection con;
	public static Connection getInstance() {
		if(con==null) {
			new Connect();
		}
		return con;
	}
	public Connect() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/justduit_db","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void deleteMenu(int id) {
//		try {
//			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM employee WHERE id=?");
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
//	}
//	public Connection con;
//	//execute sql statement
//	public Statement stat;
//	public ResultSet rs;
//	//Informasi tentang resultset
//	public ResultSetMetaData rsm;
//	
//	public Connect() {
//		// TODO Auto-generated constructor stub
//		try {
//			//buat cari driver classnya
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/justduit_db","root","");
//			
//			stat=con.createStatement();
//			
//			System.out.println("Connected");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Fail to connect");
//		}
//	}
//	//jalanin dari query
//	public ResultSet execQuery(String query) {
//		try {
//			rs=stat.executeQuery(query);
//			rsm=rs.getMetaData();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public boolean execUpdate(String query) {
//		try {
//			stat.executeUpdate(query);
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} 
//	}
//}
}
//test
//test 2