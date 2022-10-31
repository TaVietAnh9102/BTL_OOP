package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.IconView;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class SignUpView extends JDialog {

	private static Font LABEL_FONT = new Font("Arial", Font.BOLD, 13);
	
	private static Color LABEL_FORE_GROUND_COLOR = Color.white;
	
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
	private JTextField phoneField;
	private JButton signUpButton;
	private JComboBox Years;
	private JComboBox Months;
	private JComboBox Days;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpView() {
		getContentPane().setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.setResizable(false);
		setSize(450, 500);
		setLocationRelativeTo(null);
		
		initComponents();
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		backGround = new JPanel();
		backGround.setBackground(new Color(0, 255, 255));
		backGround.setBounds(0, 0, 436, 463);
		backGround.setLayout(null);
		
		contentPane.add(backGround);
		initMainPanel();
		
		
	}
	
	private void initMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.3f));
		mainPanel.setBounds(69, 28, 305, 368);
		mainPanel.setLayout(null);

		initLabels();
		initTextFields();
		initGroupButtons();
		initButtons();
		
		backGround.add(mainPanel);
		
		Years = new JComboBox();
		Years.setBounds(207, 199, 70, 21);
		mainPanel.add(Years);
		
		Months = new JComboBox();
		Months.setBounds(153, 199, 44, 21);
		mainPanel.add(Months);
		
		Days = new JComboBox();
		Days.setBounds(108, 200, 35, 21);
		mainPanel.add(Days);
	}
	
	private void initButtons() {
		signUpButton = new JButton("Sign Up Now!!!");
		signUpButton.setBounds(60, 294, 203, 64);	
		signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
		signUpButton.setBackground(new Color(65, 105, 225));
		signUpButton.setForeground(new Color(255, 255, 255));
		signUpButton.setBorderPainted(false);
		signUpButton.setIcon(getIcon("/pic/icon_app.png"));
		mainPanel.add(signUpButton);
	}
	
	private void initTextFields() {
		
		emailField = new JTextField();
		emailField.setBounds(108, 95, 169, 19);
		mainPanel.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 130, 169, 19);
		mainPanel.add(passwordField);
		
		firstNameField = new JTextField();
		firstNameField.setToolTipText("@gmail.com");
		firstNameField.setBounds(108, 25, 169, 19);
		mainPanel.add(firstNameField);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(108, 60, 70, 19);
		mainPanel.add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setBounds(108, 235, 96, 19);
		mainPanel.add(phoneField);
	}
	
	private void initGroupButtons() {
		buttonGroupGender = new ButtonGroup();
		
		maleButton = new JRadioButton("Male");
		maleButton.setBounds(108, 165, 70, 19);
		maleButton.setBackground(new Color(65, 105, 225));
		buttonGroupGender.add(maleButton);
		mainPanel.add(maleButton);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(207, 165, 70, 19);
		femaleButton.setBackground(new Color(255, 102, 204));
		buttonGroupGender.add(femaleButton);
		mainPanel.add(femaleButton);
		
	}
	
	
	
	private void initLabels() {
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(LABEL_FONT);
		firstNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setBounds(22, 25, 70, 19);
		mainPanel.add(firstNameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(LABEL_FONT);
		lastNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lastNameLabel.setBounds(22, 60, 70, 19);
		mainPanel.add(lastNameLabel);
		
		iconEmail = new JLabel("email");
		iconEmail.setFont(LABEL_FONT);
		iconEmail.setForeground(LABEL_FORE_GROUND_COLOR);
		iconEmail.setHorizontalAlignment(SwingConstants.LEFT);
		iconEmail.setBounds(22, 95, 70, 19);
		mainPanel.add(iconEmail);
		
		iconPassword = new JLabel("pass");
		iconPassword.setFont(LABEL_FONT);
		iconPassword.setForeground(LABEL_FORE_GROUND_COLOR);
		iconPassword.setBounds(22, 130, 70, 19);
		mainPanel.add(iconPassword);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setFont(LABEL_FONT);
		genderLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		genderLabel.setBounds(22, 165, 70, 19);
		mainPanel.add(genderLabel);
		
		birthDayLabel = new JLabel("Birth Day");
		birthDayLabel.setFont(LABEL_FONT);
		birthDayLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		birthDayLabel.setBounds(22, 200, 70, 19);
		mainPanel.add(birthDayLabel);
		
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(LABEL_FONT);
		phoneLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		phoneLabel.setBounds(22, 235, 70, 19);
		mainPanel.add(phoneLabel);
		
	}
	
	private void setListMonths() {
		
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
	
	public String getBirthDay() {
		return Days.getSelectedItem().toString() + "/" + Months.getSelectedItem().toString() + "/" + Years.getSelectedItem().toString();
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
	
}
