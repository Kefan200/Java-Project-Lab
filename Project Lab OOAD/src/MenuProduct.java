import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class MenuProduct {
	
	private int id,price,stock;
	private String name, description;
	public MenuProduct() {
		// TODO Auto-generated constructor stub
	}
	public MenuProduct(int id, int price, int stock, String name, String description) {
		super();
		this.id = id;
		this.price = price;
		this.stock = stock;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vector<MenuProduct>getAll(){
		Vector<MenuProduct>menus=new Vector<>();
		try {

			PreparedStatement ps= Connect.getInstance().prepareStatement("SELECT * FROM product");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("productid");
				String name=rs.getString("productname");
				System.out.println(name);
				String description=rs.getString("productdescription");
				int price=rs.getInt("productprice");
				int stock=rs.getInt("productstock");
				
				MenuProduct menuproductmanagement=new MenuProduct(id, price, stock, name, description);
				menus.add(menuproductmanagement);
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
					PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO product VALUES (null,?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2, description);
					ps.setInt(3, price);
					ps.setInt(4, stock);
					return ps.executeUpdate()==1;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return false;
	}
//            }
//    //        return true;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//		try {



	public boolean update() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE product SET productname=?,productdescription=?,productprice=?,productstock=? WHERE productid=?");
			ps.setString(1, name);
			ps.setString(2,description);
			ps.setInt(3,price);
			ps.setInt(4,stock);
			ps.setInt(5, id);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete() {
		try {
			PreparedStatement ps=Connect.getInstance().prepareStatement("DELETE FROM product WHERE productid=?");
			ps.setInt(1, id);
			
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}