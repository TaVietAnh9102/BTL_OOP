package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excpt.EmailException;
import excpt.PasswordException;
import models.SystemUser;
import view.LoginView;

public class LoginController {
	private LoginView loginView;
	private SystemUser systemUser;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.loginView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		systemUser = new SystemUser();
	}
	
	public void login() {
		try {
			systemUser.login(loginView.getEmail(), loginView.getName());
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
