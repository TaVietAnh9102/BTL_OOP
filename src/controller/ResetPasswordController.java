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
		user.getData();
		resetPasswordView = new ResetPasswordView();
		resetPasswordView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.canRegister(resetPasswordView.getEmail().trim())) {
					resetPasswordView.updateStatus("Email is not exist!");
				}
				else {
					resetPasswordView.updateStatus("Your password is 123456");
					user.resetPassword(resetPasswordView.getEmail());
				}
			}
		});
	}
}
