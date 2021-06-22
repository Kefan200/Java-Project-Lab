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
}
