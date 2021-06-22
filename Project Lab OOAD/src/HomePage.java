

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class HomePage extends JFrame implements MenuListener, ActionListener{

	JMenuBar menubar;
	JMenu homeMenu, logoutMenu;
	JMenuItem productMenu,employeeMenu,transactionMenu,managerMenu,cartitemMenu; 
	JSeparator separator1;
	InsertInternalPage ii = null;
	Product product = null;
	Employee employee = null;
	Transaction transaction = null;
	Manager manager = null;
	CartItem cartitem=null;
	public HomePage() {

		menubar = new JMenuBar();
		homeMenu = new JMenu("Home");
		logoutMenu = new JMenu("Logout");
		logoutMenu.addMenuListener(this);
		
		productMenu=new JMenuItem("Product Management");
		productMenu.addActionListener(this);
		
		employeeMenu=new JMenuItem("Human Resource Management");
		employeeMenu.addActionListener(this);
		
		transactionMenu=new JMenuItem("Transaction Management");
		transactionMenu.addActionListener(this);
		
		managerMenu=new JMenuItem("Manager");
		managerMenu.addActionListener(this);
		

		cartitemMenu=new JMenuItem("Cart Item");
		cartitemMenu.addActionListener(this);
		
		homeMenu.add(productMenu);
		homeMenu.add(employeeMenu);
		homeMenu.add(transactionMenu);
		homeMenu.add(managerMenu);
		homeMenu.add(cartitemMenu);
		menubar.add(homeMenu);
		menubar.add(logoutMenu);
		
		
		setJMenuBar(menubar);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Home");
		this.setSize(new Dimension(700, 730));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void menuSelected(MenuEvent e) {

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==productMenu) {
			System.out.println("Product Management\n");

			if(product != null) {
				product.dispose();
			}
			add(product = MenuControllerProduct.showProduct());
		}
		if(e.getSource()==employeeMenu) {
			System.out.println("Human Resource Management\n");

			if(employee!= null) {
				employee.dispose();
			}

			add(employee=MenuControllerEmployee.showEmployee()); 
		}
		if(e.getSource()==transactionMenu) {
			System.out.println("Transaction Management\n");

			if(transaction != null) {
				transaction.dispose();
			}
			add(transaction= MenuControllerTransaction.showTransaction());
		}
		if(e.getSource()==managerMenu) {
			System.out.println("Manager\n");

			if(manager != null) {
				manager.dispose();
			}
			add(manager = MenuControllerManager.showManager());
		}
		if(e.getSource()==cartitemMenu) {
			System.out.println("Cart Item\n");

			if(cartitem != null) {
				cartitem.dispose();
			}
			add(cartitem = MenuControllerCartItem.showCartItem());
		}
	}

}
