package models;

import java.util.ArrayList;


/*
 * 	LOGIN
 * 	(0)		Admin
 * 	(1)		Member
 * 
 * 	(-2)	pass is wrong
 *  (-1) 	Email is wrong
 *  
 *  Gender
 *  (0)  	MALE
 *  (1)  	FEMALE
 * 
 */

public class SystemUser extends DataManager {
	
    //Attributes
	private int id, Gender;
    private String Fname, Lname, email, pass, Birthdate, phone;
    
    // for class member
    protected ArrayList<SystemUser> systemUsersList = new ArrayList<SystemUser>();
    

    //Constructor
    public SystemUser(){
        getData();
    }

    public SystemUser(int id, String Fname, String Lname, String Email, String password, 
    					int gender, String Birthdate, String phone) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = Email;
        this.pass = password;
        this.Gender = gender;
        this.Birthdate = Birthdate;
        this.phone = phone;
    }

    //Methods
    public ArrayList<String> GetEmails(){
    	ArrayList<String> Email = new ArrayList<String>();
        for (SystemUser user : systemUsersList) {
            Email.add(user.email);
        }
        return Email;
    }
    
    public void getData() throws NullPointerException {
    	ArrayList<Object[]> list = getAll();
        for(Object[] user : list) {
            systemUsersList.add(new SystemUser((int) user[0], (String) user[1], (String) user[2], (String) user[3], 
            									(String) user[4], (int) user[5], (String) user[6], (String) user[7]));
        }
    }
    
    public int Login(String EMAIL,String Password) {
        try {
            for (SystemUser user : systemUsersList) {
                if (user.email.equalsIgnoreCase(EMAIL)) {
                    if (user.pass.equals(Password)) {
                        System.out.println("Email & Password are Correct \nLogin Successfully\n\n\n" +
                                "WELCOME " + user.Fname + " " + user.Lname);
                        id = user.id;
                        setFname(user.Fname);
                        setLname(user.Lname);
                        setEmail(user.email);
                        setPassword(user.pass);
                        setGender(user.Gender);
                        setBirthdate(user.Birthdate);
                        setPhone(user.phone);
                        return 1;
                    } else {
                        System.out.println("Password is wrong");
                        return -2;
                    }

                }
            }
            System.out.println("Email is wrong");
            return -1;
        }catch (NullPointerException e){
            return -4;
        }

    }
    
    public void Logout(SystemUser systemUser){
        systemUser.systemUsersList.clear();
        systemUser = null;
    }
    
    public void resetPassword(String mail) {
    	for (SystemUser user : systemUsersList) {
    		if (user.getEmail().equals(mail)) {
    			user.setPassword("123456");
    			user.update();
    			return;
    		}
    	}
    	
    	System.out.println("done");
    }
    
//    public ArrayList<String> getNotifications(int userID) {
//        ArrayList<Object[]> AllUsersNotifications = new ArrayList<>();
//        ArrayList<String> UserNotifications = new ArrayList<>();
//
//        // get instance from DBInterface to work on database
//        DBInterface DB = DBInterface.getInstance();
//
//        // get all notifications
//        AllUsersNotifications = DB.select("Notification" , "message" , userID);
//
//        for (Object[] obj : AllUsersNotifications) {
//            UserNotifications.add(obj[0].toString());
//        }
//
//        return UserNotifications;
//    }


    //Getters and Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return pass;
    }
    
    public int getGender() {
        return Gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }
    
    public String getPhone() {
        return phone;
    }
   
    
    public ArrayList<SystemUser> getSystemUsersList() {
        return systemUsersList;
    }
  
    @Override
    protected String getAttributes() {
        return "Fname,Lname,email,pass,Gender,Birthdate,phone";
    }

    @Override
    protected String getValues() {
        return "'" + Fname + "','" + Lname + "','" + email + "','" + pass + "'," + Gender + ",'" + Birthdate + "','" + phone + "'";
    }

    @Override
    protected String getOptions() {
        return "Fname = '" + Fname + "'" + "," + "Lname = '" + Lname + "'" + "," + "pass = '" + pass + "'";
    }

    @Override
    protected String getWhere() {
        return "";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    protected Object get() {
        return null;
    }
    
    @Override
    public void add() {
        super.add();
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public void update() {
        super.update();
    }

    
    
    
    // get user by id
    public SystemUser getUserbyid(int id){
        for (SystemUser s: systemUsersList) {
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
}

