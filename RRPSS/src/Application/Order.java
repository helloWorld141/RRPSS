package Application;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
	private int orderID;
	private int staffID;
	private int tableID;
	private int totalPrice;
	private LocalDateTime timeStamp;
	private ArrayList<MenuItem> menuItemsOrder;
	private ArrayList<PromotionalPackage> promotionalPackageOrder;
	
	Order(int orderID, int staffID, int tableID, LocalDateTime timeStamp, ArrayList<MenuItem> itemsOrder, ArrayList<PromotionalPackage> packageOrder){
		this.orderID = orderID;
		this.staffID = staffID;
		this.tableID = tableID;
		this.timeStamp = timeStamp;
		this.menuItemsOrder = itemsOrder;
		this.promotionalPackageOrder = packageOrder;
	}
	
	public int getOrderID(){
		return this.orderID;
	}
	public LocalDateTime when(){
		return this.timeStamp;
	}
	
	public void addMenuItem(MenuItem toAdd){
		this.menuItemsOrder.add(toAdd);
	}
	public void addMenuItems(ArrayList<MenuItem> items){
		for (MenuItem item:items){
			addMenuItem(item);
		}
	}
	public void addPromotionalPackage(PromotionalPackage toAdd){
		this.promotionalPackageOrder.add(toAdd);
	}
	public void addPromotionalPackges(ArrayList<PromotionalPackage> packages){
		for (PromotionalPackage packagee:packages){
			addPromotionalPackage(packagee);
		}
	}
	public void removeItems(ArrayList<String> itemIDs){
		for(int i =0;i<menuItemsOrder.size();i++){
			if (itemIDs.contains(menuItemsOrder.get(i).getID())){
				menuItemsOrder.remove(i);
			}
		}
	}
	public void removePackages(ArrayList<Integer> packageIDs){
		for(int i =0;i<promotionalPackageOrder.size();i++){
			if (packageIDs.contains(promotionalPackageOrder.get(i).getID())){
				promotionalPackageOrder.remove(i);
			}
		}
	}
	public String forReport(){
		//TODO
		// what to print for each entry in the report
		return new String();
	}
	public String info(){
		//TODO
		return "\n";
	}
	
	@Override
	public String toString(){
		//TODO
		// what to print in orderInvoice
		return this.toString();
	}
	
	public void printOrderInvoice(){
		System.out.println(this);
	}
}
