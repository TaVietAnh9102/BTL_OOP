import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import models.DBInterface;
import view.LoginView;

public class Auction {
	public static void main(String[] args) {
<<<<<<< HEAD
//		DBInterface dbInterface = DBInterface.getInstance();
//		Scanner scanner = new Scanner(System.in);
//		String table = scanner.next();
//		ArrayList<Object[]> list = dbInterface.select(table);
//		for(Object[] user : list) {
//           System.out.println(user[1]);
//        }
//		scanner.close();
//		new LoginView();
//		DBInterface dbInterface = DBInterface.getInstance();
//		Scanner scanner = new Scanner(System.in);
//		String table = scanner.next();
//		ArrayList<Object[]> list = dbInterface.select(table);
//		for(Object[] user : list) {
//           System.out.println(user[1]);
//        }
//		scanner.close();
		new LoginView();
=======
		// test DB
		DBInterface dbInterface = DBInterface.getInstance();
		String table = new Scanner(System.in).next();
		ArrayList<Object[]> list = dbInterface.select(table);
		for(Object[] user : list) {
           System.out.println(user[1]);
        }
		
>>>>>>> main
	}
}