package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import models.Member;
import models.SystemUser;
import view.LoginView;

public class LoginController {
	private LoginView loginView;
	private SystemUser client;
	private static boolean ok = false; 
	
	public LoginController() {
		loginView = new LoginView();
		client = new SystemUser();
		client.getData();
		loginView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				switch (ev) {
					case "Login": {
						client.getData();
						try {
							login();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
						}
						break;
					}
					case "Register":{
						register();
						loginView.dispose();
						break;
					}
					case "Reset Password":{
						resetPassword();
						break;
					}
				}
			}
			
		});
		
	}
	
	public void login() throws ParseException {
		int status = client.Login(loginView.getEmail(), loginView.getPassword());
		String message = "";
		switch (status) {
			case 0:{
				
//				 AdminController();
			}
			case 1:{
				new CustomerController(new Member(client));
				loginView.setVisible(false);
				break;
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
	
	
	public void register() {
		new RegisterController();
	}
	
	public void resetPassword() {
		new ResetPasswordController();
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		new LoginController();
//		//System.out.println(LocalTime.now());
//	}
	
	
	
	
}
