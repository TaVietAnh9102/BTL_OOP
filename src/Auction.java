import java.util.ArrayList;
import java.util.Scanner;

import models.DBInterface;

public class Auction {
	public static void main(String[] args) {
		// test DB
		DBInterface dbInterface = DBInterface.getInstance();
		String table = new Scanner(System.in).next();
		ArrayList<Object[]> list = dbInterface.select(table);
		for(Object[] user : list) {
           System.out.println(user[1]);
        }
		
	}
}