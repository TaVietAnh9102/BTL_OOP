package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.YearMonth;
import models.Member;
import view.RegisterView;

public class RegisterController {
	private RegisterView registerView;
	private Member client;

	public RegisterController() {
		registerView = new RegisterView();
		client = new Member();
		client.getData();
		client.GetEmails();
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
		YearMonth yearMonth = YearMonth.of(Integer.parseInt(registerView.getBirthYear()),
				Integer.parseInt(registerView.getBirthMonth()));
		registerView.setListBirthDate(yearMonth.lengthOfMonth());
	}

	private void register() {
		if (registerView.getFirstName().equals("") || registerView.getLastName().equals("")
				|| registerView.getEmail().equals("") || registerView.getPassword().equals("")
				|| registerView.getPhone().equals("") || !client.canRegister(registerView.getEmail())) { // ||
																		// !newUser.existedEmail(registerView.getEmail())
			registerView.setVisibleMessage(true);

		} else {
			// registerView.setVisibleMessage(false);
			client.Register(registerView.getFirstName(), registerView.getLastName(), registerView.getEmail(),
					registerView.getPassword(), registerView.getPhone(), registerView.getBirthDate() + "/"
							+ registerView.getBirthMonth() + "/" + registerView.getBirthYear(),
					registerView.getGender());
			registerView.setVisible(false);
		}

	}

}
