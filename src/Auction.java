import java.util.ArrayList;
import java.util.Scanner;

import models.DBInterface;
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
//           System.out.println(user[8]);
//
//           
//        }
		SystemUser m = new SystemUser();
		m.Login("admin@gmail.com", "admin");
		
	}
}