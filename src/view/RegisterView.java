package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RegisterView extends JDialog {

	private static Font LABEL_FONT = new Font("Arial", Font.BOLD, 13);
	private static Font FIELD_FONT = new Font("Arial", Font.PLAIN, 15);
	private static Color LABEL_FORE_GROUND_COLOR = Color.BLACK;
	
	private JPanel contentPane;
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
	private JLabel registerStatus;
	private JTextField phoneField;
	private JButton registerButton;
	private JComboBox birthYear;
	private JComboBox birthMonth;
	private JComboBox birthDate;
	
	 
	public RegisterView() {
		setForeground(Color.BLACK);
		setTitle("Register");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterView.class.getResource("/pic/icon_app.png")));
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
		mainPanel = new JPanel();
//		mainPanel.setBackground(new Color(51, 204, 153));
		mainPanel.setBounds(0, 0, 386, 463);
		mainPanel.setLayout(null);

		initLabels();
		initTextFields();
		initGroupButtons();
		initButtons();
		initBirthDayBox();
		contentPane.add(mainPanel);
	}
	
	private void initButtons() {
		registerButton = new JButton("Register Now!!!");
		
		registerButton.setBounds(95, 347, 203, 64);	
		registerButton.setFont(new Font("Arial", Font.BOLD, 18));
		registerButton.setBackground(new Color(65, 105, 225));
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBorderPainted(false);
		registerButton.setIcon(getIcon("/pic/icon_app.png"));
		mainPanel.add(registerButton);
	}
	
	private void initTextFields() {
		
		emailField = new JTextField();
		emailField.setToolTipText("Example: userName@gmail.com");
		emailField.setBounds(156, 110, 185, 27);
		emailField.setDocument(new JTextFieldLimit(30));
		emailField.setFont(FIELD_FONT);
		mainPanel.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Not contain special characters");
		passwordField.setDocument(new JTextFieldLimit(30));
		passwordField.setBounds(156, 150, 185, 27);
		passwordField.setFont(FIELD_FONT);
		mainPanel.add(passwordField);
		
		firstNameField = new JTextField(20);
		firstNameField.setDocument(new JTextFieldLimit(20));
		firstNameField.setToolTipText("");
		firstNameField.setBounds(156, 30, 185, 27);
		firstNameField.setFont(FIELD_FONT);
		mainPanel.add(firstNameField);
		
		lastNameField = new JTextField();
		lastNameField.setDocument(new JTextFieldLimit(20));
		lastNameField.setBounds(156, 70, 185, 27);
		lastNameField.setFont(FIELD_FONT);
		mainPanel.add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setToolTipText("only contain digits");
		phoneField.setDocument(new JTextFieldLimit(11));
		phoneField.setBounds(156, 270, 117, 27);
		phoneField.setFont(FIELD_FONT);
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
		
		registerStatus = new JLabel("Missing Infor !");
		registerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		registerStatus.setFont(new Font("Arial", Font.BOLD, 16));
		registerStatus.setForeground(new Color(204, 0, 0));
		registerStatus.setBounds(47, 314, 294, 23);
		mainPanel.add(registerStatus);
		registerStatus.setVisible(false);
	}
	
	private void initBirthDayBox() {
		birthYear = new JComboBox();
		setListBirthYear();
		birthYear.setBounds(275, 230, 66, 27);
		birthYear.setSelectedIndex(0);
		mainPanel.add(birthYear);
		
		birthMonth = new JComboBox();
		setListBirthMonth();
		birthMonth.setBounds(210, 230, 55, 27);
		birthMonth.setSelectedIndex(0);
		mainPanel.add(birthMonth);
		
		birthDate = new JComboBox();
		setListBirthDate(31);
		birthDate.setBounds(156, 230, 44, 27);
		birthDate.setSelectedIndex(0);
		mainPanel.add(birthDate);
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
		registerButton.addActionListener(e);
	}
	
	public void setVisibleMessage(boolean status) {
		registerStatus.setVisible(status);
	}
	
	public void addItemListener(ItemListener i) {
		birthYear.addItemListener(i);
		birthMonth.addItemListener(i);
	}
}
