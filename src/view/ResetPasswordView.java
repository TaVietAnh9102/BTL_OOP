package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ResetPasswordView extends JDialog {

	private JPanel contentPane;
	private JPanel backGround;
	private JPanel mainPanel;
	private JTextField emailField;
	private JLabel iconEmail;
	private JLabel statusLabel;
	private JButton resetButton;
	
	public ResetPasswordView() {
		getContentPane().setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(300, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		initMainPanel();
		contentPane.add(mainPanel);
		
		statusLabel = new JLabel("");
		statusLabel.setForeground(Color.RED);
		statusLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(56, 112, 174, 21);
		mainPanel.add(statusLabel);
		
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
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(40, 202, 203, 64);
		resetButton.setFont(new Font("Arial", Font.BOLD, 18));
		resetButton.setBackground(new Color(65, 105, 225));
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setBorderPainted(false);
		resetButton.setIcon(getIcon("/pic/icon_app.png"));
		mainPanel.add(resetButton);
	}
	
	public String getEmail() {
		return emailField.getText();
	}
	
	public void updateStatus(String status) {
		statusLabel.setText(status);
	}
	
	public void addListener(ActionListener e) {
		resetButton.addActionListener(e);
	}
	
	private ImageIcon getIcon(String src) {
		ImageIcon icon = new ImageIcon(LoginView.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
}
