import java.util.Vector;

public class MenuControllerTransaction {
	
	public static String errorMessage;
	public MenuControllerTransaction() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuTransaction>getAllMenus(){
		MenuTransaction menutransactionmanagement=new MenuTransaction();
		return menutransactionmanagement.getAll();
	}
	public static boolean insertMenu(String id,String quantity, String method) {
		int parsedId;
		int parsedQuantity;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="ID must be integer!";
			return false;
		}
		try {
			parsedQuantity=Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Quantity must be integer!";
			return false;
		}
		if(method.isBlank()) {
			errorMessage="Method must be filled!";
			return false;
		}

		
		MenuTransaction menutransactionmanagement=new MenuTransaction();
		menutransactionmanagement.setId(parsedId);
		menutransactionmanagement.setQuantity(parsedQuantity);
		menutransactionmanagement.setMethod(method);
	//	menutransactionmanagement.setDate(date);
		if(!menutransactionmanagement.insert()) {
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
//			e.printStackTrace();
			errorMessage="ID must be integer!";
			return false;
		}
		try {
			parsedQuantity=Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Quantity must be integer!";
			return false;
		}
		if(method.isBlank()) {
			errorMessage="Method must be filled!";
			return false;
		}

		MenuTransaction menutransactionmanagement=new MenuTransaction();
		menutransactionmanagement.setId(parsedId);
		menutransactionmanagement.setQuantity(parsedQuantity);
		menutransactionmanagement.setMethod(method);
//		menutransactionmanagement.setDate(date);
		if(!menutransactionmanagement.update()) {
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
		MenuTransaction menutransactionmanagement=new MenuTransaction();
		menutransactionmanagement.setId(parsedId);
		if(!menutransactionmanagement.delete()) {
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
