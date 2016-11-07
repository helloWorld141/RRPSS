package Application;
import java.time.*;
import java.util.ArrayList;
public class Reservation {
	private int id;
	private String contact;
	private LocalDateTime arrivalTime;
	private int pax;
	private ArrayList<Integer> tableIDs;
	
	Reservation(int id, String contact, LocalDateTime arrival, int pax){
		this.id = id;
		this.contact = contact;
		this.arrivalTime = arrival;
		this.pax = pax;
		this.tableIDs = new ArrayList<Integer>();
	}
	
	public int getID(){
		return this.id;
	}
	public void setTime(LocalDateTime arrival){
		this.arrivalTime = arrival;
	}
	public LocalDateTime getTime(){
		return this.arrivalTime;
	}
	public String getContact(){
		return this.contact;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public ArrayList<Integer> getTableIDs(){
		return this.tableIDs;
	}
	public void assign(int tableID){// check validity of tableID in upper layer 
		this.tableIDs.add(tableID);
	}
	//return ids of tables chosen
	public ArrayList<Integer> autoAssignTables(ArrayList<Table> availTables){
		// List of all available tables
		int toFit = pax;
		if (availTables.isEmpty()) return new ArrayList<Integer>();
		availTables.sort(Table.CompareSeatNo);
		ArrayList<Integer> availIDs = new ArrayList<Integer>();
		//ArrayList<Integer> chosenIDs = new ArrayList<Integer>();
		for (Table table:availTables){
			availIDs.add(table.getTableID());
		}
		while (!availIDs.isEmpty() && toFit > 0){
			for (int i=0; i<availIDs.size();i++){
				Table tb = availTables.get(availIDs.get(i));
				if (tb.getSeatCapacity() >= toFit){
					toFit = 0;
					tableIDs.add(tb.getTableID());
					
					return tableIDs;
				}
			}
			int last = availIDs.size()-1;
			Table tb = availTables.get(availIDs.get(last));
			toFit -= tb.getSeatCapacity();
			tableIDs.add(tb.getTableID());
			availIDs.remove(last);
		}
		return new ArrayList<Integer>();
	}
}
