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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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



public class CartItem extends JInternalFrame implements MouseListener,ActionListener{

	JPanel northPanel, southPanel,centerPanel;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollpane;
	JLabel productid, productquantity, productmethod;
	JTextField productidField, productquantityField;
	JButton insertButton, updateButton, deleteButton;
	Vector<Object>rowData;
	String method[]= {"-"};
	JComboBox productmethodbox=new JComboBox(method);
	Connect con;
	Date transactiondate=new Date();
	public CartItem() {
		

		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel= new JPanel(new GridLayout(3,2));
		
		productid = new JLabel("ID");
		productquantity = new JLabel("Quantity");
		productmethod = new JLabel("Method");
	
		
		productidField=new JTextField();
		productquantityField=new JTextField();
		productmethodbox.setBounds(50, 50, 90, 20);
		
		insertButton=new JButton("Insert");
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		
		
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		centerPanel.add(productid);
		centerPanel.add(productidField);
		
		centerPanel.add(productquantity);
		centerPanel.add(productquantityField);
		
		centerPanel.add(productmethod);
		centerPanel.add(productmethodbox);
			
		southPanel.add(insertButton);
		southPanel.add(updateButton);
		southPanel.add(deleteButton);

		table = new JTable(dtm);
		refreshTable();
		
		table.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 System.out.println("Table clicked");
				 productid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				 productquantity.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				 productmethod.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			 }
		});
		
		scrollpane = new JScrollPane(table);
		northPanel.add(scrollpane);
		this.setLayout(new BorderLayout());
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setClosable(true);
		this.setTitle("Cart Item View");
		this.setVisible(true);
	}

	private void refreshTable() {
		Object[] column = {"ID", "Quantity", "Method","Date"};
		
		dtm=new DefaultTableModel(column,0);
		
		Vector<MenuCartItem>menus=MenuControllerCartItem.getAllMenus();
		
		for(MenuCartItem menucartitem: menus) {
			rowData=new Vector<>();
			rowData.add(menucartitem.getId());
			rowData.add(menucartitem.getQuantity());
			rowData.add(menucartitem.getMethod());
			rowData.add(menucartitem.getDate());
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
			String id=productidField.getText();
			String quantity=productquantityField.getText();
			String method=(String) productmethodbox.getItemAt(productmethodbox.getSelectedIndex());

			boolean isInserted=MenuControllerCartItem.insertMenu(id,quantity,method);
			if(isInserted) {
				refreshTable();
				productidField.setText("");
				productquantityField.setText("");
				JOptionPane.showMessageDialog(null, "Inserted!");
			}else {
				String errorMessage=MenuControllerCartItem.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}


		}else if(e.getSource()==updateButton){
			String id=productidField.getText();
			String quantity=productquantityField.getText();
			String method=(String) productmethodbox.getItemAt(productmethodbox.getSelectedIndex());

			if(MenuControllerCartItem.updateMenu(id,quantity,method)) {
				refreshTable();
				productidField.setText("");
				productquantityField.setText("");

				JOptionPane.showMessageDialog(null, "Updated!");
			}else {
				String errorMessage=MenuControllerCartItem.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}

//			}
		}else if(e.getSource()==deleteButton) {
			String id=productidField.getText();
			int confirmDelete=JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
			if(confirmDelete!=JOptionPane.YES_OPTION) {
				return;
			}
			if(MenuControllerCartItem.deleteMenu(id)){
				refreshTable();
				JOptionPane.showMessageDialog(null, "Deleted!");
			}else {
				String errorMessage=MenuControllerCartItem.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
