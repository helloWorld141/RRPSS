package Application;
import java.io.*;
import java.util.*;
import Application.CourseType;
public class MenuItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private CourseType type;
	private String name;
	private String description;
	private double price;	
	
	MenuItem(){};
	
	MenuItem(String ID, CourseType type, String name, String description, double price){
		this.ID = ID;
		this.price = price;
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public String getID(){
		return this.ID;
	}
	
	public void setID(String id){
		StringBuilder sb = new StringBuilder(id);
		this.ID = sb.toString();
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		StringBuilder sb = new StringBuilder(name);
		this.name = sb.toString();
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		StringBuilder sb = new StringBuilder(description);
		this.description = sb.toString();
	}
	
	public CourseType getType(){
		return this.type;
	}
}
