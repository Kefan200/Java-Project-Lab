import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class MenuManager {
	
	private int employeeid,salary,transactionid,quantity,entermonth;
	private String role, name, username,status,password,method,date; 
	public static String errorMessage;
	public MenuManager() {
		// TODO Auto-generated constructor stub
	}
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
