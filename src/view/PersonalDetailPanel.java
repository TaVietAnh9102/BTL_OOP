package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.IconView;

import models.Item;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class PersonalDetailPanel extends JPanel {

	private static Font LABEL_FONT = new Font("Arial", Font.BOLD, 13);
	private static Font FIELD_FONT = new Font("Arial", Font.PLAIN, 15);
	private static Color LABEL_FORE_GROUND_COLOR = Color.BLACK;
	
	private JTextField emailField;
	private JPasswordField passwordField;
	private JLabel iconEmail;
	private JLabel iconPassword;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel genderLabel;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private ButtonGroup buttonGroupGender;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JLabel birthDayLabel;
	private JLabel phoneLabel;
	private JLabel registerStatus;
	private JTextField phoneField;
	private JButton changeInfor;
	private JComboBox birthYear;
	private JComboBox birthMonth;
	private JComboBox birthDate;
	private JLabel avatar;
	
	private ItemTableScrollPane itemSold;
	private ItemTableScrollPane itemWin;
	
	 
	public PersonalDetailPanel() {
		setBackground(new Color(255, 255, 255));	
		setBounds(152, 87, 810, 505);
		setLayout(null);
		initComponents();
	}
	
	private void initComponents() {
		initLabels();
		initTextFields();
		initGroupButtons();
		initButtons();
		initBirthDayBox();
		initItemSold();
	}
	
	private void initItemSold() {
		itemSold = new ItemTableScrollPane();
		itemSold.setBounds(10, 240, 392, 241);
		add(itemSold);
		
		for(int i = 0; i <= 10; i++) {
			ItemPanel pn = new ItemPanel(new Item(), birthDate);
			pn.setPreferredSize(new Dimension(182, 300));
			itemSold.addItemPanel(pn);
		}
		
		itemWin = new ItemTableScrollPane();
		itemWin.setBounds(412, 240, 392, 241);
		add(itemWin);
	}

	private void initButtons() {
		changeInfor = new JButton("Change");
		
		changeInfor.setBounds(562, 166, 169, 31);	
		changeInfor.setFont(new Font("Arial", Font.BOLD, 18));
		changeInfor.setBackground(new Color(65, 105, 225));
		changeInfor.setForeground(new Color(255, 255, 255));
		changeInfor.setBorderPainted(false);
		changeInfor.setIcon(getIcon("/pic/icon_app.png"));
		add(changeInfor);
	}
	
	private void initTextFields() {
		
		emailField = new JTextField();
		emailField.setToolTipText("Example: userName@gmail.com");
		emailField.setBounds(281, 124, 175, 24);
		emailField.setDocument(new JTextFieldLimit(30));
		emailField.setFont(FIELD_FONT);
		add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Not contain special characters");
		passwordField.setDocument(new JTextFieldLimit(30));
		passwordField.setBounds(281, 170, 175, 24);
		passwordField.setFont(FIELD_FONT);
		add(passwordField);
		
		firstNameField = new JTextField(20);
		firstNameField.setDocument(new JTextFieldLimit(20));
		firstNameField.setToolTipText("");
		firstNameField.setBounds(281, 33, 175, 24);
		firstNameField.setFont(FIELD_FONT);
		add(firstNameField);
		
		lastNameField = new JTextField();
		lastNameField.setDocument(new JTextFieldLimit(20));
		lastNameField.setBounds(281, 78, 175, 24);
		lastNameField.setFont(FIELD_FONT);
		add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setToolTipText("only contain digits");
		phoneField.setDocument(new JTextFieldLimit(11));
		phoneField.setBounds(582, 124, 162, 24);
		phoneField.setFont(FIELD_FONT);
		add(phoneField);
	}
	
	private void initGroupButtons() {
		buttonGroupGender = new ButtonGroup();
		
		maleButton = new JRadioButton("Male");
		maleButton.setBounds(582, 34, 71, 25);
		maleButton.setBackground(new Color(65, 105, 225));
		maleButton.setFont(LABEL_FONT);
		buttonGroupGender.add(maleButton);
		add(maleButton);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(675, 34, 69, 25);
		femaleButton.setBackground(new Color(255, 102, 204));
		femaleButton.setFont(LABEL_FONT);
		buttonGroupGender.add(femaleButton);
		add(femaleButton);
		
	}
	
	private void initLabels() {
		setLayout(null);
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(LABEL_FONT);
		firstNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setBounds(179, 36, 85, 21);
		add(firstNameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(LABEL_FONT);
		lastNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lastNameLabel.setBounds(180, 80, 84, 21);
		add(lastNameLabel);
		
		iconEmail = new JLabel("Email");
		iconEmail.setFont(LABEL_FONT);
		iconEmail.setForeground(LABEL_FORE_GROUND_COLOR);
		iconEmail.setHorizontalAlignment(SwingConstants.LEFT);
		iconEmail.setBounds(180, 127, 84, 21);
		add(iconEmail);
		
		iconPassword = new JLabel("Password");
		iconPassword.setFont(LABEL_FONT);
		iconPassword.setForeground(LABEL_FORE_GROUND_COLOR);
		iconPassword.setBounds(179, 173, 85, 21);
		add(iconPassword);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setFont(LABEL_FONT);
		genderLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		genderLabel.setBounds(505, 36, 67, 21);
		add(genderLabel);
		
		birthDayLabel = new JLabel("Birth Day");
		birthDayLabel.setFont(LABEL_FONT);
		birthDayLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		birthDayLabel.setBounds(505, 81, 67, 18);
		add(birthDayLabel);
		
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(LABEL_FONT);
		phoneLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		phoneLabel.setBounds(505, 127, 67, 20);
		add(phoneLabel);
		
	}
	
	private void initBirthDayBox() {
		birthYear = new JComboBox();
		setListBirthYear();
		birthYear.setBounds(584, 81, 54, 21);
		birthYear.setSelectedIndex(0);
		add(birthYear);
		
		birthMonth = new JComboBox();
		setListBirthMonth();
		birthMonth.setBounds(659, 81, 40, 21);
		birthMonth.setSelectedIndex(0);
		add(birthMonth);
		
		birthDate = new JComboBox();
		setListBirthDate(31);
		birthDate.setBounds(715, 81, 29, 21);
		birthDate.setSelectedIndex(0);
		add(birthDate);
		
		avatar = new JLabel("Avatar");
		avatar.setBounds(10, 10, 148, 184);
		add(avatar);
	}
	
	public void setListBirthYear() {
		List<String> listbirthYear = new ArrayList<>();
		for(int year = 1930; year <= 2004; year++) {
			listbirthYear.add(year + "");
		}
		birthYear.setModel(new DefaultComboBoxModel(listbirthYear.toArray()));
	}
	
	
	public void setListBirthMonth() {
		List<String> listMonth = new ArrayList<>();
		for(int month = 1; month <= 12; month++) {
			listMonth.add(month + "");
		}
		birthMonth.setModel(new DefaultComboBoxModel(listMonth.toArray()));
	}
	
	public void setListBirthDate(int lengthMonth) {
		int indexSelected = birthDate.getSelectedIndex();
		List<String> listDate = new ArrayList<>();
		for(int date = 1; date <= lengthMonth; date++) {
			listDate.add(date + "");
		}
		birthDate.setModel(new DefaultComboBoxModel(listDate.toArray()));
		birthDate.setSelectedIndex(indexSelected);
	}
	
	
	public String getFirstName() {
		return firstNameField.getText();
	}
	
	
	public String getLastName() {
		return lastNameField.getText();
	}
	
	public String getEmail() {
		return emailField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
	public int getGender() {
		if(femaleButton.isSelected()) return 1;
		return 0;
	}
	
	public String getBirthMonth() {
		return (String) birthMonth.getSelectedItem();
	}
	
	public String getBirthYear() {
		return (String) birthYear.getSelectedItem();
	}
	
	public String getBirthDate() {
		return (String) birthDate.getSelectedItem();
	}
	
	public String getPhone() {
		return phoneField.getText();
	}
	
	private ImageIcon getIcon(String src) {
		ImageIcon icon = new ImageIcon(LoginView.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
	
	public void addListener(ActionListener e) {
		changeInfor.addActionListener(e);
	}
	
	public void setVisibleMessage(boolean status) {
		registerStatus.setVisible(status);
	}
	
	public void addItemListener(ItemListener i) {
		birthYear.addItemListener(i);
		birthMonth.addItemListener(i);
	}
	
//	public void addItem(List<Item> items) {
//		for(Item item : items) {
//			if(containsKey(item.getCatName())) {
//				addItem(item);
//			}
//		}
//	}
//	
//	public void addItem(Item item) {
//		if(tabs.containsKey(item.getCatName())) {
//			ItemPanel itemPanel = new ItemPanel(item, itemListener);
//			itemPanel.setItemBidding();
//			tabs.get(item.getCatName()).addItemPanel(new ItemPanel(item, itemListener));
//			tabs.get("All").addItemPanel(itemPanel);
//		}
//		
//	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(152, 87, 810, 505);
		f.getContentPane().add(new PersonalDetailPanel());
		f.setVisible(true);
	}
	
}
