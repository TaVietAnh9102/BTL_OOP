package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class ItemPanel extends JPanel {
	
//	private Item
	
	public ItemPanel() {
		setBackground(new Color(102, 204, 204));
		setLayout(null);
		this.setPreferredSize(new Dimension(183, 305));
		
		JLabel imageItem = new JLabel("New label");
		imageItem.setBounds(10, 10, 160, 169);
		add(imageItem);
		
		JLabel itemName = new JLabel("Name");
		itemName.setBounds(10, 196, 52, 26);
		add(itemName);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(46, 254, 85, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(10, 221, 45, 13);
		add(lblNewLabel);

	}
}
