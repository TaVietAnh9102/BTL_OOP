import java.util.ArrayList;
import java.util.Scanner;

import models.DBInterface;
import models.Item;
import models.Member;
import models.SystemUser;

public class Auction {
	public static void main(String[] args) {
		// test DB
//		DBInterface dbInterface = DBInterface.getInstance();
//		String table = new Scanner(System.in).next();
//		ArrayList<Object[]> list = dbInterface.select(table);
//		for(Object[] user : list) {
//           System.out.println(Integer.parseInt(user[0].toString()));
//           System.out.println(user[1]);
//           System.out.println(user[2]);
//           System.out.println(user[3]);
//           System.out.println(user[4]);
//           System.out.println(user[5]);
//           System.out.println(user[6]);
//           System.out.println(user[7]);
//
//           
//        }
//		
//		Member m = new Member();
//		m.getData();
//		SystemUser m = new SystemUser();
//		m.Login("b@gmail.com", "123456");
//		m.resetPassword("c@gmail.com");
		//System.out.println(m.getParticipatedSessions(m.getId()));
		
		
		Item m = new Item();
		m.initializeItems();
		ArrayList<Item> li= m.getItemList();
		for (Item it : li) {
			System.out.println(it.getItem_name());
		}
		
	}
}