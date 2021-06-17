import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Menu {
	
	private int id,salary;
	private String role, name, username,status; 
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(int id, String role, String name, String username, String status, int salary) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.username = username;
		this.status = status;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Vector<Menu>getAll(){
		Vector<Menu>menus=new Vector<>();
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
				
				Menu menu=new Menu(id,role,name,username,status,salary);
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
			PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO employee VALUES (null,?,?,?,?,?)");
			ps.setString(1, role);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, status);
			ps.setInt(5, salary);
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
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE employee SET employeerole=?,employeename=?,employeeusername=?,employeestatus=?,employeesalary=? WHERE employeeid=?");
			ps.setString(1, role);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, status);
			ps.setInt(5, salary);
			ps.setInt(6, id);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM employee WHERE employeeid=?");
			ps.setInt(1, id);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
