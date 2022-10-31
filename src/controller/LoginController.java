package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import models.SystemUser;
import view.LoginView;
import view.SignUpView;

public class LoginController {
	private LoginView loginView;
	private SystemUser systemUser;
	private static boolean ok = false; 
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		systemUser = new SystemUser();
		this.loginView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				switch (ev) {
				case "Login": {
					login();
				}
				case "Sign Up":{
					signUp();
				}
				case "Reset Password":{
					
				}
				default:
					return;
					//throw new IllegalArgumentException("Unexpected value: " + ev);
				}
			}
		});
		
	}
	
	public void login() {
		int status = systemUser.Login(loginView.getEmail(), loginView.getPassword());
		String message = "";
		switch (status) {
			case 0:{
				
//				new AdminController();
			}
			case 1:{
//				new CustomerController();
			}
			case -4:{
				message = "Email don't exist";
				break;
			}
			case -2: {
				message = "Password is wrong!";
				break;
			}
			case -1: {
				message = "Email is wrong!";
				break;
			}
			
		}
		loginView.setMessage(message);
	}
	
	
	public void signUp() {
		SignUpView signUpView = new SignUpView();
		signUpView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SystemUser.isNewSystemUser(signUpView.getFirstName(), signUpView.getLastName(), signUpView.getEmail(), signUpView.getPassword(), signUpView.getGender(), signUpView.getBirthDay(), signUpView.getPhone())) {
					
				}
			}
		});
		
	}
	
	
	
	
	
}
