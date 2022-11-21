package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Category;

public class SubmitItemPanel extends JPanel {
	private JPanel contentPanel;
	private JTextField nameInput;
	private JTextField detailsInput;
	private JTextField priceInput;
	private JButton icon;
	private JComboBox categoryComboBox;
	private DefaultComboBoxModel<Category> defaultComboBoxModel;
	private JButton submitButton;
	private String srcImage;
	private JComboBox startTimeInput;
	private JComboBox endTimeInput;
	private JComboBox year;
	private JComboBox month;
	private JComboBox date;
	
	
	public SubmitItemPanel() {
		setBackground(new Color(102, 204, 255));
		setBounds(152, 87, 800, 505);
		setLayout(null);
		srcImage = "";
		initLabels();
		initInputView();
	}
	
	private void initLabels() {
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameLabel.setBounds(284, 30, 129, 35);
		add(nameLabel);
		
		JLabel detailLabel = new JLabel("Detail");
		detailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		detailLabel.setBounds(284, 85, 129, 35);
		add(detailLabel);
		
		JLabel priceLabel = new JLabel("Starting Price");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		priceLabel.setBounds(284, 130, 129, 35);
		add(priceLabel);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		categoryLabel.setBounds(284, 180, 129, 35);
		add(categoryLabel);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		dateLabel.setBounds(284, 230, 129, 35);
		add(dateLabel);
		
		JLabel startTimeLabel = new JLabel("Start Time");
		startTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		startTimeLabel.setBounds(284, 280, 131, 35);
		add(startTimeLabel);
		
		JLabel endTimeLabel = new JLabel("End Time");
		endTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		endTimeLabel.setBounds(284, 330, 129, 35);
		add(endTimeLabel);
	}
	
	private void initInputView() {
		
		icon = new JButton("Add Image");
		icon.setFont(new Font("Tahoma", Font.BOLD, 16));
		icon.setBounds(30, 30, 212, 235);
		icon.setBorderPainted(false);
		icon.setBackground(Color.white);
		add(icon);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		nameInput.setBounds(440, 30, 320, 35);
		add(nameInput);
		
		detailsInput = new JTextField();
		detailsInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		detailsInput.setBounds(440, 80, 320, 35);
		add(detailsInput);
		
		
		priceInput = new JTextField("");
		priceInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		priceInput.setBounds(440, 130, 320, 35);
		add(priceInput);
		
		categoryComboBox = new JComboBox();
		categoryComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		defaultComboBoxModel = new DefaultComboBoxModel<>();
		categoryComboBox.setModel(defaultComboBoxModel);
		
		categoryComboBox.setBounds(440, 180, 118, 35);
		add(categoryComboBox);
		
		submitButton = new JButton("Submit");
		submitButton.setForeground(new Color(204, 0, 255));
		submitButton.setBorderPainted(false);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		submitButton.setBounds(265, 415, 220, 60);
		submitButton.setBackground(Color.WHITE);
		add(submitButton);
		
		year = new JComboBox();
		year.setFont(new Font("Tahoma", Font.PLAIN, 13));
		setListyear();
		year.setBounds(589, 230, 92, 35);
		year.setSelectedIndex(0);
		add(year);
		
		month = new JComboBox();
		month.setFont(new Font("Tahoma", Font.PLAIN, 13));
		setListmonth();
		month.setBounds(516, 230, 63, 35);
		month.setSelectedIndex(0);
		add(month);
		
		date = new JComboBox();
		date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		setListdate(31);
		date.setBounds(441, 230, 65, 35);
		date.setSelectedIndex(0);
		add(date);
		
		startTimeInput = new JComboBox();
		startTimeInput.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		startTimeInput.setSelectedIndex(0);
		startTimeInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		startTimeInput.setBounds(440, 280, 118, 35);
		add(startTimeInput);
		
		endTimeInput = new JComboBox();
		endTimeInput.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		endTimeInput.setSelectedIndex(0);
		endTimeInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		endTimeInput.setBounds(440, 330, 118, 35);
		add(endTimeInput);
		
	}
	
	public void reset() {
		nameInput.setText("");
		icon.setIcon(null);
		detailsInput.setText("");
		priceInput.setText("");
		startTimeInput.setSelectedIndex(0);
		endTimeInput.setSelectedIndex(0);
	}
	
	public void setListyear() {
		List<String> listyear = new ArrayList<>();
		for(int year = 2022; year <= 2023; year++) {
			listyear.add(year + "");
		}
		year.setModel(new DefaultComboBoxModel(listyear.toArray()));
	}
	
	
	public void setListmonth() {
		List<String> listMonth = new ArrayList<>();
		for(int month = 1; month <= 12; month++) {
			listMonth.add(month + "");
		}
		month.setModel(new DefaultComboBoxModel(listMonth.toArray()));
	}
	
	public void setListdate(int lengthMonth) {
		int indexSelected = date.getSelectedIndex();
		List<String> listDate = new ArrayList<>();
		for(int date = 1; date <= lengthMonth; date++) {
			listDate.add(date + "");
		}
		date.setModel(new DefaultComboBoxModel(listDate.toArray()));
	}
	
	
	
	public void addActionListener(ActionListener actionListener) {
		icon.addActionListener(actionListener);
		submitButton.addActionListener(actionListener);
	}

	public void addCategories(List<Category> category) {
		defaultComboBoxModel.addAll(category);
		categoryComboBox.setSelectedIndex(0);
	}
	
	public void setImageItem(String src) {
		srcImage = src;
		icon.setIcon(getIcon(icon.getWidth(), icon.getHeight(), srcImage));
	}
	
	public String getSrcImg() {
		return srcImage;
	}
	
	private ImageIcon getIcon(int w, int h, String src) {
		ImageIcon icon = new ImageIcon(src);
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
	
	
	
	public String[] getNewItem() {
		String[] newItem = new String[8];
		newItem[0] = nameInput.getText();
		newItem[1] = detailsInput.getText();
		newItem[2] = priceInput.getText();
		Category cate = (Category)categoryComboBox.getSelectedItem();
		newItem[3] = cate.getId() +"";
		newItem[4] = cate.getCat_Name();
		newItem[5] = (String)(date.getSelectedItem()) + "-" + (String)(month.getSelectedItem()) + "-" + (String)(year.getSelectedItem());
		newItem[6] = startTimeInput.getSelectedIndex() + "";
		newItem[7] = endTimeInput.getSelectedIndex() + "";
		return newItem;
	}
	
	
}
