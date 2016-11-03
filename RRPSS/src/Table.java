
public class Table {
	private int tableID;
	private String status;
	private int seatCapacity;
	
	Table(int ID, String status, int seatCapacity){
		this.tableID = ID;
		this.status = status;
		this.seatCapacity = seatCapacity;
	}
	
	public int setTableID(){
		return this.tableID;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public int getSeatCapacity(){
		return this.seatCapacity;
	}
	
}
