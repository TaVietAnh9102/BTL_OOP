package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Item;
import models.Member;
import models.Sessions;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.CollectionCertStoreParameters;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class BidderView extends JFrame {
	private Member member;
	private JPanel contentPane;
	private Item item;
	private JLabel countDownLabel;
	
	private JTextField newPriceField;
	private JButton submitButton;
	
	private JTable table;
	
	private Timer countDown;
	private int startTime;
	private int endTime;
	private int hours;
	private int minutes;
	private int seconds;
	
	
	
	
	
	public BidderView(Item item, Member member) {
		this.item = item;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 646, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(204, 153, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initComponents();
		initChart();
		if(member.getId() != item.getSeller_ID()) {
			initSubmitPriceLabel();
		}
		createCountDownLabel();
		
	}
	
	private void initChart() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 248, 386, 184);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "First Name", "Last Name", "Price"}, 0);
		table = new JTable(model);
        ArrayList<Object[]> participantsBidder =  item.getParticipatedBidders(item.getSession_ID(), item.getId());
        for(Object[] infor : participantsBidder) {
        	model.addRow(new Object[]{infor[0], infor[1], infor[2], infor[5]});
        }
                
		//table.getColumnModel().getColumn(1).setPreferredWidth(105);
		//table.getColumnModel().getColumn(2).setPreferredWidth(80);
		scrollPane.setViewportView(table);
	}
	
	public void createCountDownLabel() {
		countDownLabel = new JLabel("Pending");
		countDownLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countDownLabel.setForeground(new Color(0, 255, 51));
		countDownLabel.setFont(new Font("Arial", Font.BOLD, 30));
		countDownLabel.setBackground(new Color(255, 255, 255));
		countDownLabel.setBounds(23, 201, 180, 70);
		contentPane.add(countDownLabel);
		createTimer();
		countDown.start();
	}
	
	private void initComponents() {
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
		itemName.setBounds(306, 29, 244, 32);
		contentPane.add(itemName);
		
		JLabel sellerLabel = new JLabel("Seller");
		sellerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerLabel.setBounds(213, 77, 83, 26);
		contentPane.add(sellerLabel);
		
		JLabel sellerName = new JLabel("seller");
		sellerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerName.setBounds(306, 77, 244, 32);
		contentPane.add(sellerName);
		
		JLabel currentPriceLabel = new JLabel("Current Price");
		currentPriceLabel.setBounds(213, 128, 83, 26);
		contentPane.add(currentPriceLabel);
		
		JLabel currentPriceValue = new JLabel("New label");
		currentPriceValue.setBounds(306, 128, 244, 31);
		contentPane.add(currentPriceValue);

	}
	
	private void initSubmitPriceLabel() {
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(448, 184, 102, 33);
		contentPane.add(submitButton);
		
		newPriceField = new JTextField();
		newPriceField.setBounds(213, 185, 180, 32);
		contentPane.add(newPriceField);
		newPriceField.setColumns(10);
	}
	
	public void createTimer() {
		LocalTime now = LocalTime.now();
		startTime = item.getSession().getStart_time() * 3600;//0
		endTime  = item.getSession().getEnd_time() * 3600;//10800
		startTime = Math.max(startTime, now.getHour() * 3600 + now.getMinute() * 60 + now.getSecond());
		
		seconds = endTime - startTime;
		hours = Math.max(0,(seconds)/3600);
		minutes = Math.max(0, (seconds - hours*3600)/60);
		seconds = Math.max(0,(seconds - hours*3600 - minutes*60));
		
		
		countDown = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				if(hours == 0 && minutes == 0 && seconds <= 10) countDownLabel.setForeground(Color.RED);
				if(seconds == -1) {
					if(minutes == 0) {
						if(hours == 0) {
							countDown.stop();
							countDownLabel.setText("End time!!!");
							//
							return;
						}
						else {
							hours -= 1;
							minutes =59;
							seconds = 59;
						}
					}
					minutes--;
					seconds = 59;
				}
				if(now.getHour() * 3600 + now.getMinute() * 60 + now.getSecond() <= startTime) {
					countDownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
				}
				
			}
		});
	}
	
	public void showBid(boolean ok) {
		//bt.setVisible(ok);
		//txfl.setVisble(ok);
	}
}
