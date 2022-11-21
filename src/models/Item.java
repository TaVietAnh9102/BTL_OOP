package models;
import java.util.ArrayList;


public class Item extends DataManager {
    //Attributes
    private int ID, categoryID, sessionID, sellerID;
    private String name, details, picture;
    private int price;
    
    private  ArrayList<Item> ItemList;
    
    private Sessions session ;
    private Category category;
    private SystemUser seller;
    private String catName, sellerName;
    private int startTime, served;
    
//    "ID,name,Details,picture,Price,categoryID,sessionID,sellerID,Served";
    
//    public Item(int sellerID, String name , String Pic, String details , int price ,  int categoryID ,int reserved ) {
//    	
//    }
    
    public Item(String name , String pic, String details , int price ,  int categoryID , int sessionId, int sellerID, int served) {
        this.name = name;
        this.details = details;
        this.picture = pic;
        this.price = price;
        this.categoryID = categoryID;
        this.sessionID = sessionId;
        this.sellerID = sellerID;
        this.served = served;
    }
    
    //Constructor
    public Item(int id, String name, String details, String pic, int price, int category,
                int session, int seller, int served) {
        this.ID = id;
        this.name = name;
        this.details = details;
        this.picture = pic;
        this.price = price;
        this.categoryID = category;
        this.sessionID = session;
        this.sellerID = seller;
        this.served = served;
    }
    
    public Item(){
    }
    
    
    public void initializeItems() {
        try {
            getData();   
        } catch (Exception e) {
            System.out.println("Error in DB");
        }

        Sessions x = new Sessions();
        Category y = new Category();
        SystemUser z = new SystemUser(); 
        x.initializeSessions();
        y.initializeCategories();
        ArrayList<SystemUser> UsersList = z.getSystemUsersList();
        ArrayList<Sessions> sessionList = x.getSessionList();
        ArrayList<Category> CategoryList = y.getCategoryList();

        for(Item i :ItemList) {
            for (Sessions s : sessionList) {
                if (s.getId() == i.sessionID){
                    i.session = s;
                    i.startTime = s.getStart_time();
                }
            }
            for(Category c: CategoryList) {
                if(c.getId()==i.categoryID) {
                    i.category=c;
                    i.catName = c.getCat_Name();
                }
            }
            for (SystemUser u: UsersList) {
                if (u.getId() == i.sellerID) {
                    i.seller = u;
                    i.sellerName = u.getFname() + " " + u.getLname();
                }
            }
        }

    }
    
    public String getName() {
        return this.name;
    }
    
    
    public String getDetails() {
        return this.details;
    }
    
    public String getPicture() {
        return this.picture;
    }
    
    public int getPrice() {
    	return this.price;
    }
    
    public int getCatID() {
    	return this.categoryID;
    }
    
    public int getSessionID() {
    	return this.sessionID;
    }
    
    public int getSellerID() {
    	return this.sellerID;
    }
    
    
    public Sessions getSession() {
    	return this.session;
    }
    
    public Category getCategory() { 
    	return this.category;
    }
    
    public String getCatName() {
        return catName;
    }
    
    public String getSellerName() {
        return sellerName;
    }
    
    public void setCatName(String catName) {
        catName = catName;
    }
    
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    
    public SystemUser getSeller() {
    	return this.seller;
    }
    
    public void setID(int id) {
        this.ID = id;
    }
    
    public int getID() {
    	return this.ID;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public void setPicture(String pic) {
    	this.picture = pic;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setCategoryID(int category) {
    	this.categoryID=category;
    }
    
    public void setSessionID(int session) {
    	this.sessionID=session;
    }
    
    public void setSellerID(int seller) {
    	this.sellerID=seller;
    }
    
    public void setServed(int i){
        this.served = i;
    }
    
    public int getServed() {
    	return this.served;
    }


//    Methods
    @Override
    protected String getAttributes() {
        return "ID,item_name,Details,picture,Price,Cat_ID,session_ID,seller_ID,Served";
    }
    
    @Override
    protected String getValues() {
        return   ID + ",'" + name + "','" + details + "','"+picture+"',"+price+","+categoryID+","+sessionID+","+sellerID+","+served;
    }

    @Override
    protected String getWhere() {
        return "";
    }

    @Override
    public int getId() {
        return this.ID;
    }

    @Override
    protected Object get() {
        return null;
    }
    
	@Override
	protected String getOptions() {
		return null;
	}

    public ArrayList<Item> getItemList() {
    	return this.ItemList;
    }

    public void getData() throws NullPointerException {
        ItemList = new ArrayList<>();
        ArrayList<Object[]> list = getAll();
        for(Object[] item : list) {
            ItemList.add(new Item((int) item[0], (String) item[1], (String) item[2], (String) item[3],
                    (int) item[4], (int) item[5],(int) item[6],(int) item[7], (int) item[8]));
        }
    }

    public void add() {
    	super.add();
    }

    public void delete() {
    	super.delete();
    }

    public void update() {
    	super.update();
    }

    public ArrayList<Object[]> getParticipatedBidders(int sessionID , int itemID){
        DBInterface db = DBInterface.getInstance();
        return db.select(
          "systemuser,session_participants",
                "ID,Fname,Lname,phone,price",
                    "systemuser.ID = session_participants.bidder_ID and session_ID = "+sessionID+" and item_ID ="+itemID+" ORDER BY price DESC"
        );
    }
    
    public int getCurrentPrice(int sessionID,int itemID) {
        DBInterface dbInterface = DBInterface.getInstance();
        ArrayList<Object[]> x = dbInterface.select(
          "session_participants",
                "max(price)",
                "session_ID = "+sessionID+" and item_ID = "+itemID
        );
        int pr;
        try {
			pr = (int)x.get(0)[0];
        } catch (NullPointerException e) {
			pr = this.getPrice();
		}
        return pr;
    }
    
    public void submitNewPrice(int sessionID,int item_ID,int bidder_ID,String price){
        DBInterface db = DBInterface.getInstance();
        db.update("session_participants","price",price," session_ID = "+sessionID+" and item_ID = "+
                item_ID +" and bidder_ID = "+bidder_ID);
    }
    
    public void setItemServed(int itemID){
        DBInterface.getInstance().update(
                "item","Served","1","ID = "+itemID
        );
    }
    
    
}