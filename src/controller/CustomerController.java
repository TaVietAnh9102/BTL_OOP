package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import models.Category;
import models.Member;
import view.CustomerView;

public class CustomerController {
	private CustomerView customerView;
	private Member member;
	private ItemController itemController;
	private ItemTableController homeController;
	private ItemTableController participatedController;
	private ItemTableController soldItemController;
	private PersonalDetailController personalDetailController;
	private SubmitItemController submitItemController;

	public CustomerController(Member member) throws ParseException {
		this.member = member;
		Category catMNG = new Category();
		catMNG.initializeCategories();
		customerView = new CustomerView();
		personalDetailController = new PersonalDetailController(customerView, member);
		homeController = new ItemTableController(customerView, catMNG);
		participatedController = new ItemTableController(customerView, catMNG);
		soldItemController = new ItemTableController(customerView, catMNG);
		itemController = new ItemController(homeController, participatedController, soldItemController, member);
		submitItemController = new SubmitItemController(customerView, member, catMNG, itemController);
		switchPage(true, false, false, false, false);

		customerView.addListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ev = e.getActionCommand();
				System.out.println(ev);
				switch (ev) {
				case "Home":
					switchPage(true, false, false, false, false);
					break;
				case "Participated":
					switchPage(false, true, false, false, false);
					break;
				case "Sold product":
					switchPage(false, false, true, false, false);
					break;
				case "Submit Item":
					switchPage(false, false, false, true, false);
					break;
				case "Personal Detail":
					switchPage(false, false, false, false, true);
					break;
				case "LogOut":
					customerView.setVisible(false);
					new LoginController();
					break;
				default:
				}
			}
		});
	}

	private void switchPage(boolean home, boolean participated, boolean soldItem, boolean submitItem,
			boolean personalDetail) {
		homeController.showHomeView(home);
		participatedController.showHomeView(participated);
		soldItemController.showHomeView(soldItem);
		submitItemController.showHomeView(submitItem);
		personalDetailController.showHomeView(personalDetail);
	}

}
