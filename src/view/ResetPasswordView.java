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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ResetPasswordView extends JFrame {

	private JPanel contentPane;
	private JPanel backGround;
	private JPanel mainPanel;
	private JTextField emailField;
	private JLabel iconEmail;
	private JLabel newPasswordLabel;
	
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
		setResizable(false);
		setSize(300, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		initMainPanel();
		contentPane.add(mainPanel);
		
		newPasswordLabel = new JLabel("password is your phone number.");
		newPasswordLabel.setForeground(Color.RED);
		newPasswordLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLabel.setBounds(56, 112, 174, 21);
		mainPanel.add(newPasswordLabel);
		
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	private void initMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 286, 313);
		mainPanel.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(77, 43, 174, 30);
		mainPanel.add(emailField);
		
		
		
		iconEmail = new JLabel("email");
		iconEmail.setIcon(getIcon("/pic/email.png"));
		iconEmail.setBounds(21, 41, 32, 32);
		mainPanel.add(iconEmail);
		
		
		JButton signUpButton = new JButton("Reset");
		signUpButton.setBounds(40, 202, 203, 64);
		
		signUpButton.setFont(new Font("Arial", Font.BOLD, 18));
		signUpButton.setBackground(new Color(65, 105, 225));
		signUpButton.setForeground(new Color(255, 255, 255));
		signUpButton.setBorderPainted(false);
		signUpButton.setIcon(getIcon("/pic/icon_app.png"));
		mainPanel.add(signUpButton);
	}
	
	private ImageIcon getIcon(String src) {
		ImageIcon icon = new ImageIcon(LoginView.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
}
