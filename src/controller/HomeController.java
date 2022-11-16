package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import models.Category;
import models.Item;
import view.CustomerView;
import view.BidderView;
import view.HomePanel;
import view.ItemPanel;

public class HomeController {
	private CustomerView customerView;
	private HomePanel homePanel;
	private ActionListener itemListener;
	private ActionListener categoryListener;
	
	public HomeController(CustomerView customerView) {
		this.customerView = customerView;
		createItemListener();
		createCategoryListener();
		List<Item> lsItem = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			Item it = new Item(i, "Laptop Del 1123456789110Z" + i, "Laptop A" + i , null, 1000.0 + i, i, 1, 1, 2, 1, 1);
			it.setCatName(""+ i);
			lsItem.add(it);
		}
		for(int i = 1; i <= 10; i++) {
			categories.add(new Category(i, "" + i, "admin"));
		}
		homePanel = new HomePanel(itemListener, categoryListener);
		homePanel.addCategory(categories);
		homePanel.addItem(lsItem);
		homePanel.showTab("All");
		this.customerView.addPanel(homePanel);
		
		
	}
	
	private void createItemListener() {
		itemListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton bt = (JButton)e.getSource();
				ItemPanel pn = (ItemPanel) bt.getParent();
				if(e.getActionCommand().equals("Detail")) {
					customerView.setVisible(false);
					SessionController ss=  new SessionController();
				}
				else {
					
				}
			}
		};
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
	
	public void setVisisble(boolean ok) {
		customerView.setVisible(ok);
	}
	
}
