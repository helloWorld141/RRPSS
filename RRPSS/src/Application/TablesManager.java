package Application;

import java.util.*;

import Helper.IOHandler;
import Helper.TimeHandler;

import java.io.*;
import java.time.LocalDateTime;

public class TablesManager {
	private ArrayList<Table> tableList;

	public TablesManager() {
		tableList = new ArrayList<Table>();
		tableList = (ArrayList) IOHandler.readSerializedObject("Tables.db");
	}

	public ArrayList<Table> getAvailTables(Reserve reserve) {
		ArrayList<Table> availTables = new ArrayList<Table>();
		for (Table table : tableList)
			if (isAvail(table.getTableID(), reserve))
				availTables.add(table);
		return availTables;
	}

	public void showAvailableTables(Reserve reserve) {
		System.out.println(getAvailTables(reserve));
	}

	public boolean isAvail(int tableID, Reserve reserve) {
		if (tableID < 0 || tableID > 29)
			return false;
		Table table = tableList.get(tableID);
		ArrayList<Reservation> reservations = reserve.getReservations(table.getReservationIDs());
		LocalDateTime now = LocalDateTime.now();
		for (Reservation reservation : reservations) {
			if (now.toLocalDate().equals(reservation.getTime().toLocalDate()))
				if (TimeHandler.whatSession(reservation.getTime().toLocalTime())
						.equals(TimeHandler.whatSession(now.toLocalTime())))
					return false;
		}
		return tableList.get(tableID).getStatus().equals(TableStatus.vacated);
	}

	public void setStatus(int tableID, TableStatus status) {
		tableList.get(tableID).setStatus(status);
	}

	public void reserve(ArrayList<Integer> tableIDs) {
		for (int id : tableIDs) {
			setStatus(id, TableStatus.reserved);
		}
	}

	public void release(ArrayList<Integer> tableIDs, String reservationID) {
		for (int id : tableIDs) {
			setStatus(id, TableStatus.vacated);
			tableList.get(id).removeReservation(reservationID);
		}
	}

	public void cleanUp() {
		IOHandler.writeSerializedObject("Tables.db", tableList);
	}
}