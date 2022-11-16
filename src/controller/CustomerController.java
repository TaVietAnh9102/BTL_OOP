package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Member;
import view.CustomerView;
import view.HomePanel;

public class CustomerController {
	private CustomerView customerView;
	private Member member;
	public CustomerController(Member member) {
		this.member = member;
		customerView = new CustomerView();
		new HomeController(customerView);
		customerView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				switch (ev) {
				case "Home": 
					new HomeController(customerView);
					//customerView.switchPanel(true, false, false);
					break;
				case "Personal Detail":
				//	customerView.switchPanel(false, true, false);
					break;
				case "Submit Item":
				//	customerView.switchPanel(false, false, true);
					break;
				default:
				}
			}
		});
	}
}
