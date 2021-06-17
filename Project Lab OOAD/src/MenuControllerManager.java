import java.util.Vector;

public class MenuControllerManager {

	public static String errorMessage;
	public MenuControllerManager() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<MenuManager> getAllMenus(){
		MenuManager menumanager=new MenuManager();
		return menumanager.getAll();
	}
	public static boolean insertMenu(String role, String name, String username, String status, String salary) {
		int parsedSalary;
		if(role.isBlank()) {
			errorMessage="Role must be filled!";
			return false;
		}else if(name.isBlank()) {
			errorMessage="Name must be filled!";
			return false;
		}else if(username.isBlank()) {
			errorMessage="Username must be filled!";
			return false;
		}else if(status.isBlank()) {
			errorMessage="Status must be filled!";
			return false;
		}else if(!"Active".equals(status)&&!"Not Active".equals(status)) {
			errorMessage="Status must be filled with Active or Not Active";
			return false;
		}
//		else if(salary==0) {
//			errorMessage="Salary must be filled!";
//			return false;
//		}
		try {
			parsedSalary=Integer.parseInt(salary);
			if(parsedSalary<=0) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Salary must be integer!";
			return false;
		}
		MenuManager menumanager=new MenuManager();
		menumanager.setRole(role);
		menumanager.setName(name);
		menumanager.setUsername(username);
		menumanager.setStatus(status);
		menumanager.setSalary(parsedSalary);
		if(!menumanager.insert()) {
			errorMessage="Insert failed!";
			return false;
		}	
		return true;
	}
	public static boolean updateMenu(String id,String role, String name, String username, String status, String salary) {
		int parsedId;
		int parsedSalary;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="ID must be integer!";
			return false;
		}
		
		if(role.isBlank()) {
			errorMessage="Role must be filled!";
			return false;
		}else if(name.isBlank()) {
			errorMessage="Name must be filled!";
			return false;
		}else if(username.isBlank()) {
			errorMessage="Username must be filled!";
			return false;
		}else if(status.isBlank()) {
			errorMessage="Status must be filled!";
			return false;
		}
		else if(!"Active".equals(status)&&!"Not Active".equals(status)) {
			errorMessage="Status must be filled with Active or Not Active";
			return false;
		}
//		else if(salary==0) {
//			errorMessage="Salary must be filled!";
//			return false;
//		}
		try {
			parsedSalary=Integer.parseInt(salary);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="Salary must be integer!";
			return false;
		}
		MenuManager menumanager=new MenuManager();
		menumanager.setId(parsedId);
		menumanager.setRole(role);
		menumanager.setName(username);
		menumanager.setUsername(username);
		menumanager.setStatus(status);
		menumanager.setSalary(parsedSalary);
		if(!menumanager.update()) {
			errorMessage="Update failed!";
			return false;
		}
		return true;
	}
	public static boolean deleteMenu(String id,String status) {
		int parsedId;
		try {
			parsedId=Integer.parseInt(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			errorMessage="ID must be integer!";
			return false;
		}
		status.equals("Not Active");
		MenuManager menumanager=new MenuManager();
		menumanager.setId(parsedId);
		menumanager.setStatus(status);
		if(!menumanager.delete()) {
			errorMessage="Delete failed!";
			return false;
		}
		return true;
	}
	public static HumanResourceManagement showHumanResourceManagement() {
		return new HumanResourceManagement();
	}
	public static HomePage showHomeFrame() {
		return new HomePage();
	}
}
