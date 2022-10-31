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

import view.SignUpView;

public class SignUpController {
	private SignUpView signUpView;
//	private Member newUser;
	public SignUpController() {
		signUpView = new SignUpView();
		signUpView.addListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		signUpView.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateDays();
			}
		});
	}
	
	private void updateDays() {
		YearMonth yearMonth =  YearMonth.of(Integer.parseInt(signUpView.getYear()), Integer.parseInt(signUpView.getMonth()));
		signUpView.setListDays(yearMonth.lengthOfMonth());
	}
	
	private void signUp() {
		
	}
	
	public static void main(String[] args) {
		new SignUpController();
	}
	
	
}
