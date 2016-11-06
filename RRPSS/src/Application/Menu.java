package Application;
import java.util.*;
import java.io.*;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PromotionalPackage> promotionalPackageList;
	private static TreeMap<String, ArrayList<MenuItem>> menuItemList;
	/*
	private ArrayList<MenuItem> mainCourse;
	private ArrayList<MenuItem> drinks;
	private ArrayList<MenuItem> desserts;
	*/
	Menu(){}
	
	public void updateItemName(String ID, String newName){
		int type = ID.charAt(0);
		String courseType = CourseType.values()[type-1].toString();
		for(int i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(ID)){
				menuItemList.get(courseType).get(i).setName(newName);
				break;
			}
		}
	}
	public void updateItemPrice(String ID, double newPrice){
		int type = ID.charAt(0);
		String courseType = CourseType.values()[type-1].toString();
		for(int i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(ID)){
				menuItemList.get(courseType).get(i).setPrice(newPrice);
				break;
			}
		}
	}
	public void updateItemDescription(String ID, String newDescription){
		int type = ID.charAt(0);
		String courseType = CourseType.values()[type-1].toString();
		for(int i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(ID)){
				menuItemList.get(courseType).get(i).setDescription(newDescription);
				break;
			}
		}
	}
	
	public void createMenuItem(int type, String name, String description, double price){
		CourseType courseType = CourseType.values()[type-1];
		String ID = courseType.toString();
		ID.concat(String.valueOf(menuItemList.get(type).size()));
		menuItemList.get(courseType.toString()).add(new MenuItem(ID , courseType, name, description, price));
	}
	public void removeMenuItem(String ID){
		int type = ID.charAt(0);
		int i=0;
		String courseType = CourseType.values()[type-1].toString();
		for(i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(ID)){
				menuItemList.get(courseType).remove(i);
				break;
			}
		}
		
		for (;i<menuItemList.get(courseType).size();i++){
			Integer newID = Integer.getInteger(menuItemList.get(courseType).get(i).getID())-1;
			menuItemList.get(courseType).get(i).setID(newID.toString());
		}
	}
	
	public void createPromotionalPackage(String name, double price){
		int id = promotionalPackageList.size();
		promotionalPackageList.add(new PromotionalPackage(id, name, price));
	}
	public void removePromotionalPackage(int packageNo){
		promotionalPackageList.remove(packageNo);
		for (int i=packageNo; i<promotionalPackageList.size(); i++){
			promotionalPackageList.get(i).setID(i);
		}
	}
	
	public void updatePackageName(int packageNo, String newName){
		promotionalPackageList.get(packageNo).setPackageName(newName);
	}
	public void updatePackagePrice(int packageNo, double newPrice){
		promotionalPackageList.get(packageNo).setPackagePrice(newPrice);
	}
	
	public void addItemToPackage(int packageNo, String itemID){
		int type = itemID.charAt(0);
		String courseType = CourseType.values()[type-1].toString();
		for(int i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(itemID)){
				promotionalPackageList.get(packageNo).addItem(menuItemList.get(courseType).get(i));
				break;
			}
		}
	}
	public void addItemsToPackage(int packageNo, ArrayList<String> itemIDs, double newPrice){
		for (int i=0; i<itemIDs.size(); i++){
			addItemToPackage(packageNo, itemIDs.get(i));
		}
		updatePackagePrice(packageNo, newPrice);
	}
	public void removeItemFromPackage(int packageNo, String itemID){
		promotionalPackageList.get(packageNo).removeItem(itemID);
	}
	public void removeItemsFromPackage(int packageNo, ArrayList<String> itemIDs, double newPrice){
		for (int i=0; i<itemIDs.size(); i++){
			removeItemFromPackage(packageNo, itemIDs.get(i));
		}
		updatePackagePrice(packageNo, newPrice);
	}
	
	public MenuItem getMenuItem(String itemID){
		int type = itemID.charAt(0);
		String courseType = CourseType.values()[type-1].toString();
		for(int i=0;i<menuItemList.get(courseType).size();i++){
			if (menuItemList.get(courseType).get(i).getID().equals(itemID)){
				return menuItemList.get(courseType).get(i);
			}
		}
		return null;
	}
	public PromotionalPackage getPackage(int packageNo){
		return promotionalPackageList.get(packageNo);
	}

	public void viewMenuItem(){
		//TODO
		//format output to show all MenuItems in Menu
	}
	public void viewPackages(){
		//TODO
		//print out all packages in the current menu
	}
}
