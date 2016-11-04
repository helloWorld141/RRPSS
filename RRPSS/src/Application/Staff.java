package Application;

public class Staff {
	private String name;
	private String gender;
	private int staffID;
	private String role;
	
	Staff(String name, String gender, int ID, String role){
		this.name = name;
		this.gender = gender;
		this.staffID = ID;
		this.role = role;
	}
	
	public String getName(){
		return this.name;
	}
	public String getGender(){
		return this.gender;
	}
	
	public int getStaffID(){
		return this.staffID;
	}
	public String getRole(){
		return this.role;
	}
}