import java.util.Vector;

public class MenuControllerTransaction {
	
	public static String errorMessage;
	public MenuControllerTransaction() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuTransaction>getAllMenus(){
		MenuTransaction menutransaction=new MenuTransaction();
		return menutransaction.getAll();
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

		
		MenuTransaction menutransaction=new MenuTransaction();
		menutransaction.setId(parsedId);
		menutransaction.setQuantity(parsedQuantity);
		menutransaction.setMethod(method);
		if(!menutransaction.insert()) {
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

		MenuTransaction menutransaction=new MenuTransaction();
		menutransaction.setId(parsedId);
		menutransaction.setQuantity(parsedQuantity);
		menutransaction.setMethod(method);
		if(!menutransaction.update()) {
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
		MenuTransaction menutransaction=new MenuTransaction();
		menutransaction.setId(parsedId);
		if(!menutransaction.delete()) {
			errorMessage="Delete failed!";
			return false;
		}
		return true;
	}
	public static Transaction showTransaction() {
		return new Transaction();
	}
	public static HomePage showHomeFrame() {
		return new HomePage();
	}
}
