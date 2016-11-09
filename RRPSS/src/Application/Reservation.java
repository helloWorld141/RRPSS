package Application;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Nguyen Dang Duy Nghia
 *
 */
public class Reservation implements Serializable{
	/**
	 * id of the package - auto generated using UUIDS
	 */
	private String id;
	/**
	 * the contact used to book
	 */
	private String contact;
	/**
	 * arrival time
	 */
	private LocalDateTime arrivalTime;
	/**
	 * number of people
	 */
	private int pax;
	/**
	 * the id of the table being reserved
	 */
	private int tableID;
	
	/**
	 * constructor
	 * @param contact
	 * @param arrival
	 * @param pax
	 * @param tableID
	 */
	Reservation(String contact, LocalDateTime arrival, int pax, int tableID){
		this.id = UUID.randomUUID().toString();
		this.contact = contact;
		this.arrivalTime = arrival;
		this.pax = pax;
		this.tableID = tableID;
	}
	/**
	 * get the id of this reservation
	 * @return
	 */
	public String getID(){
		return this.id;
	}
	/**
	 * set arrival time for this reservation
	 * @param arrival
	 */
	public void setTime(LocalDateTime arrival){
		this.arrivalTime = arrival;
	}
	/**
	 * get the arrival time of this reservation
	 * @return
	 */
	public LocalDateTime getTime(){
		return this.arrivalTime;
	}
	/**
	 * get the contact that is used to book
	 * @return
	 */
	public String getContact(){
		return this.contact;
	}
	/**
	 * set the contact used to book
	 * @param contact
	 */
	public void setContact(String contact){
		this.contact = contact;
	}
	/**
	 * get the table id of the table being reserved
	 * @return
	 */
	public int getTableID(){
		return this.tableID;
	}
	/**
	 * assign a table to be reserved for this reservation
	 * tableID is guaranteed to be valid
	 * @param tableID
	 */
	public void assign(int tableID){// check validity of tableID in upper layer 
		this.tableID= tableID;
	}
	
	@Override
	public String toString(){
		String d = "|";
		return contact+d+arrivalTime+d+pax;
	}
}
