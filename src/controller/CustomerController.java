package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Member;
import view.CustomerView;

public class CustomerController {
	private CustomerView customerView;
	private Member member;
	public CustomerController(Member member) {
		this.member = member;
		customerView = new CustomerView();
		customerView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				switch (ev) {
				case "Home": 
					customerView.switchPanel(true, false, false);
					break;
				case "Personal Detail":
					customerView.switchPanel(false, true, false);
					break;
				case "Submit Item":
					customerView.switchPanel(false, false, true);
					break;
				default:
				}
			}
		});
	}
}
