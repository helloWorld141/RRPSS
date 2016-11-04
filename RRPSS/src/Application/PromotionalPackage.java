package Application;
import java.util.ArrayList;

public class PromotionalPackage {
	private double packagePrice;
	private ArrayList<MenuItem> itemList;
	private String packageName;
	
	public PromotionalPackage(double packagePrice, ArrayList<MenuItem> itemLitst, String packageName){
		this.packagePrice = packagePrice;
		this.itemList = itemLitst;
		this.packageName = packageName;
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
}
