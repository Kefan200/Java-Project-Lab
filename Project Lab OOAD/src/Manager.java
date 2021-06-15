//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.sql.SQLException;
//import java.util.Vector;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JInternalFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
//public class Manager extends JInternalFrame implements MouseListener,ActionListener{
//
//	JPanel northPanel, southPanel,centerPanel;
//	JTable table;
//	DefaultTableModel dtm;
//	JScrollPane scrollpane;
//	JLabel employeeid, employeerole, employeename, employeeusername,employeestatus,employeesalary;
//	//buat isi text
//	JTextField employeeidField, employeeroleField,employeenameField,employeeusernameField,employeesalaryField;
//	JButton insertButton, updateButton, deleteButton;
//	Vector<Object>rowData;
//	String status[]= {"Active", "Not Active"};
//	JComboBox employeestatusbox=new JComboBox(status);
//
//	Connect con;
//	
//	public Manager() {
//		
//		con=new Connect();
//		//Initialize component
//		northPanel = new JPanel();
//		southPanel = new JPanel();
//		centerPanel= new JPanel(new GridLayout(6,2));
//		
//		employeeid = new JLabel("ID");
//		employeerole = new JLabel("Role");
//		employeename = new JLabel("Name");
//		employeeusername = new JLabel("Username");
//		employeestatus=new JLabel("Status");
//		employeesalary=new JLabel("Salary");
//		
//		employeeidField=new JTextField();
//		employeeroleField=new JTextField();
//		employeenameField=new JTextField();
//		employeeusernameField=new JTextField();
//		employeestatusbox.setBounds(50, 50,90,20);
//		employeesalaryField=new JTextField();
//		
//		insertButton=new JButton("Insert");
//		updateButton=new JButton("Update");
//		deleteButton=new JButton("Delete");
//		
//		//ActionListener biar tombolnya bisa dipencet
//		insertButton.addActionListener(this);
//		updateButton.addActionListener(this);
//		deleteButton.addActionListener(this);
//		
//		centerPanel.add(employeeid);
//		centerPanel.add(employeeidField);
//		
//		centerPanel.add(employeerole);
//		centerPanel.add(employeeroleField);
//		
//		centerPanel.add(employeename);
//		centerPanel.add(employeenameField);
//		
//		centerPanel.add(employeeusername);
//		centerPanel.add(employeeusernameField);
//		
//		centerPanel.add(employeestatus);
//		centerPanel.add(employeestatusbox);
//		
//		centerPanel.add(employeesalary);
//		centerPanel.add(employeesalaryField);
//		
//		southPanel.add(insertButton);
//		southPanel.add(updateButton);
//		southPanel.add(deleteButton);
//
//		table = new JTable(dtm);
//		refreshTable();
//		
//		table.addMouseListener(new MouseAdapter() {
//			 public void mouseClicked(MouseEvent e) {
//				 System.out.println("Table clicked");
//				 employeeid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				 employeerole.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
//				 employeename.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
//				 employeeusername.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
//				 employeestatus.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//				 employeesalary.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
//			 }
//		});
//		
//		scrollpane = new JScrollPane(table);
//		
////		dtm.addRow(newData);
////		dtm.insertRow(0, newData2);
//		
//		northPanel.add(scrollpane);
//		
////		southPanel.add(id);
////		southPanel.add(name);
////		southPanel.add(type);
////		southPanel.add(cuisine);
//		
//		this.setLayout(new BorderLayout());
//		
//		this.add(northPanel, BorderLayout.NORTH);
//		this.add(southPanel, BorderLayout.SOUTH);
//		this.add(centerPanel, BorderLayout.CENTER);
//		
//		this.setClosable(true);
//		this.setTitle("Human Resource Management View");
//		this.setVisible(true);
//	}
//
//	private void refreshTable() {
//		Object[] column = {"ID", "Role", "Name", "Username","Status","Salary"};
//		
//		dtm=new DefaultTableModel(column,0);
//		
//		con.rs=con.execQuery("SELECT * FROM employee");
//		
//		try {
//			//majuin cursor satu baris dari baris sebelumnya
//			while(con.rs.next()) {
//				rowData =new Vector<>(); 
//				
//				//Cara Pertama
////				for (int i = 1; i <= con.rsx`m.getColumnCount(); i++) {
////					rowData.add(con.rs.getObject(i));
////				}
//				
//				//Cara Kedua
//				int id=con.rs.getInt("employeeid");
//				String role=con.rs.getString("employeerole");
//				String name=con.rs.getString("employeename");
//				String username=con.rs.getString("employeeusername");
//				String status=con.rs.getString("employeestatus");
//				int salary=con.rs.getInt("employeesalary");
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
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==insertButton) {
//			String role=employeeroleField.getText();
//			String name=employeenameField.getText();
//			String username=employeeusernameField.getText();
//			String status=(String) employeestatusbox.getItemAt(employeestatusbox.getSelectedIndex());
//			int salary=Integer.parseInt(employeesalaryField.getText());
//			
//			String query =String.format("INSERT INTO employee VALUES(null,'%s','%s','%s','%s',%d)",role, name, username,status,salary);
//			
//			con.execUpdate(query);
//			refreshTable();
//			
//			employeeroleField.setText("");
//			employeenameField.setText("");
//			employeeusernameField.setText("");
//	//		employeestatusField.setText("");
//			employeesalaryField.setText("");
//		}else if(e.getSource()==updateButton){
//			
//		}else if(e.getSource()==deleteButton) {
//			
//		}
//	}
//
//}
