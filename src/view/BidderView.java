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
	
	private JTable table;
	private Timer countDown;
	private Date startTime;
	private Date endTime;
	private long hours;
	private long minutes;
	private long seconds;
	private long timeNow;
	private int option;
	private JScrollPane scrollPane;
	
	
	public BidderView(Item item, Member member) {
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
		
        ArrayList<Object[]> participantsBidder =  item.getParticipatedBidders(item.getSession_ID(), item.getId());
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
		
        ArrayList<Object[]> participantsBidder =  item.getParticipatedBidders(item.getSession_ID(), item.getId());
        for(Object[] infor : participantsBidder) {
        	model.addRow(new Object[]{infor[0], infor[1], infor[2], infor[4]});
        }
        scrollPane.setViewportView(table);
	}
	
	public void createCountDownLabel() {
		if(item.getServed() == 0) {
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
		
		JLabel itemNameValue = new JLabel(item.getItem_name());
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
		currentPriceValueLabel.setText(item.getCurrentPrice(item.getSession_ID(), item.getID()) + "");
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
					if(newPrice <= item.getCurrentPrice(item.getSession_ID(), item.getId())) {
						JOptionPane.showMessageDialog(new JFrame(), "The new price must be greater than the current price", "", JOptionPane.ERROR_MESSAGE);
					}
					else {
						System.out.println(member.isParticipated(item.getId()));
						if(member.isParticipated(item.getId())) {
							member.updatePrice(item.getSession_ID(), item.getId(), newPrice);
						
						}
						else {
							member.participate(item.getSession_ID(), item.getID(), newPrice);
							//member.SubmitBid(member.getId(), item.getSession_ID(), item.getId(), newPrice);
							
						}
						currentPriceValueLabel.setText(""+item.getCurrentPrice(item.getSession_ID(), item.getID()));
						newPriceField.setText("");
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
		
		
	}
	
	
 		
	public void createTimer() throws ParseException {
	//	LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateNow = LocalDateTime.now();
		SimpleDateFormat simleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date startTime = (Date) simleDateFormat.parse(item.getSession().getSession_date() + " " +String.format("%02d:00:00", item.getSession().getStart_time()));
		Date endTime = (Date) simleDateFormat.parse(item.getSession().getSession_date() + " " +String.format("%02d:00:00", item.getSession().getEnd_time()));
		Date dN = (Date) simleDateFormat.parse(String.format("%02d-%02d-%04d %02d:%02d:%02d", dateNow.getDayOfMonth(), dateNow.getMonth().getValue(), dateNow.getYear(), dateNow.getHour(), dateNow.getMinute(), dateNow.getSecond()));
		long diff = (startTime.getTime() - dN.getTime())/1000;
		if(diff > 0) {
			seconds = (endTime.getTime() - startTime.getTime())/1000 + diff;
			option = 0;
		}
		else {
			option = 1;
			seconds = Math.max(0, (endTime.getTime() - dN.getTime())/1000);
		}
		hours = seconds/3600;
		minutes = (seconds - hours*3600)/60;
		seconds -= hours * 3600 + minutes * 60;
		
		countDown = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				if(hours == 0 && minutes == 0 && seconds <= 10) countDownLabel.setForeground(Color.RED);
				if(seconds == -1) {
					if(minutes == 0) {
						if(hours == 0) {
							countDown.stop();
							countDownLabel.setText("End Time!!!");
							submitButton.setVisible(false);
							newPriceField.setVisible(false);
							item.setServed(0);;
							item.getSession().setReserved(0);
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
				if(hours*3600 + minutes * 60 + seconds <= (endTime.getTime() - startTime.getTime())/1000) {
					countDownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
					if(member.getId() != item.getSeller_ID()) {
						submitButton.setVisible(true);
						newPriceField.setVisible(true);
					}
				}
				
//				System.out.println(startTime/3600 + " " + endTime/3600);
				System.out.println(hours + ":" + minutes +":" +seconds);
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
