package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class ResetPasswordView extends JFrame {

	private JPanel contentPane;
	private JPanel backGround;
	private JPanel groupTextField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;
	private JLabel iconEmail;
	private JLabel iconPassword;
	private JLabel iconPasswordRp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPasswordView frame = new ResetPasswordView();
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
	public ResetPasswordView() {
		getContentPane().setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		initGroupTextField();
		contentPane.add(backGround);
		
		
	}
	
	private void initGroupTextField() {
		groupTextField = new JPanel();
		groupTextField.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.3f));
		groupTextField.setBounds(69, 28, 305, 343);
		backGround.add(groupTextField);
		groupTextField.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(90, 43, 187, 30);
		groupTextField.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 94, 187, 30);
		groupTextField.add(passwordField);
		
		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setToolTipText("reapeat password\r\n");
		repeatPasswordField.setBounds(90, 144, 187, 30);
		groupTextField.add(repeatPasswordField);
		
		iconEmail = new JLabel("email");
		iconEmail.setIcon(getIcon("/pic/email.png"));
		iconEmail.setBounds(36, 41, 32, 32);
		groupTextField.add(iconEmail);
		
		iconPassword = new JLabel("pass");
		iconPassword.setIcon(getIcon("/pic/padlock.png"));
		iconPassword.setBounds(36, 92, 32, 32);
		groupTextField.add(iconPassword);
		
		iconPasswordRp = new JLabel("pass");
		iconPasswordRp.setIcon(getIcon("/pic/padlock.png"));
		iconPasswordRp.setBounds(36, 142, 32, 32);
		groupTextField.add(iconPasswordRp);
		
		JButton signUpButton = new JButton("Reset");
		signUpButton.setBounds(60, 205, 203, 64);
		
		signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
		signUpButton.setBackground(new Color(65, 105, 225));
		signUpButton.setForeground(new Color(255, 255, 255));
		signUpButton.setBorderPainted(false);
		signUpButton.setIcon(getIcon("/pic/icon_app.png"));
		groupTextField.add(signUpButton);
	}
	
	private ImageIcon getIcon(String src) {
		ImageIcon icon = new ImageIcon(LoginView.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
	
	
}
