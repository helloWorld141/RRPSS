package Application;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Helper.IOHandler;

public class Reserve implements Serializable{
	ArrayList<Reservation> reservations;
	
	public Reserve(){
		reservations = new ArrayList<Reservation>();
		reservations = (ArrayList)IOHandler.readSerializedObject("Reservations.db");
	}
	
	public ArrayList<Integer> newReservation(String contact, LocalDateTime arrival, int pax, ArrayList<Table> availTables){
		int id = reservations.size();
		Reservation newR = new Reservation(contact, arrival, pax);
		return newR.autoAssignTables(availTables);
	}
	
	public Reservation getReservation(String contact){
		for (Reservation res:reservations)
			if (res.getContact().equals(contact))
				return res;
		return null;
	}
	public void showReservation(String contact){
		System.out.println(getReservation(contact));
	}
	public ArrayList<Reservation> getReservations(ArrayList<String> ids){ 
		return (ArrayList<Reservation>)reservations.stream()
				.filter(res -> ids.contains(res.getID()))
				.collect(Collectors.toList());
	}
	public ArrayList<Integer> removeReservation(String contact){
		Reservation res = null;
		for (int i =0; i<reservations.size(); i++){
			if (reservations.get(i).getContact().equals(contact)){
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
