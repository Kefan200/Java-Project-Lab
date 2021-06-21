import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterPage extends JFrame{

	JPanel mainPanel, northPanel, southPanel, centerPanel, genderPanel;
	JLabel registerLabel, nameLabel, addressLabel, genderLabel, ageLabel, profileLabel, profileImageLabel;
	JTextField nameField;
	JTextArea addressArea;
	JRadioButton maleBtn, femaleBtn;
	ButtonGroup genderGrup;
	JComboBox ageBox;
	
	ImageIcon profileIcon;
	JCheckBox tnc;
	
	JButton registerbtn;
	
	Vector<Integer> age = new Vector<>();
	
	public RegisterPage() {
		mainPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(6, 2));
		genderPanel = new JPanel(new FlowLayout());
		genderGrup = new ButtonGroup();
		
		//NORTH PANEL
		registerLabel = new JLabel("Register");
		registerLabel.setForeground(Color.BLUE);
		registerLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		northPanel.add(registerLabel);
		
		//CENTER PANEL
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField();
		
		addressLabel = new JLabel("Address");
		addressArea = new JTextArea();
		
		genderLabel = new JLabel("Gender");
		
		maleBtn = new JRadioButton("Male");
		femaleBtn = new JRadioButton("Female");
		//Add kedalam Button Group
		genderGrup.add(femaleBtn);
		genderGrup.add(maleBtn);
		
		genderPanel.add(maleBtn);
		genderPanel.add(femaleBtn);
		
		ageLabel = new JLabel("Age");
		
		for (int i = 1; i < 101; i++) {
			age.add(i);
		}
		ageBox = new JComboBox(age);
		
		profileLabel = new JLabel("Profile");

		//image icon harus di masukan kedalam label
		profileIcon = new ImageIcon("IU.png");
		profileImageLabel = new JLabel(profileIcon);
		
		tnc = new JCheckBox("Terms and Condition");
		
		
		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		centerPanel.add(addressLabel);
		centerPanel.add(addressArea);
		centerPanel.add(genderLabel);
		centerPanel.add(genderPanel);
		centerPanel.add(ageLabel);
		centerPanel.add(ageBox);
		centerPanel.add(profileLabel);
		centerPanel.add(profileImageLabel);
		centerPanel.add(tnc);
		
		//SOUTH
		registerbtn = new JButton("Register");
		southPanel.add(registerbtn);
		
		//SET MAIN PANEL
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		add(mainPanel);
		
		//SET JFrame
		setSize(new Dimension(500,600));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
