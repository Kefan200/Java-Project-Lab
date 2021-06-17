import java.util.Vector;

public class MenuControllerProductManagement {
	
	public static String errorMessage;
	public MenuControllerProductManagement() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuProductManagement> getAllMenus(){
		MenuProductManagement menuproductmanagement=new MenuProductManagement();
		return menuproductmanagement.getAll();
	}
	public static boolean insertMenu(String name,String description,String price,String stock) {
		int parsedPrice;
		int parsedStock;
		if(name.isBlank()) {
			errorMessage="Name must be filled!";
			return false;
		}else if(description.isBlank()) {
			errorMessage="Description must be filled!";
			return false;
		}
//		else if(salary==0) {
//			errorMessage="Salary must be filled!";
//			return false;
//		}
		try {
			parsedPrice=Integer.parseInt(price);
			if(parsedPrice<=0) {
				errorMessage="Price must be above zero";
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Price must be integer!";
			return false;
		}
		try {
			parsedStock=Integer.parseInt(stock);
			if(parsedStock<=0) {
				errorMessage="Stock must be above zero";
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Stock must be integer!";
			return false;
		}
		MenuProductManagement menuproductmanagement=new MenuProductManagement();
		menuproductmanagement.setName(name);
		menuproductmanagement.setDescription(description);
		menuproductmanagement.setPrice(parsedPrice);
		menuproductmanagement.setStock(parsedStock);
		if(!menuproductmanagement.insert()) {
			errorMessage="Insert failed!";
			return false;
		}	
		return true;
	}
	public static boolean updateMenu(String name,String description,String price,String id,String stock) {
		int parsedId;
		int parsedPrice;
		int parsedStock;
		if(name.isBlank()) {
			errorMessage="Name must be filled!";
			return false;
		}else if(description.isBlank()) {
			errorMessage="Description must be filled!";
			return false;
		}
//		else if(salary==0) {
//			errorMessage="Salary must be filled!";
//			return false;
//		}
		try {
			parsedPrice=Integer.parseInt(price);
			if(parsedPrice<=0) {
				errorMessage="Price must be above zero";
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Price must be integer!";
			return false;
		}
		try {
			parsedId=Integer.parseInt(id);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Id must be integer!";
			return false;
		}
		try {
			parsedStock=Integer.parseInt(stock);
			if(parsedStock<=0) {
				errorMessage="Stock must be above zero";
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Stock must be integer!";
			return false;
		}
	
		MenuProductManagement menuproductmanagement=new MenuProductManagement();
		menuproductmanagement.setName(name);
		menuproductmanagement.setDescription(description);
		menuproductmanagement.setPrice(parsedPrice);
		menuproductmanagement.setStock(parsedStock);
		menuproductmanagement.setId(parsedId);
		if(!menuproductmanagement.update()) {
			errorMessage="Update failed!";
			return false;
		}	
		return true;
	}
	public static boolean deleteMenu(String id) {
		int parsedId;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="ID must be integer!";
			return false;
		}
		MenuProductManagement menuproductmanagement=new MenuProductManagement();
		menuproductmanagement.setId(parsedId);
		if(!menuproductmanagement.delete()) {
			errorMessage="Delete failed!";
			return false;
		}
		return true;
	}
	public static ProductManagement showProductManagement() {
		return new ProductManagement();
	}
	public static HomePage showHomeFrame() {
		return new HomePage();
	}
}
