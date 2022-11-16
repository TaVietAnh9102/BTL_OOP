package models;

import java.util.ArrayList;

// for querry from database
public abstract class DataManager {

	// Getters
	protected abstract String getAttributes(); 	// return the attributes to be inserted in a table
	
	protected abstract String getValues();    	// return the values to be inserted in a table
	
	protected abstract String getOptions();   	// return the options to be used in select query

	protected abstract String getWhere();     	// return the Where statement to be used in select query

	public abstract int getId();           		// return the id of the object

	protected abstract Object get();          	// handle the get requests and inside each variation of get
	
	//Methods
    public void add() {
        DBInterface dbInterface = DBInterface.getInstance();
        String table = this.getClass().getSimpleName(); 	// get name of class: Admin, Member .... 
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }
        String attributes = getAttributes();
        String values = getValues();

        dbInterface.insert(table, attributes, values);
    }

    public void delete() {
        DBInterface dbInterface = DBInterface.getInstance();
        String table = this.getClass().getSimpleName();
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }

        dbInterface.delete(table, this.getId());
    }

    public void update() {
        DBInterface dbInterface = DBInterface.getInstance();
        String table = this.getClass().getSimpleName();
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }

        dbInterface.update(table, this.getOptions(), this.getId(), this.getWhere());
    }

    public  ArrayList<Object[]> getAll() {
        DBInterface dbInterface = DBInterface.getInstance();
        ArrayList<Object[]> results = null;
        String table = this.getClass().getSimpleName();
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }

        results = dbInterface.select(table);

        //extract data and create list of objects
        return results;
    }

    public ArrayList<Object[]> getUsingOptions() {
        DBInterface dbInterface = DBInterface.getInstance();
        ArrayList<Object[]> results = null;
        String table = this.getClass().getSimpleName();
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }

        results = dbInterface.select(table, this.getOptions());

        //extract data and create list of objects
        return results;
    }

    public ArrayList<Object[]> getUsingOptionsWhere() {
        DBInterface dbInterface = DBInterface.getInstance();
        ArrayList<Object[]> results = null;
        String table = this.getClass().getSimpleName();
        if(table.equals("Admin") || table.equals("Member")) {
            table = "SystemUser";
        }

        results = dbInterface.select(table, this.getOptions(), this.getWhere());

        //extract data and create list of objects
        return results;
    }

}
