

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
	JMenuItem productManagementMenu,humanResourceManagementMenu,transactionManagementMenu; 
	JSeparator separator1;
	InsertInternalPage ii = null;
	ProductManagement productManagement = null;
	HumanResourceManagement humanResourceManagement = null;
	TransactionManagement transactionManagement = null;
	public HomePage() {
		//Initialize Component
		menubar = new JMenuBar();
		homeMenu = new JMenu("Home");
		logoutMenu = new JMenu("Logout");
		//Add Menu Listener (pakai yg di implements ke class)
		logoutMenu.addMenuListener(this);
		
		productManagementMenu=new JMenuItem("Product Management");
		productManagementMenu.addActionListener(this);
		
		humanResourceManagementMenu=new JMenuItem("Human Resource Management");
		humanResourceManagementMenu.addActionListener(this);
		
		transactionManagementMenu=new JMenuItem("Transaction Management");
		transactionManagementMenu.addActionListener(this);
		
		homeMenu.add(productManagementMenu);
		homeMenu.add(humanResourceManagementMenu);
		homeMenu.add(transactionManagementMenu);
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
		if(e.getSource() == logoutMenu) {
			System.out.println("Logout menu is selected");
			
			//JOptionPane.showMessageDialog(null, "Logout!");
			int result = JOptionPane.showConfirmDialog(null, "Are you sure to logout?");
			System.out.println(result);
			
			if(result == 0) {
				this.dispose();
				RegisterPage rf = new RegisterPage();
			}
		}
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

		
		if(e.getSource()==productManagementMenu) {
			System.out.println("Product Management\n");
//			if(ii != null) {
//				ii.dispose();
//			}
			if(productManagement != null) {
				productManagement.dispose();
			}
			add(productManagement = new ProductManagement());
		}
		if(e.getSource()==humanResourceManagementMenu) {
			System.out.println("Human Resource Management\n");

			if(humanResourceManagement != null) {
				humanResourceManagement.dispose();
			}
			add(humanResourceManagement = new HumanResourceManagement());
		}
		if(e.getSource()==transactionManagementMenu) {
			System.out.println("Transaction Management\n");

			if(transactionManagement != null) {
				transactionManagement.dispose();
			}
			add(transactionManagement = new TransactionManagement());
		}
		
	}

}
