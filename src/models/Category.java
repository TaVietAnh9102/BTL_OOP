package models;
import java.util.ArrayList;

public class Category extends DataManager {
    private int ID;
    private String Cat_Name;
    
    private ArrayList<Category> CategoryList = new ArrayList<Category>();


    public Category(){
    }
    
    public Category(int id, String name) {
        this.ID = id;
        this.Cat_Name = name;
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
    


    @Override
    protected String getAttributes() {
        return "ID, Cat_Name";
    }

    @Override
    protected String getValues() {
        return ID + ",'" + Cat_Name + "'";
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
            CategoryList.add(new Category((int) category[0], (String) category[1]));
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
    
    @Override
    public String toString() {
    	return getCat_Name();
    }
    
}