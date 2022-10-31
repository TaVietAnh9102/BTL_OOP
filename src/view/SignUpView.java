package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.IconView;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;

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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.Toolkit;

public class SignUpView extends JDialog {

	private static Font LABEL_FONT = new Font("Arial", Font.BOLD, 13);
	
	private static Color LABEL_FORE_GROUND_COLOR = Color.BLACK;
	
	private JPanel contentPane;
	private JPanel backGround;
	private JPanel mainPanel;
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
	private JLabel signUpStatus;
	private JTextField phoneField;
	private JButton signUpButton;
	private JComboBox Years;
	private JComboBox Months;
	private JComboBox Days;
	
	 
	public SignUpView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpView.class.getResource("/pic/icon_app.png")));
		getContentPane().setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.setResizable(false);
		setSize(400, 500);
		
		setLocationRelativeTo(null);
		
		initComponents();
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		initMainPanel();
		contentPane.add(mainPanel);
		
		
		
		
	}
	
	private void initMainPanel() {
		mainPanel = new JPanel();
//		mainPanel.setBackground(new Color(51, 204, 153));
		mainPanel.setBounds(0, 0, 386, 463);
		mainPanel.setLayout(null);

		initLabels();
		initTextFields();
		initGroupButtons();
		initButtons();
		initBirthDayBox();
	}
	
	private void initButtons() {
		signUpButton = new JButton("Sign Up Now!!!");
		signUpButton.setBounds(95, 347, 203, 64);	
		signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
		signUpButton.setBackground(new Color(65, 105, 225));
		signUpButton.setForeground(new Color(255, 255, 255));
		signUpButton.setBorderPainted(false);
		signUpButton.setIcon(getIcon("/pic/icon_app.png"));
		mainPanel.add(signUpButton);
	}
	
	private void initTextFields() {
		
		emailField = new JTextField();
		emailField.setBounds(156, 110, 185, 27);
		mainPanel.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 150, 185, 27);
		mainPanel.add(passwordField);
		
		firstNameField = new JTextField();
		firstNameField.setToolTipText("@gmail.com");
		firstNameField.setBounds(156, 30, 185, 27);
		mainPanel.add(firstNameField);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(156, 70, 87, 27);
		mainPanel.add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setBounds(156, 270, 117, 27);
		mainPanel.add(phoneField);
	}
	
	private void initGroupButtons() {
		buttonGroupGender = new ButtonGroup();
		
		maleButton = new JRadioButton("Male");
		maleButton.setBounds(156, 190, 87, 27);
		maleButton.setBackground(new Color(65, 105, 225));
		maleButton.setFont(LABEL_FONT);
		buttonGroupGender.add(maleButton);
		mainPanel.add(maleButton);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(254, 190, 87, 27);
		femaleButton.setBackground(new Color(255, 102, 204));
		femaleButton.setFont(LABEL_FONT);
		buttonGroupGender.add(femaleButton);
		mainPanel.add(femaleButton);
		
	}
	
	
	
	private void initLabels() {
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(LABEL_FONT);
		firstNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setBounds(49, 30, 70, 27);
		mainPanel.add(firstNameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(LABEL_FONT);
		lastNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lastNameLabel.setBounds(49, 70, 70, 27);
		mainPanel.add(lastNameLabel);
		
		iconEmail = new JLabel("Email");
		iconEmail.setFont(LABEL_FONT);
		iconEmail.setForeground(LABEL_FORE_GROUND_COLOR);
		iconEmail.setHorizontalAlignment(SwingConstants.LEFT);
		iconEmail.setBounds(49, 110, 70, 27);
		mainPanel.add(iconEmail);
		
		iconPassword = new JLabel("Password");
		iconPassword.setFont(LABEL_FONT);
		iconPassword.setForeground(LABEL_FORE_GROUND_COLOR);
		iconPassword.setBounds(49, 150, 70, 27);
		mainPanel.add(iconPassword);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setFont(LABEL_FONT);
		genderLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		genderLabel.setBounds(49, 190, 70, 27);
		mainPanel.add(genderLabel);
		
		birthDayLabel = new JLabel("Birth Day");
		birthDayLabel.setFont(LABEL_FONT);
		birthDayLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		birthDayLabel.setBounds(49, 230, 70, 27);
		mainPanel.add(birthDayLabel);
		
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(LABEL_FONT);
		phoneLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		phoneLabel.setBounds(49, 270, 70, 27);
		mainPanel.add(phoneLabel);
		
		signUpStatus = new JLabel("Missing Infor !");
		signUpStatus.setHorizontalAlignment(SwingConstants.CENTER);
		signUpStatus.setFont(new Font("Arial", Font.BOLD, 16));
		signUpStatus.setForeground(new Color(204, 0, 0));
		signUpStatus.setBounds(47, 314, 294, 23);
		mainPanel.add(signUpStatus);
		signUpStatus.setVisible(false);
	}
	
	private void initBirthDayBox() {
		Years = new JComboBox();
		setListYears();
		Years.setBounds(279, 230, 62, 27);
		mainPanel.add(Years);
		
		Months = new JComboBox();
		setListMonths();
		Months.setBounds(218, 230, 55, 27);
		mainPanel.add(Months);
		
		Days = new JComboBox();
		setListDays(31);
		Days.setBounds(156, 230, 44, 27);
		mainPanel.add(Days);
	}
	
	public void setListYears() {
		List<String> listYears = new ArrayList<>();
		for(int year = 1930; year <= 2004; year++) {
			listYears.add(year + "");
		}
		Years.setModel(new DefaultComboBoxModel(listYears.toArray()));
	}
	
	
	public void setListMonths() {
		List<String> listMonth = new ArrayList<>();
		for(int month = 1; month <= 12; month++) {
			listMonth.add(month + "");
		}
		Months.setModel(new DefaultComboBoxModel(listMonth.toArray()));
	}
	
	public void setListDays(int lengthMonth) {
		List<String> listDate = new ArrayList<>();
		for(int date = 1; date <= lengthMonth; date++) {
			listDate.add(date + "");
		}
		Days.setModel(new DefaultComboBoxModel(listDate.toArray()));
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
	
	public String getMonth() {
		return (String) Months.getSelectedItem();
	}
	
	public String getYear() {
		return (String) Years.getSelectedItem();
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
		signUpButton.addActionListener(e);
	}
	
	public void switchMessageLabel(boolean status) {
		signUpStatus.setVisible(status);
	}
	
	public void addItemListener(ItemListener i) {
		Years.addItemListener(i);
		Months.addItemListener(i);
	}
}
