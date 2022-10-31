package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Member;
import view.RegisterView;

public class RegisterController {
	private RegisterView registerView;
	private Member newUser;
	
	public RegisterController() {
		registerView = new RegisterView();
		newUser = new Member();
		registerView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		
		registerView.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateDays();
			}
		});
	}
	
	
	private void updateDays() {
		YearMonth yearMonth =  YearMonth.of(Integer.parseInt(registerView.getBirthYear()), Integer.parseInt(registerView.getBirthMonth()));
		registerView.setListBirthDate(yearMonth.lengthOfMonth());
	}
	
	
	private void register() {
		if(registerView.getFirstName().equals("") || registerView.getLastName().equals("") || registerView.getEmail().equals("")||
				registerView.getPassword().equals("") || registerView.getPhone().equals("") || newUser.canRegister(registerView.getEmail())) {
			registerView.setVisibleMessage(true);
		}
		else {
			registerView.setVisibleMessage(false);
			newUser.Register(registerView.getFirstName(), registerView.getLastName(), registerView.getEmail(), registerView.getPassword(), registerView.getPhone(), registerView.getBirthDate() + "/" 
					+ registerView.getBirthMonth() + registerView.getBirthMonth(), registerView.getGender());
			registerView.setVisible(false);
			
		}
	}
	
	public static void main(String[] args) {
		new RegisterController();
	}
	
	
}
