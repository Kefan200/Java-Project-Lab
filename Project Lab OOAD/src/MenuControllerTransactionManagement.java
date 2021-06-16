import java.util.Vector;

public class MenuControllerTransactionManagement {
	
	public static String errorMessage;
	public MenuControllerTransactionManagement() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuTransactionManagement>getAllMenus(){
		MenuTransactionManagement menutransactionmanagement=new MenuTransactionManagement();
		return menutransactionmanagement.getAll();
	}
	public static boolean insertMenu(String id,String quantity, String method, String date) {
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

		
		MenuTransactionManagement menutransactionmanagement=new MenuTransactionManagement();
		menutransactionmanagement.setId(parsedId);
		menutransactionmanagement.setQuantity(parsedQuantity);
		menutransactionmanagement.setMethod(method);
		menutransactionmanagement.setDate(date);
		if(!menutransactionmanagement.insert()) {
			errorMessage="Insert failed!";
			return false;
		}	
		return true;
	}
	public static boolean updateMenu(String id, String quantity, String method, String date) {
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
		}else if(date.isBlank()) {
			errorMessage="Name must be filled!";
			return false;
		}

		MenuTransactionManagement menutransactionmanagement=new MenuTransactionManagement();
		menutransactionmanagement.setId(parsedId);
		menutransactionmanagement.setQuantity(parsedQuantity);
		menutransactionmanagement.setMethod(method);
		menutransactionmanagement.setDate(date);
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
		Menu menu=new Menu();
		menu.setId(parsedId);
		if(!menu.delete()) {
			errorMessage="Delete failed!";
			return false;
		}
		return true;
	}
	public static TransactionManagement showTransactionManagement() {
		return new TransactionManagement();
	}
	public static HomePage showHomeFrame() {
		return new HomePage();
	}
}
