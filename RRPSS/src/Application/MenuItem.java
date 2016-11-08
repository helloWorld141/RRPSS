package Application;
import java.io.*;
import java.util.*;
import Application.CourseType;
/**
 * @author Nguyen Dang Duy Nghia
 *
 */
public class MenuItem implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * ID of the item
	 */
	private String ID;
	/**
	 * type: "main" or "drinks" or "desserts"
	 */
	private CourseType type;
	/**
	 * name of the item
	 */
	private String name;
	/**
	 * description of the item
	 */
	private String description;
	/**
	 * price price of the item
	 */
	private double price;	
	
	/**
	 * constructor
	 * @param ID
	 * @param type
	 * @param name
	 * @param description
	 * @param price
	 */
	public MenuItem(String ID, CourseType type, String name, String description, double price){
		this.ID = ID;
		this.price = price;
		this.name = name;
		this.description = description;
		this.type = type;
	}
	/**
	 * get id of the item
	 * @return
	 */
	public String getID(){
		return this.ID;
	}
	/**
	 * set id of the item
	 * @param id
	 */
	public void setID(String id){
		StringBuilder sb = new StringBuilder(id);
		this.ID = sb.toString();
	}
	/**
	 * get the price of the item
	 * @return
	 */
	public double getPrice(){
		return this.price;
	}
	/**
	 * set the price of the item
	 * @param price
	 */
	public void setPrice(double price){
		this.price = price;
	}
	/**
	 * get the name of the item
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * set the name of the item
	 * @param name
	 */
	public void setName(String name){
		StringBuilder sb = new StringBuilder(name);
		this.name = sb.toString();
	}
	/**
	 * get the description of the item
	 * @return
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * set the description of the item
	 * @param description
	 */
	public void setDescription(String description){
		StringBuilder sb = new StringBuilder(description);
		this.description = sb.toString();
	}
	/**
	 * get the type of the item
	 * @return
	 */
	public CourseType getType(){
		return this.type;
	}

	@Override
	public String toString(){
		String d = "|";
		return (type+d+ID+d+name+d+description+d+price);
	}
}
