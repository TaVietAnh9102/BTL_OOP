package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Category;
import models.Item;
import models.Member;
import models.Sessions;
import view.CustomerView;
import view.SubmitItemPanel;

public class SubmitItemController {
	private SubmitItemPanel submitItemPanel;
	private ItemController itemController;
	private ActionListener actionListener;
	private Member member;
	
	public SubmitItemController( CustomerView customerView, Member member, Category catMNG, ItemController itemController) {
		this.member = member;
		this.itemController = itemController;
		createListener();
		submitItemPanel = new SubmitItemPanel();
		submitItemPanel.setVisible(false);
		submitItemPanel.addCategories(catMNG.getCategoryList());
		submitItemPanel.addActionListener(actionListener);
		customerView.addPanel(submitItemPanel);
	}
	
	private void createListener() {
		actionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JButton bt = (JButton) e.getSource();
				SubmitItemPanel pn = (SubmitItemPanel)bt.getParent();
				
				
//				String[] newItem = new String[8];
//				newItem[0] = nameInput.getText();
//				newItem[1] = detailsInput.getText();
//				newItem[2] = priceInput.getText();
//				Category cate = (Category)categoryComboBox.getSelectedItem();
//				newItem[3] = cate.getId() +"";
//				newItem[4] = cate.getCat_Name();
//				newItem[5] = (date.getSelectedIndex() + 1) + "-" + (month.getSelectedIndex() + 1) + "-" + (year.getSelectedIndex() + 2021);
//				newItem[6] = startTimeInput.getSelectedIndex() + "";
//				newItem[7] = endTimeInput.getSelectedIndex() + "";
				
//				int startTime, int endTime, String date, int reserved
				String src = e.getActionCommand();
				System.out.println(e.getActionCommand());
				if(src.equals("Submit")) {
					String[] newItem = pn.getNewItem();
//					System.out.println(newItem[5]);
//					member.submitSessions(Integer.parseInt(newItem[6]), Integer.parseInt(newItem[7]), newItem[5], 1);
//					Sessions sessions = new Sessions();
//					sessions.getData();
//					sessions.getSessionList();
//					List<Sessions> ls = sessions.getSessionList();
//					sessions = ls.get(ls.size()-1);
					member.submitItem(member.getId(), newItem[0], newItem[1], "",Integer.parseInt(newItem[2]), Integer.parseInt(newItem[3]), newItem[5],Integer.parseInt(newItem[6]), Integer.parseInt(newItem[7]) );
					Item item = new Item();
					item.getData();
					item.initializeItems();
					List<Item> lsItem = item.getItemList();
					item.initializeItems();
					lsItem = item.getItemList();
					item = lsItem.get(lsItem.size() - 1);
					itemController.addNewItem(item);	
					pn.reset();
					JOptionPane.showMessageDialog(new JFrame(), "Item is added", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JFileChooser jFileChooser = new JFileChooser();
					int op = jFileChooser.showOpenDialog(pn);
					if(op == JFileChooser.FILES_ONLY){
						File file = jFileChooser.getSelectedFile();
						copyImage(file);
						//System.out.println("/pic/" + file.getName());
						pn.setImageItem(file.getPath());
					}
					
					//System.out.println(file.getPath());
				}
			}
		};
	}

	public void showHomeView(boolean submitItem) {
		submitItemPanel.setVisible(submitItem);
	}
	
	private void copyImage(File src){
		URL imageURL;
        BufferedImage bi;
		try {
			imageURL = new URL("file:///" + src.getPath());
			bi = ImageIO.read(imageURL);
			File des = new File("D:\\Program File\\Git\\BTL_OOP\\src\\pic\\"+  src.getName());
			des.createNewFile();
			ImageIO.write(bi, "jpg", des);
		}catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
}
