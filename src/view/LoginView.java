package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.UIManager;

import controller.LoginController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginView extends JFrame {
	/**
	 * Launch the application.
	 */
	private static Color TEXTFIELD_BACKGROUND_COLOR = Color.DARK_GRAY;
	private static Color FOREGROUND_COLOR = Color.WHITE;
	private static Font FONT = new Font("Comic Sans MS", Font.BOLD, 18);
	
	private JPanel contentPane;
	private JLabel background;
	private JPanel transparentPanel;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton resetPassword;
	private JButton registerButton;
	private JTextField messagesLabel;
	
	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/pic/icon_app.png")));
		setTitle("Auction Application");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		initComponents();		
		setBackground();
		contentPane.add(transparentPanel);
		contentPane.add(background);
		setContentPane(contentPane);
		setVisible(true);
	}
	
	private void setBackground() {
		background = new JLabel("Image");
		background.setBounds(0, 0, 1000, 650);
		background.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon(LoginView.class.getResource("/pic/login_background.jpg"));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(imgScale));
		
	}
	
	private void initComponents() {
		transparentPanel = new JPanel();
		transparentPanel.setBackground(new Color(0.3f, 0.3f, 0.3f, 0.5f));
		transparentPanel.setBounds(141, 73, 731, 396);
		transparentPanel.setLayout(null);
		
		JLabel email = new JLabel("Email");
		email.setFont(FONT);
		email.setForeground(FOREGROUND_COLOR);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(166, 132, 96, 28);
		transparentPanel.add(email);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(FONT);
		passwordLabel.setForeground(FOREGROUND_COLOR);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(166, 190, 96, 28);
		transparentPanel.add(passwordLabel);
		
		emailField = new JTextField();
		emailField.setBounds(272, 132, 274, 28);
		emailField.setDocument(new JTextFieldLimit(30));
		emailField.setFont(FONT);
		emailField.setForeground(FOREGROUND_COLOR);
		emailField.setBackground(TEXTFIELD_BACKGROUND_COLOR);
		transparentPanel.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 190, 274, 28);
		passwordField.setDocument(new JTextFieldLimit(30));
		passwordField.setFont(FONT);
		passwordField.setForeground(FOREGROUND_COLOR);
		passwordField.setBackground(TEXTFIELD_BACKGROUND_COLOR);
		transparentPanel.add(passwordField);
		
		messagesLabel = new JTextField("");
		messagesLabel.setBackground(new Color(128, 128, 128));
		messagesLabel.setEditable(false);
		messagesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messagesLabel.setBounds(165, 228, 161, 21);
		messagesLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		messagesLabel.setBorder(null);
		messagesLabel.setForeground(Color.RED);
		transparentPanel.add(messagesLabel);
		
		initButtons();
		
	}
	
	
	void initButtons() {
		loginButton = new JButton("Login");
		loginButton.setBounds(385, 276, 161, 28);
		loginButton.setFont(FONT);
		loginButton.setBackground(new Color(0, 102, 255));
		loginButton.setForeground(FOREGROUND_COLOR);
		loginButton.setBorderPainted(false);
		transparentPanel.add(loginButton);
		
		registerButton = new JButton("Register");
		registerButton.setFont(FONT);
		registerButton.setBounds(165, 276, 161, 28);
		registerButton.setBackground(new Color(7, 255, 82));
		registerButton.setForeground(FOREGROUND_COLOR);
		registerButton.setBorderPainted(false);
		transparentPanel.add(registerButton);
		
		resetPassword = new JButton("Reset Password");
		resetPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		resetPassword.setBackground(new Color(255, 0, 51));
		resetPassword.setForeground(FOREGROUND_COLOR);
		resetPassword.setBounds(385, 228, 161, 21);
		resetPassword.setBorderPainted(false);
		transparentPanel.add(resetPassword);
	}
	
	public void addListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		registerButton.addActionListener(listener);
		resetPassword.addActionListener(listener);
	}
	
	
	public String getEmail() {
		return emailField.getText().strip();
	}
	
	public String getPassword() {
		return passwordField.getText().strip();
	}
	
	public void setMessage(String message) {
		messagesLabel.setText(message);
	}
	
}
