package models;

import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Member extends SystemUser{

    //Constructor
    public Member(){
    }

    public Member(SystemUser loginClient ){
        this.setEmail(loginClient.getEmail());
        this.setFname(loginClient.getFname());
        this.setLname(loginClient.getLname());
        this.setPassword(loginClient.getPassword());
        this.setBirthdate(loginClient.getBirthdate());
        this.setId(loginClient.getId());
        this.setGender(loginClient.getGender());
        this.setPhone(loginClient.getPhone());
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
        // insert info into database
        this.add();
        System.out.println("registered successfully");
    }
    
    public Item viewDetails(int itemId) {

        Item item = new Item();
        item.initializeItems();  
        ArrayList<Item> AllRetrunedItems = item.getItemList();

        Item neededItem = null;
        for (Item x: AllRetrunedItems) {
            if (itemId == x.getId()) {
                neededItem = x;
            }
        }
        return neededItem;
    }
    
    
    public ArrayList<Integer> getParticipatedSessions() {
    	ArrayList<Integer> info = new ArrayList<>();
    	DBInterface DB = DBInterface.getInstance();
    	//return all his session time
    	ArrayList<Object[]> records = DB.select("session_participants", "item_ID",
                    			"bidder_id =" + this.getId());
    	//record is itemId list
    	for (Object[] e: records) {
    		info.add((Integer)e[0]);
    	}
    	return info;
    }
    
    
    public ArrayList<Item> getParticipatedItem() {
    	ArrayList<Item> participatedItem = new ArrayList<>();
    	ArrayList<Integer> paticipatedSessions = getParticipatedSessions();
    	Item item = new Item();
    	item.initializeItems();
    	ArrayList<Item> AllITem = item.getItemList();
    	for (Item x: AllITem) {
    		if(paticipatedSessions.contains(x.getId())) {
    			participatedItem.add(x);
    			System.out.println(x.getId());
    		}
    	}
    	return participatedItem;
    }
    
 	
 
    //seller

    public void submitItem(int sellerID, String name , String details, String pic , int price ,  int categoryID ,String date, int startTime, int endTime) {
    	submitSessions(startTime, endTime, date, 0);
    	Sessions sessions = new Sessions();
    	sessions.getData();
    	List<Sessions> sessionsList = sessions.getSessionList();
    	sessions = sessionsList.get(sessionsList.size() - 1);
    	
    	Item itemMNG = new Item();
    	itemMNG.getData();
    	List<Item> itemList = itemMNG.getItemList();
    	
    	Item newItem = new Item(itemList.get(itemList.size()-1).getId() + 1, name, details, pic, price, categoryID,  sessions.getId(), sellerID, 0);
    	newItem.add();
        System.out.println("Item has been added successfully");
    }
    
    
    private void submitSessions(int startTime, int endTime, String date, int reserved){
       Sessions sessions = new Sessions();
       sessions.setStart_time(startTime);
       sessions.setEnd_time(endTime);
       sessions.setSession_date(date);
       sessions.setReserved(reserved);
       sessions.add();
    }
   

    //Get all item Products of Seller
    public ArrayList<Item> viewSellerItems(int sellerID) {
    	ArrayList<Item> SellerItems = new ArrayList<>();

    	Item item = new Item();
    	item.initializeItems();
    	ArrayList<Item> AllRetrunedItems = item.getItemList();

    	for (Item x: AllRetrunedItems) {
    		if (sellerID == x.getSellerID()){
    			SellerItems.add(x);
    		}
    	}
    	return SellerItems;
    }

   
    

    public ArrayList<Object[]> getParticipatedBidder(int itemID) {
    	ArrayList<Object[]> bidders = new ArrayList<>();
    	DBInterface db = DBInterface.getInstance();

    	bidders = db.select("session_participants,systemuser" , "systemuser.Fname , systemuser.Lname",
                    "systemuser.ID = session_participants.bidder_ID and session_participants.item_ID = "+ itemID);
    	return  bidders;
    }
        
        
    //Bidder
        

    //Get all Products to show to user
    public ArrayList<Item> viewProducts() {
    	ArrayList<Item> AcceptedItems = new ArrayList<>();
    	Item item = new Item();
    	item.initializeItems();
    	ArrayList<Item> AllRetrunedItems = item.getItemList();
    	for (Item it: AllRetrunedItems) {
    		if (it.getServed() == 0){   // not served then can be in product menu
    			System.out.println(it.getServed());
    			AcceptedItems.add(it);
    		}
    	}

    	return AcceptedItems;
    }
    
    
    
    public void SubmitBid(int bidder_id, int session_id, int item_id) {
    	// Set_Bids
    	DBInterface DB = DBInterface.getInstance();
    	DB.insert("session_participants","session_ID,Bidder_ID,Item_ID",""+session_id+","+bidder_id+","+item_id);
    	System.out.println("Bid submitted successfully successfully");
    }

    public boolean isParticipated(int itemID){
    	ArrayList<Item> participatedItem = getParticipatedItem();
    	for(Item item : participatedItem) {
    		if(item.getId() == itemID) {
    			return true;
    		}
    	}
    	return false;
    }

    public void participate(int bidderID , int itemID) {
    	int sessionID = 0;
    	ArrayList<Item> AllItems;
    	Item item = new Item();
    	item.initializeItems();
    	AllItems = item.getItemList();
    	for (Item it : AllItems) {
    		if (it.getId() == itemID) {
    			System.out.println(it.getSessionID());
    			sessionID = it.getSessionID();
    		}
    	}
    	SubmitBid(bidderID, sessionID, itemID);
    }

    public void updatePrice(int session_ID,int item_ID, int price){
        DBInterface db = DBInterface.getInstance();
        db.update("session_participants","price ",  price + ""," session_ID = "+session_ID+" and item_ID = "+
                item_ID +" and bidder_ID = "+this.getId());
    }

    
}
