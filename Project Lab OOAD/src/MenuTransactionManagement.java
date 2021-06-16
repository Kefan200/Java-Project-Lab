import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MenuTransactionManagement {
	private int id, quantity;
	private String method,date;
	public MenuTransactionManagement() {
		// TODO Auto-generated constructor stub
	}
	public MenuTransactionManagement(int id, int quantity, String method, String date) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.method = method;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Vector<MenuTransactionManagement>getAll(){
		Vector<MenuTransactionManagement>menus=new Vector<>();
		try {
			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM transactionmanagement");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("productid");
				int quantity=rs.getInt("productquantity");
				String method=rs.getString("productmethod");
				String date=rs.getString("transactiondate");
				
				MenuTransactionManagement menutransactionmanagement=new MenuTransactionManagement(id,quantity,method,date);
				menus.add(menutransactionmanagement);
			}
			return menus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean insert() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO transactionmanagement VALUES (?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2, quantity);
			ps.setString(3, method);
			ps.setString(4, date);
			return ps.executeUpdate()==1;
	//		return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE transactionmanagement SET productquantity=?,productmethod=?,transactiondate=? WHERE productid=?");
			ps.setInt(1, quantity);
			ps.setString(2, method);
			ps.setString(3, date);
			ps.setInt(4, id);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM transactionmanagement WHERE productid=?");
			ps.setInt(1, id);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
