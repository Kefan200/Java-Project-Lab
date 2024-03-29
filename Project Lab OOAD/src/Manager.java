import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Manager extends JInternalFrame implements MouseListener,ActionListener{

	JPanel northPanel, southPanel,centerPanel;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollpane;
	JLabel employeeid, employeerole, employeename, employeeusername,employeestatus,employeesalary;
	JTextField employeeidField, employeeroleField,employeenameField,employeeusernameField,employeesalaryField,employeestatusField;
	JButton insertButton, updateButton, deleteButton;
	Vector<Object>rowData;
	String status[]= {"Active", "Not Active"};

	public Manager() {

		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel= new JPanel(new GridLayout(6,2));
		
		employeeid = new JLabel("ID");
		employeerole = new JLabel("Role");
		employeename = new JLabel("Name");
		employeeusername = new JLabel("Username");
		employeestatus=new JLabel("Status");
		employeesalary=new JLabel("Salary");
		
		
		employeeidField=new JTextField();
		employeeroleField=new JTextField();
		employeenameField=new JTextField();
		employeeusernameField=new JTextField();

		employeestatusField=new JTextField();
		employeesalaryField=new JTextField();
		
		insertButton=new JButton("Insert");
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		centerPanel.add(employeeid);
		centerPanel.add(employeeidField);
		
		centerPanel.add(employeerole);
		centerPanel.add(employeeroleField);
		
		centerPanel.add(employeename);
		centerPanel.add(employeenameField);
		
		centerPanel.add(employeeusername);
		centerPanel.add(employeeusernameField);
		
		centerPanel.add(employeestatus);

		centerPanel.add(employeestatusField);
		
		centerPanel.add(employeesalary);
		centerPanel.add(employeesalaryField);
		
		southPanel.add(insertButton);
		southPanel.add(updateButton);
		southPanel.add(deleteButton);

		table = new JTable(dtm);
		refreshTable();
		
		table.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 System.out.println("Table clicked");
				 employeeid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				 employeerole.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				 employeename.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				 employeeusername.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				 employeestatus.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				 employeesalary.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			 }
		});
		
		scrollpane = new JScrollPane(table);
		

		
		northPanel.add(scrollpane);
		

		
		this.setLayout(new BorderLayout());
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setClosable(true);
		this.setTitle("Manager View");
		this.setVisible(true);
	}

	private void refreshTable() {
		Object[] column = {"ID", "Role", "Name", "Username","Status","Salary","Password"};
		
		dtm=new DefaultTableModel(column,0);
		
		Vector<MenuEmployee> menus=MenuControllerEmployee.getAllMenus();
		
		for(MenuEmployee menu: menus) {
			rowData=new Vector<>();
			rowData.add(menu.getId());
			rowData.add(menu.getRole());
			rowData.add(menu.getName());
			rowData.add(menu.getUsername());
			rowData.add(menu.getStatus());
			rowData.add(menu.getSalary());
			rowData.add(menu.getPassword());
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==insertButton) {
			String role=employeeroleField.getText();
			String name=employeenameField.getText();
			String username=employeeusernameField.getText();
			String status=employeestatusField.getText();
			String salary=employeesalaryField.getText();
			boolean isInserted=MenuControllerManager.insertMenu(role, name, username, status, salary);
			if(isInserted) {
				refreshTable();
				
				employeeroleField.setText("");
				employeenameField.setText("");
				employeeusernameField.setText("");
				employeestatusField.setText("");
				employeesalaryField.setText("");
				JOptionPane.showMessageDialog(null, "Inserted!");
			}else {
				String errorMessage=MenuControllerManager.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
		

		}else if(e.getSource()==updateButton){
			String id=employeeidField.getText();
			String role=employeeroleField.getText();
			String name=employeenameField.getText();
			String username=employeeusernameField.getText();
			String status=employeestatusField.getText();
			String salary=employeesalaryField.getText();
			
			if(MenuControllerManager.updateMenu(id, role, name, username, status, salary)) {
				refreshTable();
				
				employeeroleField.setText("");
				employeenameField.setText("");
				employeeusernameField.setText("");
				employeestatusField.setText("");
				employeesalaryField.setText("");
				JOptionPane.showMessageDialog(null, "Updated!");
			}else {
				String errorMessage=MenuControllerManager.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
	
		}else if(e.getSource()==deleteButton) {
			String id=employeeidField.getText();
			String status=employeestatusField.getText();
			int confirmDelete=JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
			if(confirmDelete!=JOptionPane.YES_OPTION) {
				return;
			}
			if(MenuControllerManager.deleteMenu(id,status)){
				refreshTable();
				employeeroleField.setText("");
				employeenameField.setText("");
				employeeusernameField.setText("");
				employeestatusField.setText("");
				employeesalaryField.setText("");
				JOptionPane.showMessageDialog(null, "Deleted!");
			}else {
				String errorMessage=MenuControllerManager.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
