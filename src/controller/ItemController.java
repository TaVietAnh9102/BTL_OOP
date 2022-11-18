package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.mysql.cj.Session;

import models.Item;
import models.Member;
import view.BidderView;
import view.ItemPanel;

public class ItemController {
	private Member member;
	private ActionListener itemListener;
	private ItemTableController homeController;
	private ItemTableController participatedController;
	private ItemTableController SoldItemController;
	
	public ItemController(ItemTableController homeController,ItemTableController participatedController, ItemTableController biddingController, Member member) {
		this.member = member;
		createItemListener();
		
		
		this.homeController = homeController;
		this.homeController.setItemListener(itemListener);
		this.homeController.addItems(member.viewProducts());
		//viewProducts
		this.participatedController = participatedController;
		this.participatedController.setItemListener(itemListener);
		
		this.SoldItemController = biddingController;
		this.SoldItemController.setItemListener(itemListener);
		this.SoldItemController.addItems(member.viewSellerItems(member.getId()));
		//viewSellerItems
	}
	
	private void createItemListener() {
		itemListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				String src = e.getActionCommand();
				JButton bt = (JButton) e.getSource();
				ItemPanel pn = (ItemPanel) bt.getParent();
				
				if(src.equals("Detail")) {
					pn.showDesciption();
				}
				else {
					BidderView bd =	new BidderView(pn.getItem(), member);
					bd.setVisible(true);
				}
			}
		};
	}
	
	
	private void addListener() {
		homeController.setItemListener(itemListener);
	}
	
	
	
	
}
