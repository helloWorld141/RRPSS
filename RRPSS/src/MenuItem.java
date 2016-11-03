
public class MenuItem {
	private double price;
	private String name;
	private String description;
	private String type;
	
	MenuItem(double price, String name, String description, String type){
		this.price = price;
		this.name = name;
		this.description = description;
		this.type = type;
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
		this.name = name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getType(){
		return this.type;
	}
}
