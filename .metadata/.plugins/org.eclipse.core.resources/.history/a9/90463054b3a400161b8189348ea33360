package Application;

import java.time.LocalDateTime;
import java.util.*;

import Helper.IOHandler;

public class Reserve {
	ArrayList<Reservation> reservations;
	
	public Reserve(){
		reservations = new ArrayList<Reservation>();
		reservations = (ArrayList)IOHandler.readSerializedObject("Reservations.db");
	}
	
	public ArrayList<Integer> newReservation(String contact, LocalDateTime arrival, int pax, ArrayList<Table> availTables){
		int id = reservations.size();
		Reservation newR = new Reservation(id, contact, arrival, pax);
		return newR.autoAssignTables(availTables);
	}
	
	public Reservation getReservation(String contact){
		for (Reservation res:reservations)
			if (res.getContact().equals(contact))
				return res;
		return null;
	}
	public void showReservation(int id){
		System.out.println(reservations.get(id));
	}
	public void showReservation(String contact){
		System.out.println(getReservation(contact));
	}
	public ArrayList<Integer> removeReservation(int id){
		Reservation res = null;
		for (int i =0; i<reservations.size(); i++){
			if (reservations.get(i).getID() == id){
				res = reservations.get(i);
				reservations.remove(i);
				break;
			}
		}
		if (res==null) return new ArrayList<Integer>();
		return res.getTableIDs();
	}
	
	@Override
	public String toString(){
		//TODO
		return new String();
	}
	public void cleanUp(){
		IOHandler.writeSerializedObject("Reservations.db", reservations);
	}
}
