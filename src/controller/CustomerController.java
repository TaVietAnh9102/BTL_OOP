package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import models.Category;
import models.Item;
import models.Member;
import view.CustomerView;
import view.ItemsTablePanel;

public class CustomerController {
	private CustomerView customerView;
	private Member member;
	private ItemController itemController;
	
	private ItemTableController homeController;
	private ItemTableController participatedController;
	private ItemTableController soldItemController;
	private PersonalDetailController personalDetailController;
	
	private int current = 1;
	
	public CustomerController(Member member) throws ParseException {
		this.member = member;
		
		customerView = new CustomerView();
		personalDetailController = new PersonalDetailController(customerView, member);
		homeController =  new ItemTableController(customerView);
		participatedController = new ItemTableController( customerView);
		soldItemController = new ItemTableController(customerView);
		itemController = new ItemController(homeController, participatedController, soldItemController, member);
		
		switchPage(true, false, false, false, false);
		
		customerView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				System.out.println(ev);
				switch (ev) {
				case "Home": 
					switchPage(true, false, false, false, false);
					break;
				case "Participated":
					switchPage(false, true, false, false, false);
					break;
				case "Sold product":
					switchPage(false, false, true, false, false);
					break;
				case "Personal Detail":
					switchPage(false, false, false, true, false);
					break;
				case "Submit Item":
					switchPage(false, false, false, false, true);
					break;
				case "LogOut":
					customerView.setVisible(false);
					new LoginController();
					break;
				default:
				}
			}
		});
	}
	
	private void switchPage(boolean home, boolean participated, boolean soldItem, boolean personalDetail, boolean b) {
		homeController.showHomeView(home);
		participatedController.showHomeView(participated);
		soldItemController.showHomeView(soldItem);
		personalDetailController.showHomeView(personalDetail);
	}
	
}
