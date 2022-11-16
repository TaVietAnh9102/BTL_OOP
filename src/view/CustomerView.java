package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;

public class CustomerView extends JFrame {

	private static Font FONT_BUTTON = new Font("Arial", Font.BOLD, 12);
	private static Color FOREGROUND_COLOR = new Color(93,97,140);
	private JPanel contentPane;
	
	private JButton homeButton;
	private JButton personalDetailButton;
	private JButton submitItemButton;
	
	private JPanel personalDetail;
	private JPanel submitItemPanel;
	private HomePanel homePanel;

	public CustomerView() {
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
//		initHomePanel();
//		initPersonalDetail();
//		initSubmitItemPanel();
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
		menuPanel.setLayout(null);
		
		homeButton = new JButton("Home");
		homeButton.setBackground(new Color(255, 255, 255));
		homeButton.setBounds(0, 0, 120, 45);
		homeButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		homeButton.setForeground(FOREGROUND_COLOR);
		homeButton.setFont(FONT_BUTTON);
		menuPanel.add(homeButton);
		
		personalDetailButton = new JButton("Personal Detail");
		personalDetailButton.setBounds(0, 43, 120, 45);
		personalDetailButton.setForeground(FOREGROUND_COLOR);
		personalDetailButton.setFont(FONT_BUTTON);
		menuPanel.add(personalDetailButton);
		
		submitItemButton = new JButton("Submit Item");
		submitItemButton.setBounds(0, 86, 120, 45);
		submitItemButton.setForeground(FOREGROUND_COLOR);
		submitItemButton.setFont(FONT_BUTTON);
		menuPanel.add(submitItemButton);
		contentPane.add(menuPanel);
		
	}
	
	public void addPanel(JPanel panel) {
		contentPane.add(panel);
	}
	
//	private void initHomePanel() {
//		homePanel = new HomePanel();
//		homePanel.setBounds(152, 87, 800, 505);
//		homePanel.setBackground(new Color(255, 255, 255));
//	//	homePanel.addItem();
//		contentPane.add(homePanel);
//		homePanel.setVisible(true);
//	}
//	
//	
//	private void initPersonalDetail() {
//		
//	}
//	
//	private void initSubmitItemPanel() {
//		submitItemPanel = new JPanel();
//		submitItemPanel.setBounds(152, 87, 800, 505);
//		contentPane.add(submitItemPanel);
//		submitItemPanel.setVisible(false);
//	}
//	
	public void addListener(ActionListener e) {
		homeButton.addActionListener(e);
		personalDetailButton.addActionListener(e);
		submitItemButton.addActionListener(e);
	}
	
//	public void switchPanel(boolean homePanelStatus, boolean personalDetailStatus, boolean submitItemStatus) {
//		this.homePanel.setVisible(homePanelStatus);
//		this.personalDetail.setVisible(personalDetailStatus);
//		this.submitItemPanel.setVisible(submitItemStatus);
//	}
	
	
}
