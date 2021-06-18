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
	JLabel employeeid, employeerole, employeename, employeeusername,employeestatus,employeesalary,entermonth;
	//buat isi text
	JTextField employeeidField, employeeroleField,employeenameField,employeeusernameField,employeesalaryField,employeestatusField,entermonthField;
	JButton insertButton, updateButton, deleteButton,entermonthButton;
	Vector<Object>rowData;
	String status[]= {"Active", "Not Active"};
//	JComboBox employeestatusbox=new JComboBox(status);

//	Connect con;
	
	public Manager() {
		
	//	con=new Connect();
		//Initialize component
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel= new JPanel(new GridLayout(7,2));
		
		entermonth=new JLabel("Enter the month");
		employeeid = new JLabel("ID");
		employeerole = new JLabel("Role");
		employeestatus=new JLabel("Status");
		employeesalary=new JLabel("Salary");
		
		entermonthField=new JTextField();
		employeeidField=new JTextField();
		employeeroleField=new JTextField();
		employeenameField=new JTextField();
		employeeusernameField=new JTextField();
//		employeestatusbox.setBounds(50, 50,90,20);
		employeestatusField=new JTextField();
		employeesalaryField=new JTextField();
		
		entermonthButton=new JButton("Select month");
		insertButton=new JButton("Insert");
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		
		//ActionListener biar tombolnya bisa dipencet
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		centerPanel.add(entermonth);
		centerPanel.add(entermonthField);
		
		centerPanel.add(employeeid);
		centerPanel.add(employeeidField);
		
		centerPanel.add(employeerole);
		centerPanel.add(employeeroleField);
		
		centerPanel.add(employeename);
		centerPanel.add(employeenameField);
		
		centerPanel.add(employeeusername);
		centerPanel.add(employeeusernameField);
		
		centerPanel.add(employeestatus);
//		centerPanel.add(employeestatusbox);
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
				 entermonth.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				 employeeid.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				 employeerole.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				 employeename.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				 employeeusername.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				 employeestatus.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				 employeesalary.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
			 }
		});
		
		scrollpane = new JScrollPane(table);
		
//		dtm.addRow(newData);
//		dtm.insertRow(0, newData2);
		
		northPanel.add(scrollpane);
		
//		southPanel.add(id);
//		southPanel.add(name);
//		southPanel.add(type);
//		southPanel.add(cuisine);
		
		this.setLayout(new BorderLayout());
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setClosable(true);
		this.setTitle("Manager View");
		this.setVisible(true);
	}

	private void refreshTable() {
		Object[] column = {"ID", "Role", "Name", "Username","Status","Salary"};
		
		dtm=new DefaultTableModel(column,0);
		
		Vector<MenuManager> menus=MenuControllerManager.getAllMenus();
		
		for(MenuManager menumanager: menus) {
			rowData=new Vector<>();
			rowData.add(menumanager.getId());
			rowData.add(menumanager.getRole());
			rowData.add(menumanager.getName());
			rowData.add(menumanager.getUsername());
			rowData.add(menumanager.getStatus());
			rowData.add(menumanager.getSalary());
			
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	//	con.rs=con.execQuery("SELECT * FROM employee");
		
		
//		try {
//			PreparedStatement ps=Connect.getInstance().prepareStatement("SELECT * FROM employee");
//			ResultSet rs=ps.executeQuery();
//			//majuin cursor satu baris dari baris sebelumnya
//			while(rs.next()) {
//				rowData =new Vector<>(); 
//				
//				//Cara Pertama
////				for (int i = 1; i <= con.rsx`m.getColumnCount(); i++) {
////					rowData.add(con.rs.getObject(i));
////				}
//				
//				//Cara Kedua
//				int id=rs.getInt("employeeid");
//				String role=rs.getString("employeerole");
//				String name=rs.getString("employeename");
//				String username=rs.getString("employeeusername");
//				String status=rs.getString("employeestatus");
//				int salary=rs.getInt("employeesalary");
//				
//				rowData.add(id);
//				rowData.add(role);
//				rowData.add(name);
//				rowData.add(username);
//				rowData.add(status);
//				rowData.add(salary);
//				dtm.addRow(rowData);
//			}
//			//tambahin dalam jtable
//			table.setModel(dtm);
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
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
		if(e.getSource()==entermonthButton) {
			String month=entermonthField.getText();
			boolean isInserted=MenuControllerManager.entermonth(month);
			if(isInserted) {
				refreshTable();
				
				entermonthField.setText("");
				JOptionPane.showMessageDialog(null, "Inserted!");
			}else {
				String errorMessage=MenuControllerManager.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
			Object[] column = {"ID", "Role", "Name", "Username","Status","Salary"};
			
			dtm=new DefaultTableModel(column,0);
			
			Vector<MenuManager> menus=MenuControllerManager.getAllMenus();
			
			for(MenuManager menumanager: menus) {
				rowData=new Vector<>();
				rowData.add(menumanager.getId());
				rowData.add(menumanager.getRole());
				rowData.add(menumanager.getName());
				rowData.add(menumanager.getUsername());
				rowData.add(menumanager.getStatus());
				rowData.add(menumanager.getSalary());
				
				dtm.addRow(rowData);
			}
			table.setModel(dtm);
		}
		
		if(e.getSource()==insertButton) {
			String role=employeeroleField.getText();
			String name=employeenameField.getText();
			String username=employeeusernameField.getText();
			String status=employeestatusField.getText();
//			String status=(String) employeestatusbox.getItemAt(employeestatusbox.getSelectedIndex());
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
//			
//		//	String query =String.format("INSERT INTO employee VALUES(null,'%s','%s','%s','%s',%d)",role, name, username,status,salary);
//			try {
//				PreparedStatement ps=Connect.getInstance().prepareStatement("INSERT INTO employee "+"(role, name, username,status,salary) VALUES (?,?,?,?,?)");
//				ps.setString(1, role);
//				ps.setString(2, name);
//				ps.setString(3, username);
//				ps.setString(4, status);
//				ps.setInt(5, salary);
//				ps.executeUpdate();

//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
////			con.execUpdate(query);

		}else if(e.getSource()==updateButton){
//			int id=Integer.parseInt(employeeidField.getText());
			String id=employeeidField.getText();
			String role=employeeroleField.getText();
			String name=employeenameField.getText();
			String username=employeeusernameField.getText();
//			String status=(String) employeestatusbox.getItemAt(employeestatusbox.getSelectedIndex());
			String status=employeestatusField.getText();
			String salary=employeesalaryField.getText();
			
			if(MenuController.updateMenu(id, role, name, username, status, salary)) {
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
		//	String query =String.format("INSERT INTO employee VALUES(null,'%s','%s','%s','%s',%d)",role, name, username,status,salary);
//			try {
//				PreparedStatement ps=Connect.getInstance().prepareStatement("UPDATE employee"+"SET role=?,name=?,username=?,status=?,salary=? WHERE id=?");
//				ps.setString(1, role);
//				ps.setString(2, name);
//				ps.setString(3, username);
//				ps.setString(4, status);
//				ps.setInt(5, salary);
//				ps.setInt(6, id);
//				ps.executeUpdate();
//				

//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
////			con.execUpdate(query);

		}else if(e.getSource()==deleteButton) {
//			int id=Integer.parseInt(employeeidField.getText());
			String id=employeeidField.getText();
			String status=employeestatusField.getText();
			int confirmDelete=JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
			if(confirmDelete!=JOptionPane.YES_OPTION) {
				return;
			}
			if(MenuController.deleteMenu(id,status)){
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
//			try {
//				
//				

//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
	}

}
