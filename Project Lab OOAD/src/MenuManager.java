import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class MenuManager {
	private int id, quantity;
	private String method,date;
	public MenuManager() {
		// TODO Auto-generated constructor stub
	}
	public MenuManager(int id, int quantity, String method, String date) {
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
	public Vector<MenuManager>getAll(){
		Vector<MenuManager>menus=new Vector<>();
		try {
			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM transaction");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("productid");
				int quantity=rs.getInt("productquantity");
				String method=rs.getString("productmethod");
				String date=rs.getString("transactiondate");
				
				MenuManager menumanager=new MenuManager(id,quantity,method,date);
				menus.add(menumanager);
			}
			return menus;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean insert() {
		int verify=0;
		try {
			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM transaction");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id2=rs.getInt("productid");
				int quantity2=rs.getInt("productquantity");
				String method=rs.getString("productmethod");
				String date2=rs.getString("transactiondate");
				if(id2==id) {
					
					int quantitytotal=quantity+quantity2;
					java.util.Date date=new java.util.Date();
					java.sql.Date sqlDate=new java.sql.Date(date.getTime());
					try {
						verify=1;
						PreparedStatement ps2=Connect.getInstance().prepareStatement("UPDATE transaction SET productquantity=? WHERE productid=?");
						ps2.setInt(1, quantitytotal);
						ps2.setInt(2, id);
						return ps2.executeUpdate()==1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(verify==0) {
			try {
				java.util.Date date=new java.util.Date();
				java.sql.Date sqlDate=new java.sql.Date(date.getTime());
				PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO transaction VALUES (?,?,?,?)");
				ps.setInt(1, id);
				ps.setInt(2, quantity);
				ps.setString(3, method);
				ps.setDate(4, sqlDate);
				return ps.executeUpdate()==1;
		//		return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	public boolean update() {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE transaction SET productquantity=?,productmethod=?,transactiondate=? WHERE productid=?");
			ps.setInt(1, quantity);
			ps.setString(2, method);
			ps.setDate(3, sqlDate);
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
			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM transaction WHERE productid=?");
			ps.setInt(1, id);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
