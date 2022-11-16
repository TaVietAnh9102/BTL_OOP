package models;

import java.sql.*;
import java.util.ArrayList;

public class DBInterface {
	private static DBInterface instance;
	
    private String dbName = "auction";	// create database name auction
    private String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
    private String dbUsername = "root";
    private String dbPassword = "Tranminhchau2";	// your sql password
    
    private Connection connection = null;
    private String query = null;
    private ArrayList<Object[]> resultList = null;
    
    // Contructor
    private DBInterface() {
    	// remember add .jar file
        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            System.out.println("Connected (DBInterface)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Getters 
    public static DBInterface getInstance() {
        //Singleton Class
        if (instance == null) {
            instance = new DBInterface();
        }
        return instance;
    }
    
    // Methods
    public void insert(String table, String attributes, String values) {
        query = "INSERT INTO " + table + "(" + attributes + ") VALUES(" + values + ")";

        //for checking
        System.out.println(query + "(43 - DBInterface)");

        executeQuery(query, false);
    }

    public void delete(String table, int objectId) {
        query = "DELETE FROM " + table + " WHERE ID = " + objectId;

        //for checking
        System.out.println(query + "(52 - DBInterface)");

        executeQuery(query, false);
    }

    public void update(String table, String options, int objectId, String whereStatement) {
        query = "UPDATE " + table + " SET " + options + " WHERE ID = " + objectId;

        if(!whereStatement.equals("")) {
            query += " AND " + whereStatement;
        }

        //for checking
        System.out.println(query + "(65 - DBInterface)");

        executeQuery(query, false);
    }
    
    public void update(String table, String attr, String values , String Where){
        query = "Update " + table + " SET " + attr + " = " + values + " Where " + Where;
        
        //for checking
        System.out.println(query + "(74 - DBInterface)");
        
        executeQuery(query,false);
    }

    public ArrayList<Object[]> select(String table) {
    	// select *
        query = prepareQuery(table, "*", "");

        //for checking
        System.out.println(query + "(84 - DBInterface)");

        executeQuery(query, true);

        return resultList;
    }

    public ArrayList<Object[]> select(String table, String options) {
        query = prepareQuery(table, options, "");

        //for checking
        System.out.println(query + "(95 - DBInterface)");

        executeQuery(query, true);

        return resultList;
    }

    public ArrayList<Object[]> select(String table, String options, String whereStatement) {
    	// select (have condition)
        query = prepareQuery(table, options, whereStatement);

        //for checking
        System.out.println(query + "(107 - DBInterface)");

        executeQuery(query, true);

        return resultList;
    }
    
//    public ArrayList<Object[]> select(String table, String options ,int userID ) {
//    	// use for notifiction and user_notification in SystemUser
//        table += " INNER JOIN User_notification on Notification.ID = User_notification.notification_ID WHERE User_notification.User_ID = " + userID;
//        query = prepareQuery(table,options,"");
//        executeQuery(query, true);
//        return resultList;
//    }

    //Helper Methods
    private String prepareQuery(String table,String options, String whereStatement) {
    	
    	// create statement: select () from (table) where ... 
    	
        query = "SELECT " + options + " FROM " + table;

        if (!whereStatement.equals("")) {
            query += " WHERE " + whereStatement;
        }

        return query;
    }
    
    		// StackOverFlow
    private void executeQuery(String query, Boolean dataRetireval) {
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(query);
    		ResultSet results = null;
    		
          	if (dataRetireval) {
	            //only for select statements
	          	preparedStatement.executeQuery();
	            results = preparedStatement.getResultSet();
	
	            // extracting objectArrays from ResultSet
	            extractResults(results);
          	} else {
          		// for insert, update, delete
	            preparedStatement.executeUpdate();
	        }
          	// Clean up
          	results.close();
            preparedStatement.close();
          	
    	} catch (SQLException ex){
    		ex.printStackTrace();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
    }

    private void extractResults(ResultSet resultSet) throws SQLException{
    	// read ResultSet
    	resultList = new ArrayList<>();
    	while(resultSet.next()) {
    		int columns = resultSet.getMetaData().getColumnCount();
    		Object[] array = new Object[columns];
    		for(int i = 0; i < columns; i++){
    			array[i] = resultSet.getObject(i+1);
    		}
    		resultList.add(array);
    	}
    }
}
