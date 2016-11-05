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
	public void createItem(int type, String name, String description, double price){
		CourseType courseType = CourseType.values()[type-1];
		String ID = courseType.toString();
		ID.concat(String.valueOf(menuItemList.get(type).size()));
		menuItemList.get(courseType.toString()).add(new MenuItem(ID , courseType, name, description, price));
	}
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
		promotionalPackageList.add(new PromotionalPackage(name, price));
	}
	
	public void removePromotionalPackage(int packageNo){
		promotionalPackageList.remove(packageNo);
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
	public void addItemsToPackage(int packageNo, ArrayList<String> itemIDs){
		for (int i=0; i<itemIDs.size(); i++){
			addItemToPackage(packageNo, itemIDs.get(i));
		}
	}
	public void removeItemFromPackage(int packageNo, String itemID){
		promotionalPackageList.get(packageNo).removeItem(itemID);
	}
	public void removeItemsFromPackage(int packageNo, ArrayList<String> itemIDs){
		for (int i=0; i<itemIDs.size(); i++){
			removeItemFromPackage(packageNo, itemIDs.get(i));
		}
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
}
