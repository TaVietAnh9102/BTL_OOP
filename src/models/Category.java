package models;
import java.util.ArrayList;

public class Category extends DataManager {
    private int ID, Admin_ID;
    private String Cat_Name, Admin_Name;
    
    private ArrayList<Category> CategoryList = new ArrayList<Category>();


    public Category(){
    }
    
    public Category(int id, String name,String adminName) {
        this.ID = id;
        this.Cat_Name = name;
        this.Admin_Name = adminName;
    }
    
    public Category(int id, String name, int admin) {
        this.ID = id;
        this.Cat_Name = name;
        this.Admin_ID = admin;
    }
    
    public  void initializeCategories() {
        try {
            getData();
        }catch (NullPointerException e) {
            System.out.println("Error in DB");
        }
    }
    
    public void setID(int id) {
        this.ID = id;
    }
    
    public void setName(String name) {
        this.Cat_Name = name;
    }
    
    public int getID() {
    	return this.ID;
    }
    
    public String getCat_Name() {
    	return this.Cat_Name;
    }
    
    public int getAdmin_ID() {
    	return Admin_ID;
    }
    
    public void setAdmin_ID(int admin) {
    	this.Admin_ID=admin;
    }
    
    public String getAdmin_Name() {
        return Admin_Name;
    }
    
    public void setAdmin_Name(String admin_Name) {
        Admin_Name = admin_Name;
    }


    @Override
    protected String getAttributes() {
        return "ID, Cat_Name,Admin_ID";
    }

    @Override
    protected String getValues() {
        return ID + ",'" + Cat_Name + "',"+Admin_ID;
    }

    @Override
    protected String getOptions() {
        return "  Cat_Name= '" + Cat_Name + "'";
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


    public ArrayList<Category> getCategoryList() {
        return CategoryList;
    }
    
    public void getData() throws NullPointerException {
    	ArrayList<Object[]> list = getAll();
        for(Object[] category : list) {
            CategoryList.add(new Category((int) category[0], (String) category[1], (int) category[2]));
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
    
}