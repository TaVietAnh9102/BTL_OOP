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
	private JButton forgotPassword;
	private JButton signUpButton;
	
	
	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/pic/icon_app.png")));
		setTitle("Auction Application");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		initComponents();		
		setBackground();
		contentPane.add(transparentPanel);
		contentPane.add(background);
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
		
		JLabel email = new JLabel("UserName");
		email.setFont(FONT);
		email.setForeground(FOREGROUND_COLOR);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(116, 132, 125, 28);
		transparentPanel.add(email);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(FONT);
		passwordLabel.setForeground(FOREGROUND_COLOR);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(116, 190, 125, 28);
		transparentPanel.add(passwordLabel);
		
		emailField = new JTextField();
		emailField.setBounds(272, 132, 274, 28);
		emailField.setFont(FONT);
		emailField.setForeground(FOREGROUND_COLOR);
		emailField.setBackground(TEXTFIELD_BACKGROUND_COLOR);
		transparentPanel.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 190, 274, 28);
		passwordField.setFont(FONT);
		passwordField.setForeground(FOREGROUND_COLOR);
		passwordField.setBackground(TEXTFIELD_BACKGROUND_COLOR);
		transparentPanel.add(passwordField);
		
		initButtons();
		
	}
	
	private void initButtons() {
		loginButton = new JButton("Login");
		loginButton.setBounds(401, 276, 145, 28);
		loginButton.setFont(FONT);
		loginButton.setBackground(new Color(0, 102, 255));
		loginButton.setForeground(FOREGROUND_COLOR);
		loginButton.setBorderPainted(false);
		transparentPanel.add(loginButton);
		
		signUpButton = new JButton("Sign Up");
		signUpButton.setFont(FONT);
		signUpButton.setBounds(165, 276, 145, 28);
		signUpButton.setBackground(new Color(7, 255, 82));
		signUpButton.setForeground(FOREGROUND_COLOR);
		signUpButton.setBorderPainted(false);
		transparentPanel.add(signUpButton);
		
		forgotPassword = new JButton("Forgot Password?");
		forgotPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		forgotPassword.setBackground(new Color(255, 0, 51));
		forgotPassword.setForeground(FOREGROUND_COLOR);
		forgotPassword.setBounds(401, 228, 145, 21);
		forgotPassword.setBorderPainted(false);
		transparentPanel.add(forgotPassword);
	}
	
	public void addListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		signUpButton.addActionListener(listener);
		forgotPassword.addActionListener(listener);
	}
	
	
	public String getEmail() {
		return emailField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
}
