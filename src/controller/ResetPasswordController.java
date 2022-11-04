package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Member;
import view.ResetPasswordView;

public class ResetPasswordController {
	private ResetPasswordView resetPasswordView;
	private Member user;
	public ResetPasswordController() {
		user = new Member();
		resetPasswordView = new ResetPasswordView();
		resetPasswordView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!user.canRegister(resetPasswordView.getEmail())) {
					resetPasswordView.updateStatus("Email is not exist!");
				}
				else {
					resetPasswordView.setVisible(false);
				}
			}
		});
	}
}
