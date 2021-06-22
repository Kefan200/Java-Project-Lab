import java.util.Vector;

public class MenuControllerCartItem {
	
	public static String errorMessage;
	public MenuControllerCartItem() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuCartItem>getAllMenus(){
		MenuCartItem menucartitem=new MenuCartItem();
		return menucartitem.getAll();
	}
	public static boolean insertMenu(String id,String quantity, String method) {
		int parsedId;
		int parsedQuantity;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			errorMessage="ID must be integer!";
			return false;
		}
		try {
			parsedQuantity=Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			errorMessage="Quantity must be integer!";
			return false;
		}
		if(method.isBlank()) {
			errorMessage="Method must be filled!";
			return false;
		}

		
		MenuCartItem menucartitem=new MenuCartItem();
		menucartitem.setId(parsedId);
		menucartitem.setQuantity(parsedQuantity);
		menucartitem.setMethod(method);
		if(!menucartitem.insert()) {
			errorMessage="Insert failed!";
			return false;
		}	
		return true;
	}
	public static boolean updateMenu(String id, String quantity, String method) {
		int parsedId;
		int parsedQuantity;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			errorMessage="ID must be integer!";
			return false;
		}
		try {
			parsedQuantity=Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			errorMessage="Quantity must be integer!";
			return false;
		}
		if(method.isBlank()) {
			errorMessage="Method must be filled!";
			return false;
		}

		MenuCartItem menucartitem=new MenuCartItem();
		menucartitem.setId(parsedId);
		menucartitem.setQuantity(parsedQuantity);
		menucartitem.setMethod(method);

		if(!menucartitem.update()) {
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
			errorMessage="ID must be integer!";
			return false;
		}
		MenuCartItem menucartitem=new MenuCartItem();
		menucartitem.setId(parsedId);
		if(!menucartitem.delete()) {
			errorMessage="Delete failed!";
			return false;
		}
		return true;
	}
	public static CartItem showCartItem() {
		return new CartItem();
	}
	public static HomePage showHomeFrame() {
		return new HomePage();
	}
}
