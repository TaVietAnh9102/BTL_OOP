package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Item;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class BidderView extends JFrame {

	private JPanel contentPane;
	private Item item;
	private JLabel countDownLabel;
	
	
	
	private Timer countDown;
	private int second;
	private int minutes;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BidderView frame = new BidderView();
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
	public BidderView() {
		minutes = 0;
		second = 15;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 646, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(204, 153, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		createCountDownLabel();
		
	}
	
	private void createTableParticipatedBidders() {
		
		
	}
	
	public void createCountDownLabel() {
		countDownLabel = new JLabel(String.format("%02d:%02d", minutes, second));
		countDownLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countDownLabel.setForeground(new Color(0, 255, 51));
		countDownLabel.setFont(new Font("Arial", Font.BOLD, 30));
		countDownLabel.setBackground(new Color(255, 255, 255));
		countDownLabel.setBounds(23, 201, 180, 70);
		contentPane.add(countDownLabel);
		
		JLabel imageItem = new JLabel("New label");
		imageItem.setBounds(23, 10, 180, 199);
		contentPane.add(imageItem);
		
		JLabel itemNameLabel = new JLabel("Name");
		itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		itemNameLabel.setBounds(213, 25, 83, 26);
		contentPane.add(itemNameLabel);
		
		JTextArea itemName = new JTextArea();
		itemName.setText("Laptop A1111");
		itemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		itemName.setBounds(306, 29, 244, 44);
		contentPane.add(itemName);
		
		JLabel detailsItemLabel = new JLabel("Details");
		detailsItemLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		detailsItemLabel.setBounds(213, 81, 83, 26);
		contentPane.add(detailsItemLabel);
		
		JTextArea detailsItem = new JTextArea();
		detailsItem.setText("Ram 128");
		detailsItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		detailsItem.setBounds(306, 83, 244, 44);
		contentPane.add(detailsItem);
		
		JLabel sellerLabel = new JLabel("Seller");
		sellerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerLabel.setBounds(213, 139, 83, 26);
		contentPane.add(sellerLabel);
		
		JLabel sellerName = new JLabel("seller");
		sellerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerName.setBounds(306, 137, 227, 26);
		contentPane.add(sellerName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 248, 386, 184);
		contentPane.add(scrollPane);
		
		JLabel Bidders = new JLabel("Participated Bidders");
		Bidders.setFont(new Font("Tahoma", Font.BOLD, 14));
		Bidders.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(Bidders);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Price", "State", "Phone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		createTimer();
		countDown.start();
	}
	
	public void createTimer() {
		countDown = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				if(minutes == 0 && second <= 10) countDownLabel.setForeground(Color.RED);
				if(second == -1) {
					if(minutes == 0) {
						countDown.stop();
						countDownLabel.setText("End Time!!!");
						return;
					}
					minutes--;
					second = 59;
				}
				countDownLabel.setText(String.format("%02d:%02d", minutes, second));
			}
		});
	}
}
