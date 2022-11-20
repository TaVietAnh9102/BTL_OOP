package models;
import java.util.ArrayList;


public class Item extends DataManager {
	private static int counter = 53;
    //Attributes
    private int ID, Cat_ID, session_ID, seller_ID;
    private String Item_name, details, picture;
    private int price;
    
    private  ArrayList<Item> ItemList;
    
    private Sessions session ;
    private Category category;
    private SystemUser seller;
    private String CatName, SellerName;
    private int StartTime, served;
    
//    "ID,Item_name,Details,picture,Price,Cat_ID,session_ID,seller_ID,Served";
    
    public Item(String name , String pic, String details , int price ,  int categoryID , int sessionId, int sellerID, int served) {
    	this.ID = counter++;
        this.Item_name = name;
        this.details = details;
        this.picture = pic;
        this.price = price;
        this.Cat_ID = categoryID;
        this.session_ID = sessionId;
        this.seller_ID = sellerID;
        this.served = served;
    }
    
    //Constructor
    public Item(int id, String name, String details, String pic, int price, int category,
                int session, int seller, int served) {
        this.ID = id;
        this.Item_name = name;
        this.details = details;
        this.picture = pic;
        this.price = price;
        this.Cat_ID = category;
        this.session_ID = session;
        this.seller_ID = seller;
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
                if (s.getId() == i.session_ID){
                    i.session = s;
                    i.StartTime = s.getStart_time();
                }
            }
            for(Category c: CategoryList) {
                if(c.getId()==i.Cat_ID) {
                    i.category=c;
                    i.CatName = c.getCat_Name();
                }
            }
            for (SystemUser u: UsersList) {
                if (u.getId() == i.seller_ID) {
                    i.seller = u;
                    i.SellerName = u.getFname() + " " + u.getLname();
                }
            }
        }

    }
    
    public String getItem_name() {
        return this.Item_name;
    }
    
    public void  setItem_name(String n) {
    	this.Item_name = n;
    }
    
    public String getDetails() {
        return this.details;
    }
    
    public String getpicture() {
        return this.picture;
    }
    
    public long getPrice() {
    	return this.price;
    }
    
    public int getCat_ID() {
    	return this.Cat_ID;
    }
    
    public int getSession_ID() {
    	return this.session_ID;
    }
    
    public int getSeller_ID() {
    	return this.seller_ID;
    }
    
    
    public Sessions getSession() {
    	return this.session;
    }
    
    public Category getCategory() { 
    	return this.category;
    }
    
    public int getStartTime() {
        return StartTime;
    }
    
    public void setStartTime(int startTime) {
        StartTime = startTime;
    }
    
    public String getCatName() {
        return CatName;
    }
    
    public String getSellerName() {
        return SellerName;
    }
    
    public void setCatName(String catName) {
        CatName = catName;
    }
    
    public void setSellerName(String sellerName) {
        this.SellerName = sellerName;
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
    	this.Item_name = name;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public void setpicture(String pic) {
    	this.picture = pic;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setCat_ID(int category) {
    	this.Cat_ID=category;
    }
    
    public void setSession_ID(int session) {
    	this.session_ID=session;
    }
    
    public void setSeller_ID(int seller) {
    	this.seller_ID=seller;
    }
    
    public void setServed(int i){
        this.served = i;
    }
    
    public int getServed() {
    	return this.served;
    }


    //Methods
    @Override
    protected String getAttributes() {
        return "ID,Item_name,Details,picture,Price,Cat_ID,session_ID,seller_ID,Served";
    }
    
    @Override
    protected String getValues() {
        return   ID + ",'" + Item_name + "','" + details + "','"+picture+"',"+price+","+Cat_ID+","+session_ID+","+seller_ID+","+served;
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
    
    public long getCurrentPrice(int session_ID,int itemID) {
        DBInterface dbInterface = DBInterface.getInstance();
        ArrayList<Object[]> x = dbInterface.select(
          "session_participants",
                "max(price)",
                "session_ID = "+session_ID+" and item_ID = "+itemID
        );
        long pr;
        try {
			pr = Long.parseLong((String)x.get(0)[0]);
		} catch (Exception e) {
			pr = this.getPrice();
		}
        return pr;
    }
    
    public void submitNewPrice(int session_ID,int item_ID,int bidder_ID,String price){
        DBInterface db = DBInterface.getInstance();
        db.update("session_participants","price",price," session_ID = "+session_ID+" and item_ID = "+
                item_ID +" and bidder_ID = "+bidder_ID);
    }
    
    public void setItemServed(int itemID){
        DBInterface.getInstance().update(
                "item","Served","1","ID = "+itemID
        );
    }
    
    
}