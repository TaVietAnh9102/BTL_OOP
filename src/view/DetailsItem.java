package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Item;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class DetailsItem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Item item;
	
	public DetailsItem() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel icon = new JLabel("New label");
		icon.setBounds(10, 10, 121, 145);
		contentPanel.add(icon);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(141, 30, 73, 26);
		contentPanel.add(nameLabel);
		
		JLabel nameValue = new JLabel("New label");
		nameValue.setBounds(250, 30, 165, 26);
		nameValue.setText(item.getItem_name());
		contentPanel.add(nameValue);
		
		JLabel detailLabel = new JLabel("Detail");
		detailLabel.setBounds(141, 76, 73, 26);
		contentPanel.add(detailLabel);
		
		JTextArea detailValue = new JTextArea();
		detailValue.setBounds(250, 70, 165, 40);
		detailValue.setText(item.getDetails());
		contentPanel.add(detailValue);
		
		JLabel priceLabel = new JLabel("Starting Price");
		priceLabel.setBounds(141, 124, 73, 26);
		contentPanel.add(priceLabel);
		
		JLabel startingPrice = new JLabel(item.getPrice() +"");
		startingPrice.setBounds(250, 124, 165, 26);
		contentPanel.add(startingPrice);
		
		JLabel sellerLabel = new JLabel("Seller");
		sellerLabel.setBounds(141, 170, 73, 26);
		contentPanel.add(sellerLabel);
		
		JLabel sellerNameValue = new JLabel("New label");
		sellerNameValue.setBounds(250, 170, 165, 26);
		contentPanel.add(sellerNameValue);
	}
}
