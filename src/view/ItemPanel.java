package view;

import javax.swing.JPanel;

import models.Item;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Component;

public class ItemPanel extends JPanel {
	
	private Item item;
	private ActionListener itemListener;
	
	public ItemPanel(Item item, ActionListener itemListener) {
		this.item = item;
		this.itemListener = itemListener;
		setBackground(new Color(102, 204, 255));
		setLayout(null);
		this.setPreferredSize(new Dimension(186, 305));
		
		
		JLabel imageItem = new JLabel();
		imageItem.setIcon(getIcon("/pic/dell_latitude_3520.jpg"));
		imageItem.setBounds(10, 10, 166, 169);
		add(imageItem);
		
		JLabel cost = new JLabel(item.getPrice() + "");
		cost.setForeground(new Color(255, 255, 51));
		cost.setHorizontalAlignment(SwingConstants.CENTER);
		cost.setFont(new Font("Tahoma", Font.BOLD, 13));
		cost.setBounds(96, 234, 80, 23);
		add(cost);
		
		JTextArea itemName = new JTextArea();
		itemName.setAlignmentX(Component.CENTER_ALIGNMENT);
		itemName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		itemName.setEditable(false);
		itemName.setRows(3);
		itemName.setColumns(20);
		itemName.setLineWrap(true);
		itemName.setText(item.getItem_name());
		itemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		itemName.setBackground(new Color(102, 204, 255));
		itemName.setForeground(Color.BLACK);
		itemName.setBounds(10, 189, 160, 35);
		add(itemName);
		
		JButton detailButton = new JButton("Detail");
		detailButton.setBounds(10, 274, 80, 21);
		detailButton.addActionListener(itemListener);
		add(detailButton);
		
	}
	
	public void setItemBidding() {
		JButton joinButton = new JButton("Join");
		joinButton.setBounds(96, 274, 80, 21);
		joinButton.addActionListener(itemListener);
		add(joinButton);
		
		JLabel currentPanel = new JLabel("Current Price");
		currentPanel.setFont(new Font("Tahoma", Font.BOLD, 12));
		currentPanel.setForeground(Color.BLACK);
		currentPanel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPanel.setBounds(10, 234, 81, 23);
		add(currentPanel);
	}
	
	public void setItemBidded() {
		JLabel currentPanel = new JLabel("Price");
		currentPanel.setFont(new Font("Tahoma", Font.BOLD, 12));
		currentPanel.setForeground(Color.BLACK);
		currentPanel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPanel.setBounds(10, 234, 81, 23);
		add(currentPanel);
	}
	
	public void showDesciption() {
		JDialog description = new JDialog((JFrame)this.getTopLevelAncestor());
		description.setSize(400, 400);
		description.setLocationRelativeTo(null);
		description.setTitle(item.getDetails());
		description.setVisible(true);
	}
	
	private ImageIcon getIcon(String src) {
		ImageIcon icon = new ImageIcon(LoginView.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(166, 169, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
}
