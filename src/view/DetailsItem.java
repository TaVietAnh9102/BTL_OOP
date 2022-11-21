package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Item;

public class DetailsItem extends JDialog {

	private static Font FONT = new Font("Tamoha", Font.BOLD, 13);
	private final JPanel contentPanel = new JPanel();
	private Item item;
	
	public DetailsItem(Item item) {
		setTitle("Item Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetailsItem.class.getResource("/pic/icon_app.png")));
		this.item = item;
		setSize(537, 275);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel icon = new JLabel("Icon");
		icon.setBounds(30, 30, 166, 176);
		icon.setIcon(getIcon(icon.getWidth(), icon.getHeight(), item.getPicture() ));
		
		contentPanel.add(icon);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(FONT);
		nameLabel.setBounds(229, 30, 97, 35);
		contentPanel.add(nameLabel);
		
		JTextField nameValue = new JTextField(item.getName());
		nameValue.setBounds(336, 30, 165, 35);
		nameValue.setFont(FONT);
		nameValue.setEditable(false);
		contentPanel.add(nameValue);
		
		JLabel detailLabel = new JLabel("Detail");
		detailLabel.setBounds(229, 80, 97, 35);
		detailLabel.setFont(FONT);
		contentPanel.add(detailLabel);
		
		JTextField detailValue = new JTextField(item.getDetails());
		detailValue.setEditable(false);
		detailValue.setFont(FONT);
		detailValue.setBounds(336, 80, 165, 35);
		contentPanel.add(detailValue);
		
		JLabel priceLabel = new JLabel("Starting Price");
		priceLabel.setBounds(229, 130, 97, 35);
		priceLabel.setFont(FONT);
		contentPanel.add(priceLabel);
		
		JTextField startingPrice = new JTextField(item.getPrice() +"");
		startingPrice.setBounds(336, 130, 165, 35);
		startingPrice.setFont(FONT);
		startingPrice.setEditable(false);
		contentPanel.add(startingPrice);
		
		JLabel sellerLabel = new JLabel("Seller");
		sellerLabel.setBounds(229, 180, 97, 35);
		sellerLabel.setFont(FONT);
		contentPanel.add(sellerLabel);
		
		JTextField sellerNameValue = new JTextField(item.getSellerName());
		sellerNameValue.setBounds(336, 180, 165, 35);
		sellerNameValue.setFont(FONT);
		detailValue.setEditable(false);
		contentPanel.add(sellerNameValue);
	}
	
	private ImageIcon getIcon(int w, int h, String src) {
		ImageIcon icon = new ImageIcon(PersonalDetailPanel.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
}
