package models;

import java.util.ArrayList;

public class Member extends SystemUser{
    //Attributes

    //Constructor
    public Member(){
    }

    public Member(SystemUser LoginClient , int auth){
        

        this.systemUsersList = LoginClient.getSystemUsersList();
        this.setEmail(LoginClient.getEmail());
        this.setFname(LoginClient.getFname());
        this.setLname(LoginClient.getLname());
        this.setAuthorization(LoginClient.getAuthorization());
        this.setPassword(LoginClient.getPassword());
        this.setBirthdate(LoginClient.getBirthdate());
        this.setId(LoginClient.getId());
        this.setGender(LoginClient.getGender());
        this.setPhone(LoginClient.getPhone());
    }

    //Getters and Setters


    //Methods
    public void editInfo (SystemUser user , String EditedFname , String EditedLname , String EditedPassword) {
        user.setFname(EditedFname);
        user.setLname(EditedLname);
        user.setPassword(EditedPassword);
        user.update();
    }
    public boolean canRegister(String email){
        ArrayList<String> checkEmails = this.GetEmails();
        for (String em : checkEmails) {
            if (em.equals(email)) {
                System.out.println("Email is exist");
                return false;
            }
        }
        return true;
    }
    public void Register (String Fname , String Lname ,String Email , String password  , String phone ,
                          String  Birthdata, int gender ) {
        this.setFname(Fname);
        this.setLname(Lname);
        this.setEmail(Email);
        this.setBirthdate(Birthdata);
        this.setPhone(phone);
        this.setPassword(password);
        this.setGender(gender);
        this.setEmail(Email);
        // insert info. into database
        this.add();
//        System.out.println("registered successfully");
    }
//    public Item viewDetails(int itemId) {
//      //  Item neededItem = new Item() ;
//      //  AllRetrunedItems = neededItem.getItemList();
//        // AllItems = Item.get();
//
//        Item item = new Item();
//        item.initializeItems();  //init
//        ArrayList<Item> AllRetrunedItems = item.getItemList();
//
//
//        Item neededItem = null;
//        for (Item x: AllRetrunedItems) {
//            if (itemId == x.getId()) {
//                neededItem = x;
//            }
//        }
//        return neededItem;
//    }
}