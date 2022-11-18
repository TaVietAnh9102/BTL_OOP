package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import models.Member;
import view.CustomerView;
import view.PersonalDetailPanel;

public class PersonalDetailController {
	private Member member;
	private PersonalDetailPanel personalDetailPanel;
	private CustomerView customerView;
	private ActionListener actionListener;
	public PersonalDetailController(CustomerView customerView, Member member) throws ParseException {
		this.member = member;
		createActionListener();
		personalDetailPanel = new PersonalDetailPanel(member);
		personalDetailPanel.setVisible(false);
		customerView.addPanel(personalDetailPanel);
	}

	private void createActionListener() {
		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
	}
	
	public void showHomeView(boolean ok) {
		personalDetailPanel.setVisible(ok);
	}
	
	
}
