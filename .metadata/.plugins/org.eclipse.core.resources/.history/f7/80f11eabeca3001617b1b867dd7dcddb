package Application;
import java.util.ArrayList;

public class PromotionalPackage {
	private double packagePrice;
	private ArrayList<MenuItem> itemList;
	private String packageName;
	
	public PromotionalPackage(String packageName, double packagePrice, ArrayList<MenuItem> itemLitst){
		this.packagePrice = packagePrice;
		this.itemList = itemLitst;
		this.packageName = packageName;
	}
	
	public PromotionalPackage(String name, double price){
		this.packagePrice = price;
		this.packageName = name;
		this.itemList = new ArrayList<MenuItem>();
	}
	
	public double getPackagePrice(){
		return this.packagePrice;
	}
	public void setPackagePrice(double packagePrice){
		this.packagePrice = packagePrice; 
	}
	public ArrayList<MenuItem> getitemList(){
		return this.itemList;
	}
	public String getPackageName(){
		return packageName;
	}
	public void setPackageName(String packageName){
		StringBuilder sb = new StringBuilder(packageName);
		this.packageName = sb.toString();
	}
	
	public void addItem(MenuItem item){
		itemList.add(item);
	}
	public void removeItem(String itemID){
		for (int i=0;i<itemList.size(); i++){
			if (itemList.get(i).getID().equals(itemID))
				itemList.remove(i);
		}
	}
}
