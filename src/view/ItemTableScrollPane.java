package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ItemTableScrollPane extends JScrollPane {
	private JPanel itemTable;
	
	public ItemTableScrollPane() {
		itemTable = new JPanel();
		itemTable.setBorder(new EmptyBorder(0, 0, 0, 0));
		itemTable.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
		setViewportView(itemTable);
		setBackground(Color.white);
	}
	
	public void addItemPanel(ItemPanel itemPanel) {
		itemTable.add(itemPanel);
	}
	
	
}
