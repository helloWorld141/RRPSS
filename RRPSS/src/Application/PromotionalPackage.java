package Application;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nguyen Dang Duy Nghia
 *
 */
public class PromotionalPackage implements Serializable{
	/**
	 * the id of the package
	 * id is based on its index in the menu
	 */
	private Integer ID;
	/**
	 * the price of the package
	 */
	private double packagePrice;
	/**
	 * the list of items that this package offer
	 */
	private ArrayList<MenuItem> itemList;
	/**
	 * the name of the package
	 */
	private String packageName;
	
	/**
	 * constructor with list of items
	 * @param ID
	 * @param packageName
	 * @param packagePrice
	 * @param itemLitst
	 */
	public PromotionalPackage(Integer ID, String packageName, double packagePrice, ArrayList<MenuItem> itemLitst){
		this.ID = ID;
		this.packagePrice = packagePrice;
		this.itemList = itemLitst;
		this.packageName = packageName;
	}
	/**
	 * constructor without list of items
	 * @param ID
	 * @param name
	 * @param price
	 */
	public PromotionalPackage(Integer ID, String name, double price){
		this.ID = ID;
		this.packagePrice = price;
		this.packageName = name;
		this.itemList = new ArrayList<MenuItem>();
	}
	/**
	 * set the id of the package
	 * @param id
	 */
	public void setID(int id){
		this.ID = id;
	}
	/**
	 * get the id of this package
	 * @return
	 */
	public int getID(){
		return this.ID;
	}
	/**
	 * get the price of this package
	 * @return
	 */
	public double getPackagePrice(){
		return this.packagePrice;
	}
	/**
	 * set the price for this package
	 * @param packagePrice
	 */
	public void setPackagePrice(double packagePrice){
		this.packagePrice = packagePrice; 
	}
	/**
	 * get all the item in this package
	 * @return
	 */
	public ArrayList<MenuItem> getitemList(){
		return this.itemList;
	}
	/**
	 * get the name of the package
	 * @return
	 */
	public String getPackageName(){
		return packageName;
	}
	/**
	 * set the name for this package
	 * @param packageName
	 */
	public void setPackageName(String packageName){
		StringBuilder sb = new StringBuilder(packageName);
		this.packageName = sb.toString();
	}
	/**
	 * add item from menu into this package
	 * @param item
	 */
	public void addItem(MenuItem item){
		itemList.add(item);
	}
	/**
	 * remove item from the package according to its itemID
	 * @param itemID
	 */
	public void removeItem(String itemID){
		for (int i=0;i<itemList.size(); i++){
			if (itemList.get(i).getID().equals(itemID)){
				itemList.remove(i);
				return;
			}
		}
	}
	
	@Override
	public String toString(){
		String d = "|";
		return "Package ID: "+ID+d+packageName+d+packagePrice+"\nPackage includes: \n"+itemList;
	}
}
