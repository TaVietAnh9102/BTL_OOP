package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class CustomerView extends JFrame {

	private JPanel contentPane;

	private JButton homeButton;
	private JButton personalDetailButton;
	private JButton submitItemButton;
	
	private JPanel mainPanel;
	private JPanel homePanel;
	private JPanel pesonalDetail;
	private JPanel submitItemPanel;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
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
	public CustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Auction Application");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(93,97,140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initTitlePanel();
		initMenuPanel();
		initHomePanel();
		
	}
	
	private void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(new Color(93,97,140)));
		titlePanel.setBackground(new Color(255, 255, 255));
		titlePanel.setBounds(0, 0, 986, 62);
		titlePanel.setLayout(null);
		
		JLabel appNameLabel = new JLabel("AUCTION APP");
		appNameLabel.setForeground(new Color(93,97,140));
		appNameLabel.setFont(new Font("Arial Black", Font.BOLD, 21));
		appNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appNameLabel.setBounds(404, 10, 180, 38);
		titlePanel.add(appNameLabel);
		
		JLabel teamNameLabel = new JLabel("MADE BY DACA Team");
		teamNameLabel.setForeground(new Color(93,97,140));
		teamNameLabel.setFont(new Font("Ink Free", Font.ITALIC + Font.BOLD, 14));
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setBounds(501, 40, 157, 13);
		titlePanel.add(teamNameLabel);
		contentPane.add(titlePanel);
	}
	
	private void initMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(255, 255, 255));
		menuPanel.setBounds(10, 87, 106, 516);
		menuPanel.setLayout(null);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(0, 0, 106, 45);
		menuPanel.add(homeButton);
		
		personalDetailButton = new JButton("Personal detail");
		personalDetailButton.setBounds(0, 43, 106, 45);
		menuPanel.add(personalDetailButton);
		
		submitItemButton = new JButton("Submit Item");
		submitItemButton.setBounds(0, 86, 106, 45);
		menuPanel.add(submitItemButton);
		contentPane.add(menuPanel);	
		
	}
	
	private void initHomePanel() {
		homePanel = new JPanel();
		homePanel.setBackground(new Color(51, 153, 102));
		scrollPane = new JScrollPane(homePanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(139, 87, 837, 492);
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);
	}
	
	private void initPersonalDetail() {
		pesonalDetail = new JPanel();
		pesonalDetail.setBounds(139, 87, 837, 492);
		contentPane.add(pesonalDetail);
		personalDetailButton.setVisible(false);
	}
	
	private void initSubmitItemPanel() {
		submitItemPanel = new JPanel();
		submitItemPanel.setBounds(139, 87, 837, 492);
		contentPane.add(submitItemPanel);
		submitItemPanel.setVisible(false);
	}
}
