package Application;

import java.io.Serializable;
import java.time.Duration;
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
		System.out.println(reservations);
	}
	
	public Reservation newReservation(String contact, LocalDateTime arrival, int pax, ArrayList<Table> availTables){
		availTables.sort(Table.CompareSeatNo);
		for (Table table:availTables){
			if (pax < table.getSeatCapacity()){
				Reservation newReservation = new Reservation(contact, arrival, pax, table.getTableID());
				reservations.add(newReservation);
				return newReservation;
			}
		}
		return null;
	}
	
	public Reservation getReservation(String contact){
		for (Reservation res:reservations)
			if (res.getContact().equals(contact)){
				return res;
			}	
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
	
	public int removeReservation(String contact){
		Reservation res = null;
		for (int i =0; i<reservations.size(); i++){
			if (reservations.get(i).getContact().equals(contact)){
				res = reservations.get(i);
				reservations.remove(i);
				break;
			}
		}
		if (res==null) return -1;
		return res.getTableID();
	}
	public TreeMap<Integer, String> updateReservation(){
		TreeMap<Integer, String> tableRelease = new TreeMap<Integer, String>();
		for (int i=0;i<reservations.size();i++){
			Reservation reservation = reservations.get(i);
			if (Duration.between(reservation.getTime(), LocalDateTime.now())
					.toMinutes() >30){
				tableRelease.put(reservation.getTableID(), reservation.getID());
				reservations.remove(i);
			}
		}
		return tableRelease;
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
