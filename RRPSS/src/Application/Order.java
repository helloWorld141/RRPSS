package Application;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements Serializable{
	private int orderID;
	private int staffID;
	private int tableID;
	private int totalPrice;
	private LocalDateTime timeStamp;
	private ArrayList<MenuItem> menuItemsOrder;
	private ArrayList<PromotionalPackage> promotionalPackageOrder;
	private boolean paid;
	
	Order(int orderID, int staffID, int tableID, LocalDateTime timeStamp, ArrayList<MenuItem> itemsOrder, ArrayList<PromotionalPackage> packageOrder){
		this.orderID = orderID;
		this.staffID = staffID;
		this.tableID = tableID;
		this.timeStamp = timeStamp;
		this.menuItemsOrder = itemsOrder;
		this.promotionalPackageOrder = packageOrder;
		this.paid = false;
		this.totalPrice = 0;
		for (MenuItem item:menuItemsOrder){
			this.totalPrice += item.getPrice();
		}
		for (PromotionalPackage packagee:promotionalPackageOrder){
			this.totalPrice += packagee.getPackagePrice();
		}
	}
	
	public int getOrderID(){
		return this.orderID;
	}
	public LocalDateTime when(){
		return this.timeStamp;
	}
	public int getTableID(){
		return this.tableID;
	}
	public void pay(){
		this.paid = true;
	}
	public boolean isPaid(){
		return this.paid;
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
		String d = "|";
		return "Order "+orderID+d+"Staff "+staffID+d+"Table "+tableID+d+"Price "+totalPrice+"\n";
	}
	
	@Override
	public String toString(){
		//TODO
		// what to print in orderInvoice
		
		String d = "\n";
		String res = "Order "+orderID+d+"List of items and packages:";
		for (MenuItem item:menuItemsOrder){
			res = res.concat(d+item.toString());
		}
		for (PromotionalPackage packagee:promotionalPackageOrder){
			res = res.concat(d+packagee.toString());
		}
		res = res.concat(d+"Total Price:" + String.valueOf(totalPrice));
		return (res);
	}
	
	public void printOrderInvoice(){
		System.out.println(this);
	}
}
