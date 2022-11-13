package models;

import java.util.ArrayList;

public class Member extends SystemUser{
<<<<<<< HEAD
    //Attributes
=======
>>>>>>> main

    //Constructor
    public Member(){
    }

    public Member(SystemUser LoginClient , int auth){
<<<<<<< HEAD
        

=======
>>>>>>> main
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

<<<<<<< HEAD
    //Getters and Setters


=======
>>>>>>> main
    //Methods
    public void editInfo (SystemUser user , String EditedFname , String EditedLname , String EditedPassword) {
        user.setFname(EditedFname);
        user.setLname(EditedLname);
        user.setPassword(EditedPassword);
        user.update();
    }
<<<<<<< HEAD
=======
    
>>>>>>> main
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
<<<<<<< HEAD
    public void Register (String Fname , String Lname ,String Email , String password  , String phone ,
                          String  Birthdata, int gender ) {
=======
    
    public void Register (String Fname , String Lname ,String Email , String password  , String phone ,
                          String  Birthdata, int gender , int auth) {
>>>>>>> main
        this.setFname(Fname);
        this.setLname(Lname);
        this.setEmail(Email);
        this.setBirthdate(Birthdata);
        this.setPhone(phone);
        this.setPassword(password);
        this.setGender(gender);
<<<<<<< HEAD
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
=======
        this.setAuthorization(auth);
        this.setEmail(Email);
        // insert info into database
        this.add();
        System.out.println("registered successfully");
    }
    
    public Item viewDetails(int itemId) {

        Item item = new Item();
        item.initializeItems();  //init
        ArrayList<Item> AllRetrunedItems = item.getItemList();

        Item neededItem = null;
        for (Item x: AllRetrunedItems) {
            if (itemId == x.getId()) {
                neededItem = x;
            }
        }
        return neededItem;
    }
    
    
    public ArrayList<Integer> getParticipatedSessions(int userID) {
    	ArrayList<Integer> info = new ArrayList<>();
    	DBInterface DB = DBInterface.getInstance();
    	//return all his session time
    	ArrayList<Object[]> records = DB.select("sessions,item", "Start_time",
                    			"sessions.ID = item.session_ID and  item.seller_ID =" + userID);
    	for (Object[] e: records) {
    		info.add((Integer)e[0]);
    	}
    	return info;
    }
    
    
    //seller

    // this params are required as it needed to be added in the DB .. admin will be static
    public void submitItem(int sellerID , String name , String Pic, String details , double price , int sessionID ,  int categoryID ,int adminID ,int Accepted,int reserved ) {
    	Item SubmittedItem = new Item();
        SubmittedItem.setAdmin_ID(adminID);
        SubmittedItem.setSession_ID(sessionID);
        SubmittedItem.setCat_ID(categoryID);
        SubmittedItem.setPrice(price);
        SubmittedItem.setpicture(Pic);
        SubmittedItem.setDetails(details);
        SubmittedItem.setName(name);
        SubmittedItem.setAccepted(Accepted);
        SubmittedItem.setSeller_ID(sellerID);
        SubmittedItem.setServed(reserved);
        
        SubmittedItem.add();
        System.out.println("Item has been added successfully");
    }

//    public Object[] getSessionItemBid(int hour) {
//    	return new Object[0];
//    }


    //Get all item Products of Seller
    public ArrayList<Item> viewSellerItems(int sellerID) {
    	ArrayList<Item> SellerItems = new ArrayList<>();

    	Item item = new Item();
    	item.initializeItems();
    	ArrayList<Item> AllRetrunedItems = item.getItemList();

    	for (Item x: AllRetrunedItems) {
    		if (sellerID == x.getSeller_ID()){
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
        
    private ArrayList<Integer> participatedItems;

    //Get all Products to show to user
    public ArrayList<Item> viewProducts() {
    	ArrayList<Item> AcceptedItems = new ArrayList<>();
    	Item item = new Item();
    	item.initializeItems();
    	ArrayList<Item> AllRetrunedItems = item.getItemList();
    	for (Item it: AllRetrunedItems) {
    		if (it.getAccepted() == 1 && it.getServed() == 0){   //accept and not served then can be in product menu
    			System.out.println(it.getServed());
    			AcceptedItems.add(it);
    		}
    	}

    	return AcceptedItems;
    }

    public Object[] getSessionItemBid(int hour) {
    	Object[] INFO=null;
    	DBInterface DB = DBInterface.getInstance();
    	// this query to get All info from database ... if you want something else tell me or addit to the query
    	ArrayList<Object[]> AllInfo = DB.select("item,Sessions,Set_Bids,Category", "item.ID,item.Item_name,item.Details,Category.Cat_Name,item.picture,item.price,Sessions.Start_time,Sessions.End_time,Max(Set_Bids.Bids)",
                    "Category.ID =item.Cat_ID and Sessions.ID = Set_Bids.session_ID and item.ID = Set_Bids.Item_ID and Sessions.Start_time=" + hour);
    	// to return object of all info
    	for (Object[] obj : AllInfo) {
    		INFO = obj; 
    	}
    	return INFO;
    }


    public ArrayList<Item> SearchonProduct(int CategoryID) {
    	Item item = new Item();
    	item.initializeItems();
    	Category category = new Category();
    	category.initializeCategories();

    	ArrayList<Item> AllItems , CategoryItems = new ArrayList<>();
    	AllItems = item.getItemList();

    	for (Item obj : AllItems) {
    		if (obj.getCat_ID() == CategoryID){
    			CategoryItems.add(obj);
    		}
    	}
    	System.out.println(CategoryItems.size());
    	return CategoryItems;
    }

    public ArrayList<Item>  searchOnSpecificProduct (String CategoryName , String itemName){
    	System.out.println(CategoryName);
    	System.out.println(itemName);
    	int categoryID = 0;
    	Item item = new Item();
    	item.initializeItems();
    	Category category = new Category();
    	category.initializeCategories();
    	ArrayList<Item> AllItems;
    	ArrayList<Item> WantedItems= new ArrayList<>();
    	ArrayList<Category> AllCtegories = category.getCategoryList();
    	AllItems = item.getItemList();
    	for (Category c : AllCtegories) {
    		if (CategoryName.equals(c.getCat_Name())) {
    			System.out.println("found Category");
    			categoryID = c.getId();
    			for (Item obj : AllItems) {
    				if (obj.getItem_name().equals(itemName)){
    					System.out.println("found item &added");
    					WantedItems.add(obj);
    				}
    			}
    		} else {
    			System.out.println("Didn't find");
    		}
    	}
    	return WantedItems;
    }

    public void SubmitBid(int bidder_id, int session_id, int item_id, double bid) {
    	// Set_Bids
    	DBInterface DB = DBInterface.getInstance();
    	DB.insert("Set_Bids","Bidder_ID,session_ID,Item_ID,Bids",""+bidder_id+","+session_id+","+item_id+","+bid);
    	System.out.println("Bid submitted successfully successfully");
    }

    public void init_participateditems(int id) {
    	participatedItems = new ArrayList<>();
    	DBInterface db = DBInterface.getInstance();
    	ArrayList<Object[]> result = db.select("session_participants","item_ID","bidder_ID = "+id);
    	for (Object[] record: result) {
    		participatedItems.add((Integer) record[0]);
    	}
    }

    public boolean isParticipated(int itemID){
    	return participatedItems.contains(itemID);
    }

    public void participate(int bidderID , int itemID) {
    	int sessionID = 0;
    	ArrayList<Item> AllItems;
    	Item item = new Item();
    	item.initializeItems();
    	AllItems = item.getItemList();
    	for (Item it : AllItems) {
    		if (it.getId() == itemID) {
    			System.out.println(it.getSession_ID());
    			sessionID = it.getSession_ID();
    		}
    	}
    	DBInterface DB = DBInterface.getInstance();
    	DB.insert("session_Participants", "session_ID,bidder_ID,item_ID", "" + sessionID + "," + bidderID+","+ itemID);
    	System.out.println("participate successfully");
    	init_participateditems(bidderID);
    	System.out.println("reinitializing Participated items List ..");
    }

}
>>>>>>> main
