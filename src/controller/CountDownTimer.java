package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.Timer;

import models.Item;
import models.Sessions;
import view.BidderView;

public class CountDownTimer implements ActionListener{
	private Item item;
	private Timer countDown;
	private int startTime;
	private int endTime;
	private int hours;
	private int minutes;
	private int seconds;
	
	public CountDownTimer(Item item) {
		Sessions sessions = item.getSession();
		
		
		createTimer();
		countDown.start();
	}
	
	
	public void createTimer() {
		countDown = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		seconds--;
		if(seconds == -1) {
			if(minutes == 0) {
				if(hours == 0) {
					countDown.stop();
					JButton button = (JButton)e.getSource();
					BidderView bidderView = (BidderView)button.getParent();
					
					return;
				}
				else {
					hours -= 1;
					minutes =59;
					seconds = 59;
				}
			}
			minutes--;
			seconds = 59;
		}
	}
}