import java.sql.*;

public class Auction {
	public static void main(String[] args) {
		Connection connection = null;
	    String dbName = "auction";
	    String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	    String dbUsername = "root";
	    String dbPassword = "2112";

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.print("Database Open Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}