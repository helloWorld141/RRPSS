package Application;
import java.io.IOException;
import java.util.*;

public class Restaurant {
	private ArrayList<Table> tableList;
	private ArrayList<Staff> staffList;
	private OrderHistory orderHistory;
	private Menu menu;
	
	Restaurant() throws IOException{
		//TODO load tables from file db
		//TODO load staff from file db
		orderHistory = new OrderHistory();
		
	}
	
	public void showAvailableTables(){
		ListIterator<Table> i = tableList.listIterator(); 
		while (i.hasNext()){
			Table table = i.next();
			if (table.getStatus().equals(TableStatus.available))
				System.out.println(table);
		}
			
	}
	
	public void addTable(int numberOfSeat){
		int newID = tableList.size();
		tableList.add(new Table(newID, numberOfSeat));
	}
	
	public void removeTable(int tableID){
		for (int i =0; i<tableList.size(); i++)
			if (tableList.get(i).getTableID() == tableID){
				tableList.remove(i);
				break;
			};
	}
	
	public void addStaff(Staff newStaff){
		staffList.add(newStaff);
	}
	
	public void removeStaff(int staffID){
		for (int i =0; i<staffList.size(); i++)
			if (staffList.get(i).getStaffID() == staffID){
				staffList.remove(i);
				break;
			};
	}
}
