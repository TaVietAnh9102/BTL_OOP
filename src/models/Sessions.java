package models;

import java.util.ArrayList;


public class Sessions extends DataManager{
	
	// attributes
	public int ID;
	private String Session_date;
	private int Start_time;
	private int End_time;
	private SystemUser winner = null;
	private int reserved;
	
	public ArrayList<Sessions> SessionList = new ArrayList<>();
	private ArrayList<Object[]> list;
	
	public Sessions() {
	}

	public Sessions(int id, String session_date, int start_time, int end_time, int reserved) {
		ID = id;
		Session_date = session_date;
		Start_time = start_time;
		End_time = end_time;
		this.reserved = reserved;
	}
	
	public void initializeSessions() {
		try {
			getData();
		} catch (NullPointerException e) {
			System.out.println("Error DB (Sessions)");
		}
	}
	
	// Setters
	public void setID(int id) {
        this.ID = id;
    }
	
    public void setStart_time(int time) {
        this.Start_time = time;
    }
    
    public void setEnd_time(int time) {
        this.End_time = time;
    }
    
    public void setSession_date(String session_date) {
        this.Session_date = session_date;
    }
    
    public void setReserved(int i){
        reserved = i;
    }
	
	// Getters
	public int getID() {
		return ID;
	}
	
	public String getSession_date() {
		return Session_date;
	}
	
	public int getStart_time() {
		return Start_time;
	}
	
	public int getEnd_time() {
		return End_time;
	}

	public int getReserved() {
		return reserved;
	}
	
	@Override
	protected String getAttributes() {
		return "Session_date,Start_time,End_time,reserved";
	}

	@Override
	protected String getValues() {
		return Session_date + "," + Start_time + "," + End_time + "," + reserved;
	}

	@Override
	protected String getOptions() {
		return null;
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
	
	// Methods
	public ArrayList<Sessions> getSessionList() {
        return SessionList;
    }
	
	public void getData() throws NullPointerException {
        list = getAll();
        for (Object[] session : list) {
            SessionList.add(new Sessions((int) session[0], (String) session[1], (int) session[2], (int) session[3] , (int)session[4]));
        }
    }
	
	// add, update, delete
	public void add() {
		super.add();
	}
	
	public void delete() {
		super.delete();
	}
	
	public void update() {
		super.update();
	}
	
	
	// select
	public SystemUser GetWinnerUser(int end_time) {
		
        DBInterface db = DBInterface.getInstance();
        ArrayList<Object[]> winnerinfo = null;
        initializeSessions();
        
        for (Sessions s : SessionList) {
            if (s.getEnd_time() == end_time) {
                winnerinfo = db.select(
                        "systemuser, sessions",
                        "systemuser.ID, systemuser.Fname, systemuser.Lname, systemuser.phone",
                        "sessions.Winner_ID = systemuser.ID and sessions.End_time = " + end_time);
                System.out.println("after select winner in db winnerinfo list is " + winnerinfo);
                break;
            }
        }

        if (!winnerinfo.isEmpty()){
            winner = new SystemUser();
            winner.setId((int) winnerinfo.get(0)[0]);
            winner.setFname((String) winnerinfo.get(0)[1]);
            winner.setLname((String) winnerinfo.get(0)[2]);
            System.out.println("winter is set 100%");
        }

        return winner;
    }
	
    public void setWinnerUser(int sessionid , int winnerid) {
        DBInterface dbInterface = DBInterface.getInstance();
        dbInterface.update("sessions", "Winner_ID", winnerid + "", "ID = " + sessionid);
    }
    
    public ArrayList<Object[]> GetWinnerinfo(int itemID) {
    	DBInterface db = DBInterface.getInstance();
    	
        ArrayList<Object[]> record = db.select(
                "sessions, item, systemuser, session_participants",
                "systemuser.Fname, systemuser.Lname, systemuser.phone, systemuser.Email, session_participants.price",
                "sessions.ID = item.session_ID\n" +
                        "        and sessions.Winner_ID = systemuser.ID\n" +
                        "        and session_participants.bidder_ID = systemuser.ID\n" +
                        "        and session_participants.item_ID = item.ID\n" +
                        "        and item.ID = " + itemID);

        return record;
    }
    
    public void setSessionReserved(int sessionid){
        DBInterface.getInstance().update(
                "sessions",
                "reserved",
                "1",
                "sessions.ID = " + sessionid);
    }
}
