package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import models.Category;
import models.Item;
import models.Member;
import view.CustomerView;
//import view.BidderView;
import view.ItemsTablePanel;
import view.ItemPanel;

public class ItemTableController {
	private ItemsTablePanel homePanel;
	private ActionListener categoryListener;
	public ItemTableController(CustomerView customerView, Category catMNG) {
		homePanel = new ItemsTablePanel();
		createCategoryListener();
		homePanel.setCategoryListener(categoryListener);
		homePanel.addCategory(new Category(-1, "All"));
		homePanel.addCategory(catMNG.getCategoryList());
		homePanel.showTab("All");
		homePanel.setVisible(false);
		customerView.addPanel(homePanel);
	}
	
	public void setItemListener(ActionListener itemListener) {
		homePanel.setItemListener(itemListener);
	}
	
	public void addItems(List<Item> itemsList) {
		homePanel.addItem(itemsList);
	}
	
	public void addItem(Item item) {
		homePanel.addItem(item);
	}
	
	private void createCategoryListener() {
		categoryListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(e.getActionCommand());
				//homePanel.setVisible(false);
				homePanel.showTab(e.getActionCommand());
				//homePanel.setVisible(true);
			}
		};
	}
	
	public void showHomeView(boolean ok) {
		homePanel.setVisible(ok);
	}
	
	
	
	
	
}
