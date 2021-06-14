import java.util.Vector;

public class MenuController {

	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<Menu> getAllMenus(){
		Menu menu=new Menu();
		return menu.getAll();
	}
	public static boolean insertMenu(String role, String name, String username, String status, int salary) {
		Menu menu=new Menu();
		menu.setRole(role);
		menu.setName(name);
		menu.setUsername(username);
		menu.setStatus(status);
		menu.setSalary(salary);
		
		return menu.insert();
	}
}
