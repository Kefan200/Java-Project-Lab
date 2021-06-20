import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

//public class MenuManager {
//	private int transactionid, transactionquantity,entermonth;
//	private String transactionmethod,date;
//	public MenuManager() {
//		// TODO Auto-generated constructor stub
//	}
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public int getEntermonth() {
//		return entermonth;
//	}
//
//	public void setEntermonth(int entermonth) {
//		this.entermonth = entermonth;
//	}
//
//	public String getMethod() {
//		return method;
//	}
//
//	public void setMethod(String method) {
//		this.method = method;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//public MenuManager(int id, int quantity, int entermonth, String method, String date) {
//		super();
//		this.id = id;
//		this.quantity = quantity;
//		this.entermonth = entermonth;
//		this.method = method;
//		this.date = date;
//	}
//	public MenuManager(int entermonth) {
//		super();
//		this.entermonth = entermonth;
//	}
//
//	public int getEntermonth() {
//		return entermonth;
//	}
//
//
//	public void setEntermonth(int entermonth) {
//		this.entermonth = entermonth;
//	}




//	public Vector<MenuManager>getAll(){
//		Vector<MenuManager>menus=new Vector<>();
//		try {
//			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM transaction");
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				int id=rs.getInt("productid");
//				int quantity=rs.getInt("productquantity");
//				String method=rs.getString("productmethod");
//				String date=rs.getString("transactiondate");
//				java.sql.Date dat = java.sql.Date.valueOf(date);
//				//create calander instance and get required params
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(dat);
//				int month = cal.get(Calendar.MONTH);
//				int day = cal.get(Calendar.DAY_OF_MONTH);
//				int year = cal.get(Calendar.YEAR);
//				System.out.println(entermonth);
//				if(entermonth==month+1) {
//					MenuManager menumanager=new MenuManager(id,quantity,month,method,date);
//					menus.add(menumanager);
//				}
//			
//			}
//			return menus;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	public boolean insert() {
//		int verify=0;
//		try {
//			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM transaction");
//			ResultSet rs = ps.executeQuery();
//
//			while(rs.next()) {
//				int id2=rs.getInt("productid");
//				int quantity2=rs.getInt("productquantity");
//				String method=rs.getString("productmethod");
//				String date2=rs.getString("transactiondate");
//				if(id2==id) {
//					
//					int quantitytotal=quantity+quantity2;
//					java.util.Date date=new java.util.Date();
//					java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//					try {
//						verify=1;
//						PreparedStatement ps2=Connect.getInstance().prepareStatement("UPDATE transaction SET productquantity=? WHERE productid=?");
//						ps2.setInt(1, quantitytotal);
//						ps2.setInt(2, id);
//						return ps2.executeUpdate()==1;
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(verify==0) {
//			try {
//				java.util.Date date=new java.util.Date();
//				java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//				PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO transaction VALUES (?,?,?,?)");
//				ps.setInt(1, id);
//				ps.setInt(2, quantity);
//				ps.setString(3, method);
//				ps.setDate(4, sqlDate);
//				return ps.executeUpdate()==1;
//		//		return true;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return false;
//	}
//	public boolean update() {
//		java.util.Date date=new java.util.Date();
//		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//		try {
//			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE transaction SET productquantity=?,productmethod=?,transactiondate=? WHERE productid=?");
//			ps.setInt(1, quantity);
//			ps.setString(2, method);
//			ps.setDate(3, sqlDate);
//			ps.setInt(4, id);
//			return ps.executeUpdate()==1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//	public boolean delete() {
//		try {
//			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM transaction WHERE productid=?");
//			ps.setInt(1, id);
//			
//			return ps.executeUpdate()==1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//}

public class MenuManager {
	
	private int employeeid,salary,transactionid,quantity,entermonth;
	private String role, name, username,status,password,method,date; 
	public static String errorMessage;
	public MenuManager() {
		// TODO Auto-generated constructor stub
	}
//	int id, int quantity, int entermonth, String method, String date
	public MenuManager(int employeeid, int salary, String role, String name, String username, String status,
			String password) {
		super();
		this.employeeid = employeeid;
		this.salary = salary;
		this.role = role;
		this.name = name;
		this.username = username;
		this.status = status;
		this.password = password;
	}

	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Vector<MenuManager>getAll(){
		Vector<MenuManager>menus=new Vector<>();
		try {
			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("employeeid");
				String role=rs.getString("employeerole");
				String name=rs.getString("employeename");
				String username=rs.getString("employeeusername");
				String status=rs.getString("employeestatus");
				int salary=rs.getInt("employeesalary");
				String password=rs.getString("employeepassword");
				MenuManager menu=new MenuManager(id,salary,role, name,username,status,password);
				menus.add(menu);
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
			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("employeeid");
				String role=rs.getString("employeerole");
				String name=rs.getString("employeename");
				String username2=rs.getString("employeeusername");
				String status=rs.getString("employeestatus");
				int salary=rs.getInt("employeesalary");
				String password=rs.getString("employeepassword");
				if(username.equals(username2)) {
					errorMessage="Username has been inserted";
				}
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO employee VALUES (null,?,?,?,?,?,?)");
			ps.setString(1, role);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, status);
			ps.setInt(5, salary);
			ps.setString(6, password);
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
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE employee SET employeerole=?,employeename=?,employeeusername=?,employeestatus=?,employeesalary=?,employeepassword=? WHERE employeeid=?");
			ps.setString(1, role);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, status);
			ps.setInt(5, salary);
			ps.setString(6, password);
			ps.setInt(7, employeeid);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE employee SET employeestatus=? WHERE employeeid=?");
			ps.setString(1, status);
			ps.setInt(2, employeeid);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
