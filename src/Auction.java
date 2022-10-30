import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import models.DBInterface;

public class Auction {
	public static void main(String[] args) {
		DBInterface dbInterface = DBInterface.getInstance();
		Scanner scanner = new Scanner(System.in);
		String table = scanner.next();
		ArrayList<Object[]> list = dbInterface.select(table);
		for(Object[] user : list) {
           System.out.println(user[1]);
        }
		scanner.close();
	}
}