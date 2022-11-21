package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CustomerView extends JFrame {

	private static Font FONT_BUTTON = new Font("Arial", Font.BOLD, 12);
	private static Color FOREGROUND_COLOR = new Color(93,97,140);
	private JPanel contentPane;
	
	private JButton homeButton;
	private JButton soldButton;
	private JButton participatedButton;
	private JButton personalDetailButton;
	private JButton submitItemButton;
	private JButton logOutButton;
	
	private JPanel personalDetail;
	private JPanel submitItemPanel;
	private ItemsTablePanel homePanel;

	public CustomerView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerView.class.getResource("/pic/icon_app.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Auction Application");
		setResizable(false);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(93,97,140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initTitlePanel();
		initMenuPanel();
		setVisible(true);
	}
	
	private void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(FOREGROUND_COLOR));
		titlePanel.setBackground(new Color(255, 255, 255));
		titlePanel.setBounds(0, 0, 986, 62);
		titlePanel.setLayout(null);
		
		JLabel appNameLabel = new JLabel("AUCTION APP");
		appNameLabel.setForeground(FOREGROUND_COLOR);
		appNameLabel.setFont(new Font("Arial Black", Font.BOLD, 21));
		appNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appNameLabel.setBounds(404, 10, 180, 38);
		titlePanel.add(appNameLabel);
		
		JLabel teamNameLabel = new JLabel("MADE BY DACA Team");
		teamNameLabel.setForeground(FOREGROUND_COLOR);
		teamNameLabel.setFont(new Font("Ink Free", Font.ITALIC + Font.BOLD, 14));
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setBounds(501, 40, 157, 13);
		titlePanel.add(teamNameLabel);
		contentPane.add(titlePanel);
	}
	
	private void initMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(255, 255, 255));
		menuPanel.setBounds(10, 87, 120, 505);
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		homeButton = new JButton("Home");
		homeButton.setPreferredSize(new Dimension(120, 35));
		homeButton.setForeground(FOREGROUND_COLOR);
		homeButton.setFont(FONT_BUTTON);
		menuPanel.add(homeButton);
		
		participatedButton = new JButton("Participated");
		participatedButton.setPreferredSize(new Dimension(120, 35));
		participatedButton.setForeground(FOREGROUND_COLOR);
		participatedButton.setFont(FONT_BUTTON);
		menuPanel.add(participatedButton);
		
		soldButton = new JButton("Sold product");
		soldButton.setPreferredSize(new Dimension(120, 35));
		soldButton.setForeground(FOREGROUND_COLOR);
		soldButton.setFont(FONT_BUTTON);
		menuPanel.add(soldButton);
		
		submitItemButton = new JButton("Submit Item");
		submitItemButton.setPreferredSize(new Dimension(120, 35));
		submitItemButton.setForeground(FOREGROUND_COLOR);
		submitItemButton.setFont(FONT_BUTTON);
		menuPanel.add(submitItemButton);
				
		personalDetailButton = new JButton("Personal Detail");
		personalDetailButton.setPreferredSize(new Dimension(120, 35));
		personalDetailButton.setForeground(FOREGROUND_COLOR);
		personalDetailButton.setFont(FONT_BUTTON);
		menuPanel.add(personalDetailButton);
		
		logOutButton = new JButton("LogOut");
		logOutButton.setPreferredSize(new Dimension(120, 35));
		logOutButton.setForeground(FOREGROUND_COLOR);
		logOutButton.setFont(FONT_BUTTON);
		menuPanel.add(logOutButton);
		contentPane.add(menuPanel);
	}
	
	public void addPanel(JPanel panel) {
		contentPane.add(panel);
	}
	
	public void removePanel(JPanel panel) {
		contentPane.remove(panel);
	}

	public void addListener(ActionListener e) {
		homeButton.addActionListener(e);
		participatedButton.addActionListener(e);
		soldButton.addActionListener(e);
		personalDetailButton.addActionListener(e);
		submitItemButton.addActionListener(e);
		logOutButton.addActionListener(e);
	}
}
