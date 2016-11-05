package Application;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.time.*;
import Helper.*;
public class Restaurant {
	private ArrayList<Table> tableList;
	private ArrayList<Staff> staffList;
	private OrderHistory orderHistory;
	private Menu menu;
	
	Restaurant() throws IOException{
		ArrayList<Table> tbList = new ArrayList<Table>();
		tbList = (ArrayList)IOHandler.readSerializedObject("Tables.db");
		System.out.println(tbList);
		//TODO load staff from file db
		//orderHistory = new OrderHistory();
		
	}
	
	public void createMenuItem(int type, String name, String description, double price){
		menu.createItem(type, name, description, price);
	}
	public void updateMenuItem(int target, String id, String newVal){
		switch(target){
		case 1:
			menu.updateItemName(id, newVal);
			break;
		case 2:
			menu.updateItemPrice(id, Double.parseDouble(newVal));
			break;
		case 3:
			menu.updateItemDescription(id, newVal);
			break;
		default:
			System.out.println("Invalid choice!!!");
		}
	}
	public void removeMenuItem(String id){
		menu.removeMenuItem(id);
	}
	
	public void createPromoPack(String name, Double price){
		menu.createPromotionalPackage(name, price);
	}
	public void updatePromoPack(int target, int id, String newVal){
		switch(target){
		case 1:
			menu.updatePackageName(id, newVal);
			break;
		case 2:
			menu.updatePackagePrice(id, Double.parseDouble(newVal));
			break;
		default:
			System.out.println("Invalid choice!!!");
		}
	}
	public void addItemToPackage(int packageID, String itemID, double newPrice){
		//menu.addItemToPackage(packageID, itemID, newPrice);
	}
	public void removeItemFromPackage(int packageID, String itemID){
		
	}
	public void removePromoPack(int packageNo){
		menu.removePromotionalPackage(packageNo);
	}
	
	public void createNewOrder(){
		
	}
	public void viewOrder(){
		
	}
	public void addToOrder(){
		
	}
	public void removeFromOrder(){
		
	}
	
	public boolean tableAvail(int tableID){
		for (int i=0; i<tableList.size(); i++){
			if (tableList.get(i).getTableID() == tableID){
				return (tableList.get(i).getStatus() == TableStatus.available);
			}
		}
		return true;
	}
	public void showAvailableTables(){
		ListIterator<Table> i = tableList.listIterator(); 
		while (i.hasNext()){
			Table table = i.next();
			if (table.getStatus().equals(TableStatus.available))
				System.out.println(table);
		}
			
	}
	
	public void printOrderInvoice(int orderID){
		
	}
	public void printSaleRevenue(Date date){
		
	}
	public void printSaleRevenue(Month month){
		
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
