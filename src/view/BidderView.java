package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.ItemController;
import controller.ItemTableController;
import models.Item;
import models.Member;

public class BidderView extends JFrame {
	private Member member;
	private JPanel contentPane;
	private Item item;
	private JLabel countDownLabel;
	
	private JTextField newPriceField;
	private JButton submitButton;
	private JLabel currentPriceValueLabel;
	
	private ItemTableController itemController;
	
	private JTable table;
	private Timer countDown;
//	private Date startTime;
//	private Date endTime;
//	private long hours;
//	private long minutes;
//	private long seconds;
//	private long timeNow;
//	private int option;
	private JScrollPane scrollPane;
private JLabel winnerLabel;
	
	
	public BidderView(Item item, Member member, ItemTableController itemController) {
		this.itemController = itemController;
		this.member = member;
		setTitle("Auction App");
		setResizable(false);
		setSize(603, 611);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BidderView.class.getResource("/pic/icon_app.png")));
		this.item = item;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new LineBorder(new Color(204, 153, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initChart();
		initComponents();
		
		createCountDownLabel();
		initSubmitPriceLabel();
		
		
		setVisible(false);
	}
	
	private void initChart() {
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 333, 543, 217);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "First Name", "Last Name", "Price"}, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.BOLD, 13));
        ArrayList<Object[]> participantsBidder =  item.getParticipatedBidders(item.getSessionID(), item.getId());
        for(Object[] infor : participantsBidder) {
        	model.addRow(new Object[]{infor[0], infor[1], infor[2], infor[4]});
        }
        scrollPane.setViewportView(table);
        
        
        JLabel date = new JLabel("Date");
        date.setFont(new Font("Tahoma", Font.BOLD, 13));
        date.setBounds(265, 115, 99, 30);
        contentPane.add(date);
        
        JLabel dateValueLabel = new JLabel(item.getSession().getSession_date());
        dateValueLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        dateValueLabel.setBounds(376, 115, 133, 30);
        contentPane.add(dateValueLabel);
        
        JLabel startTimeLabel = new JLabel("StartTime");
        startTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        startTimeLabel.setBounds(263, 160, 99, 30);
        contentPane.add(startTimeLabel);
        
        JLabel startTimeValueLabel = new JLabel(String.format("%02d:00:00",  item.getSession().getStart_time()));
        startTimeValueLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        startTimeValueLabel.setBounds(376, 160, 73, 30);
        contentPane.add(startTimeValueLabel);
        
        JLabel endTimeLabel = new JLabel("End Time");
        endTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        endTimeLabel.setBounds(265, 205, 101, 30);
        contentPane.add(endTimeLabel);
        
        JLabel endTimeValueLabel = new JLabel(String.format("%02d:00:00",  item.getSession().getEnd_time()));
        endTimeValueLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        endTimeValueLabel.setBounds(376, 205, 73, 30);
        contentPane.add(endTimeValueLabel);
	}
	
	private void updateTable() {
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "First Name", "Last Name", "Price"}, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.BOLD, 13));
        ArrayList<Object[]> participantsBidder =  item.getParticipatedBidders(item.getSessionID(), item.getId());
        for(Object[] infor : participantsBidder) {
        	model.addRow(new Object[]{infor[0], infor[1], infor[2], infor[4]});
        }
        scrollPane.setViewportView(table);
	}
	
	public void createCountDownLabel() {
		if(item.getServed() == 1) {
			countDownLabel = new JLabel("End Time !!!");
		}
		else {
			countDownLabel = new JLabel("Pending");
			try {
				createTimer();
				countDownLabel.setHorizontalAlignment(SwingConstants.CENTER);
				countDownLabel.setForeground(new Color(51, 153, 51));
				countDownLabel.setFont(new Font("Arial", Font.BOLD, 30));
				countDownLabel.setBackground(new Color(255, 255, 255));
				countDownLabel.setBounds(23, 233, 196, 50);
				contentPane.add(countDownLabel);
				
				countDown.start();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
	
	private void initComponents() {
		
		JLabel imageItem = new JLabel("Icon");
		imageItem.setHorizontalAlignment(SwingConstants.CENTER);
		imageItem.setBounds(23, 23, 196, 200);
		imageItem.setIcon(getIcon(imageItem.getWidth(), imageItem.getHeight(), "/pic/dell_latitude_3520.jpg"));
		
		contentPane.add(imageItem);
		
		JLabel itemNameLabel = new JLabel("Name");
		itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		itemNameLabel.setBounds(265, 25, 101, 30);
		contentPane.add(itemNameLabel);
		
		JLabel itemNameValue = new JLabel(item.getName());
		itemNameValue.setFont(new Font("Tahoma", Font.BOLD, 13));
		itemNameValue.setBounds(376, 25, 190, 30);
		contentPane.add(itemNameValue);
		
		JLabel sellerLabel = new JLabel("Seller");
		sellerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerLabel.setBounds(265, 70, 101, 30);
		contentPane.add(sellerLabel);
		
		JLabel sellerNameValueLabel = new JLabel(item.getSellerName());
		sellerNameValueLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sellerNameValueLabel.setBounds(376, 70, 190, 30);
		contentPane.add(sellerNameValueLabel);
		
		JLabel currentPriceLabel = new JLabel("Current Price");
		currentPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPriceLabel.setBounds(265, 250, 99, 30);
		contentPane.add(currentPriceLabel);
		
		currentPriceValueLabel = new JLabel("New label");
		currentPriceValueLabel.setForeground(new Color(255, 255, 51));
		currentPriceValueLabel.setText(item.getCurrentPrice(item.getSessionID(), item.getID()) + "");
		currentPriceValueLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPriceValueLabel.setBounds(376, 250, 133, 30);
		contentPane.add(currentPriceValueLabel);

	}
	
	private void initSubmitPriceLabel() {
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitButton.setBounds(376, 290, 102, 33);
		submitButton.setVisible(false);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String price = newPriceField.getText();
				try {
					item.initializeItems();
					int newPrice = Integer.parseInt(price);
					if(newPrice <= item.getCurrentPrice(item.getSessionID(), item.getId())) {
						JOptionPane.showMessageDialog(new JFrame(), "The new price must be greater than the current price", "", JOptionPane.ERROR_MESSAGE);
					}
					else {
						System.out.println(member.isParticipated(item.getId()));
						if(member.isParticipated(item.getId())) {
							member.updatePrice(item.getSessionID(), item.getId(), newPrice);
							
						}
						else {
							member.participate(member.getId(), item.getID());
							member.updatePrice(item.getSessionID(), item.getId(), newPrice);
							itemController.addItem(item);
						}
						currentPriceValueLabel.setText(""+item.getCurrentPrice(item.getSessionID(), item.getID()));
						newPriceField.setText("");
						System.out.println(item.getCurrentPrice(item.getSessionID(), item.getId()));
						updateTable();
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Only integer number", "", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		contentPane.add(submitButton);
		newPriceField = new JTextField();
		newPriceField.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPriceField.setBounds(168, 291, 180, 32);
		newPriceField.setVisible(false);
		contentPane.add(newPriceField);
		newPriceField.setColumns(10);
		
		winnerLabel = new JLabel("");
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		winnerLabel.setBounds(66, 290, 443, 33);
		contentPane.add(winnerLabel);
		winnerLabel.setVisible(false);
		
	}
	
	
 		
	public void createTimer() throws ParseException {
		countDown = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
				LocalDateTime now = LocalDateTime.now();
				try {
					Date startTime = (Date) simpleDateFormat.parse(item.getSession().getSession_date() + " " +String.format("%02d:00:00", item.getSession().getStart_time()));
					Date endTime = (Date) simpleDateFormat.parse(item.getSession().getSession_date() + " " +String.format("%02d:00:00", item.getSession().getEnd_time()));
					Date timeNow = (Date) simpleDateFormat.parse(String.format("%02d-%02d-%04d %02d:%02d:%02d", now.getDayOfMonth(), now.getMonth().getValue(), now.getYear(), now.getHour(), now.getMinute(), now.getSecond()));
					if(endTime.getTime() - timeNow.getTime() <= 10000) countDownLabel.setForeground(Color.RED);
					if(timeNow.getTime() > endTime.getTime()) {
						countDown.stop();
						countDownLabel.setText("End Time!!!");
						submitButton.setVisible(false);
						newPriceField.setVisible(false);
						item.setServed(0);
						item.getSession().setReserved(0);
						if(table.getRowCount() == 0) {
							winnerLabel.setText("There is no winner");
						}
						else {
							String text = "Winner is: " + table.getModel().getValueAt(0, 1) + " " + table.getModel().getValueAt(0, 2);
							winnerLabel.setText(text);
						}
						winnerLabel.setVisible(true);
						return;
					}
					else if(timeNow.getTime() >= startTime.getTime()) {
						if(item.getSellerID() != member.getId()) {
							submitButton.setVisible(true);
							newPriceField.setVisible(true);
						}
						
						long seconds = (endTime.getTime() - timeNow.getTime())/1000;
						long hours = seconds/3600;
						long minutes = (seconds - hours*3600)/60;
						seconds = seconds - hours * 3600 - minutes * 60;
						countDownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
					}
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
		
	private ImageIcon getIcon(int w, int h, String src) {
		ImageIcon icon = new ImageIcon(PersonalDetailPanel.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
}
