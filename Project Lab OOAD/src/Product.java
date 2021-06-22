import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Product extends JInternalFrame implements MouseListener,ActionListener{

	JPanel northPanel, southPanel,centerPanel;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scrollpane;
	JLabel id, name, description, price,stock;
	//buat isi text
	JTextField idField, nameField, descriptionField, priceField,stockField;
	JButton insertButton, updateButton, deleteButton;
	
	Vector<Object>rowData;
	
	public Product() {
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel= new JPanel(new GridLayout(5,2));
		
		id = new JLabel("ID");
		name = new JLabel("Name");
		description = new JLabel("Description");
		price = new JLabel("Price");
		stock=new JLabel("Stock");
		
		idField=new JTextField();
		nameField=new JTextField();
		descriptionField=new JTextField();
		priceField=new JTextField();
		stockField=new JTextField();
		
		insertButton=new JButton("Insert");
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		centerPanel.add(id);
		centerPanel.add(idField);
		
		centerPanel.add(name);
		centerPanel.add(nameField);
		
		centerPanel.add(description);
		centerPanel.add(descriptionField);
		
		centerPanel.add(price);
		centerPanel.add(priceField);
		
		centerPanel.add(stock);
		centerPanel.add(stockField);
		
		southPanel.add(insertButton);
		southPanel.add(updateButton);
		southPanel.add(deleteButton);

		table = new JTable(dtm);
		refreshTable();
		
		table.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 System.out.println("Table clicked");
				 id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				 name.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				 description.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				 price.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				 stock.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			 }
		});
		
		scrollpane = new JScrollPane(table);
			
		northPanel.add(scrollpane);
	
		this.setLayout(new BorderLayout());
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setClosable(true);
		this.setTitle("Product View");
		this.setVisible(true);
	}

	private void refreshTable() {
		Object[] column = {"ID", "Name", "Description", "Price","Stock"};
		
		dtm=new DefaultTableModel(column,0);

		Vector<MenuProduct>menus=MenuControllerProduct.getAllMenus();
		
		for(MenuProduct menuproductmanagement: menus) {
			rowData=new Vector<>();
			rowData.add(menuproductmanagement.getId());
			rowData.add(menuproductmanagement.getName());
			rowData.add(menuproductmanagement.getDescription());
			rowData.add(menuproductmanagement.getPrice());
			rowData.add(menuproductmanagement.getStock());
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
			String name=nameField.getText();
			String description=descriptionField.getText();
			String price=priceField.getText();
			String stock=stockField.getText();
			boolean isInserted=MenuControllerProduct.insertMenu(name,description,price,stock);
			if(isInserted) {
				refreshTable();
				
				nameField.setText("");
				descriptionField.setText("");
				priceField.setText("");
				stockField.setText("");
				JOptionPane.showMessageDialog(null, "Inserted!");
			}else {
				String errorMessage=MenuControllerProduct.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
		
		}else if(e.getSource()==updateButton){
			String id=idField.getText();
			String name=nameField.getText();
			String description=descriptionField.getText();
			String price=priceField.getText();
			String stock=stockField.getText();
			boolean isUpdated=MenuControllerProduct.updateMenu(name,description,price,id,stock);
			if(isUpdated) {
				refreshTable();
				
				nameField.setText("");
				descriptionField.setText("");
				priceField.setText("");
				stockField.setText("");
				JOptionPane.showMessageDialog(null, "Updated!");
			}else {
				String errorMessage=MenuControllerProduct.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}

		}else if(e.getSource()==deleteButton) {
			String id=idField.getText();
			int confirmDelete=JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
			if(confirmDelete!=JOptionPane.YES_OPTION) {
				return;
			}
			if(MenuControllerProduct.deleteMenu(id)){
				refreshTable();
				JOptionPane.showMessageDialog(null, "Deleted!");
			}else {
				String errorMessage=MenuControllerProduct.errorMessage;
				JOptionPane.showMessageDialog(null, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
