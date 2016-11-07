package Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.sound.midi.Patch;

import java.time.*;
import Helper.*;

public class Restaurant {
	private TablesManager tablesManager;
	private StaffManager staffManager;
	private OrderHistory orderHistory;
	private Menu menu;
	private Reserve reserve;

	Restaurant() throws IOException {
		tablesManager = new TablesManager();
		staffManager = new StaffManager();
		orderHistory = new OrderHistory();
		menu = new Menu();
		reserve = new Reserve();
	}

	public boolean updateMenuItem(Scanner sc) {
		try {
			menu.viewMenuItem();
		} catch (NullPointerException e) {
			System.out.println("EMPTY MENU!!!");
			return false;
		}
		String id;
		String newVal;
		System.out.println("\nChoose an action:" + "\n(1) Change item's name" + "\n(2) Change item's price"
				+ "\n(3) Change item's description" + "\n(4) Back");
		int opt = Integer.parseInt(sc.next());
		if (opt == 4)
			return false;
		System.out.println("Enter item ID:");
		id = sc.next();

		switch (opt) {
		case 1:
			System.out.println("Enter new name: ");
			newVal = sc.next();
			menu.updateItemName(id, newVal);
			break;
		case 2:
			System.out.println("Enter new price: ");
			newVal = sc.nextLine();
			menu.updateItemPrice(id, Double.parseDouble(newVal));
			break;
		case 3:
			System.out.println("Enter new description: ");
			newVal = sc.nextLine();
			menu.updateItemDescription(id, newVal);
			break;
		case 4:
			return false;
		default:
			System.out.println("Invalid choice!!!");
		}
		return true;
	}

	public int createMenuItem(Scanner sc) {
		System.out.println("Course Type :" + "\n(1) Main course" + "\n(2) Drinks" + "\n(3) Desserts" + "\n(4) Back");
		String in = sc.next();
		int type;
		try {
			type = Integer.parseInt(in);
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice!!!");
			return 5; // Ask again
		}
		if (type > 4 || type < 1) {
			System.out.println("Invalid choice!!!");
			return 5; // Ask again
		}
		if (type == 4)
			return 4;
		sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter description:");
		String description = sc.nextLine();
		System.out.println("Enter price:");
		double price = sc.nextDouble();
		menu.createMenuItem(type, name, description, price);
		return type;
	}

	public String removeMenuItem(Scanner sc) {
		try {
			menu.viewMenuItem();
		} catch (NullPointerException e) {
			System.out.println("EMPTY MENU");
			return "-1";
		}
		System.out.println("What item you want to remove (Enter -1 to go back): ");
		String id = sc.nextLine();
		menu.removeMenuItem(id);
		return id;
	}

	public void updatePromoPack(int target, int id, String newVal) {

		switch (target) {
		case 1:
			menu.updatePackageName(id, newVal);
			break;
		case 2:
			menu.updatePackagePrice(id, Double.parseDouble(newVal));
			break;
		default:
		}
	}

	public void addItemToPackage(Scanner sc) {
		System.out.println("Choose package");
		menu.viewPackages();
		int packageID = sc.nextInt();
		System.out.println("Choose items you want to add to this package (Enter -1 when you are done):");
		menu.viewMenuItem();
		ArrayList<String> itemIDs = new ArrayList<String>();
		Integer id;
		do {
			id = sc.nextInt();
			if (id != -1)
				itemIDs.add(id.toString());
		} while (id != -1);
		System.out.println("Enter new price for the package:");
		double newPrice = sc.nextDouble();
		menu.addItemsToPackage(packageID, itemIDs, newPrice);
	}

	public void removeItemFromPackage(Scanner sc) {
		System.out.println("Choose package");
		menu.viewPackages();
		int packageNo = sc.nextInt();
		System.out.println("Choose items you want to remove from this package (Enter -1 when you are done):");
		menu.viewMenuItem();
		ArrayList<String> itemIDs = new ArrayList<String>();
		Integer id;
		do {
			id = sc.nextInt();
			if (id != -1)
				itemIDs.add(id.toString());
		} while (id != -1);
		System.out.println("Enter new price for the package:");
		double newPrice = sc.nextDouble();
		menu.removeItemsFromPackage(packageNo, itemIDs, newPrice);
	}

	public void createPromoPack(Scanner sc) {
		System.out.println("Enter package name:");
		String name = sc.nextLine();
		System.out.println("Enter the price for the package");
		Double price = sc.nextDouble();
		menu.createPromotionalPackage(name, price);
	}

	public void removePromoPack(Scanner sc) {
		System.out.println("Enter the package number you want to remove:");
		menu.viewPackages();
		int packageNo = sc.nextInt();
		menu.removePromotionalPackage(packageNo);
	}

	public void createNewOrder(Scanner sc) {
		System.out.println("Enter Staff ID (Enter -1 to cancel order):");
		int staffID = -1;
		staffID = SafeInput.safeRead(staffID, sc);
		if (staffID == -1)
			return;
		while (!staffManager.isValid(staffID)) {
			System.out.println("Invalid staff ID. Try again:");
			staffID = SafeInput.safeRead(staffID, sc);
			if (staffID == -1)
				return;
		}
		int tableID = -1;
		while (!tableAvail(tableID)) {
			System.out.println("Enter available Table ID (Enter -1 to cancel order)");
			showAvailableTables();
			tableID = SafeInput.safeRead(tableID, sc);
			if (tableID == -1)
				return;
		}

		System.out.println("Choose items from a la carte (Enter 0 when you are done. Enter -1 to cancel order):");
		menu.viewMenuItem();
		ArrayList<String> itemIDs = new ArrayList<String>();
		Integer itemID = -1;
		do {
			itemID = SafeInput.safeRead(itemID, sc);
			if (itemID == -1)
				return;
			if (itemID != 0) {
				itemIDs.add(itemID.toString());
			}
		} while (itemID != 0);

		System.out.println("Choose packages from package list (Enter 0 when you are done. Enter -1 to cancel order):");
		menu.viewMenuItem();
		ArrayList<Integer> packageIDs = new ArrayList<Integer>();
		Integer packageID = -1;
		do {
			packageID = SafeInput.safeRead(packageID, sc);
			if (packageID == -1)
				return;
			if (packageID != 0) {
				packageIDs.add(packageID);
			}
		} while (packageID != 0);

		orderHistory.newOrder(staffID, tableID, itemIDs, packageIDs, menu);
		tablesManager.setStatus(tableID, TableStatus.occupied);
		System.out.println("Order has been made.");
	}

	public void viewOrder(Scanner sc) {
		System.out.println("What order (-1 to cancel)");
		orderHistory.show();
		int orderID = -1;
		orderID = SafeInput.safeRead(orderID, sc);
		if (orderID == -1)
			return;
		while(!orderHistory.isValid(orderID)){
			System.out.println("Invalid order ID. Try again:");
			orderID = SafeInput.safeRead(orderID, sc);
			if (orderID == -1)
				return;
		}
		orderHistory.viewOrder(orderID);
	}

	public void addToOrder(Scanner sc) {
		int opt = 0;
		do {
			System.out.println("Choose an option:" + "\n(1) Add items" + "\n(2) Add packages" + "\n(3) Back");
			try {
				opt = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice!!!");
			}
		} while (opt > 3 || opt < 1);
		int orderID = -1;
		try {
			System.out.println("What order?");
			orderID = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid choice");
			opt = 3; // break;
		}

		switch (opt) {
		case 1:
			System.out.println("Choose items from a la carte (Enter 0 when you are done. Enter -1 to cancel order):");
			menu.viewMenuItem();
			ArrayList<String> itemIDs = new ArrayList<String>();
			Integer itemID;
			do {
				itemID = sc.nextInt();
				if (itemID == -1)
					return;
				if (itemID != 0) {
					itemIDs.add(itemID.toString());
				}
			} while (itemID != 0);
			orderHistory.addItemsToOrder(orderID, itemIDs, menu);
			return;
		case 2:
			System.out.println(
					"Choose packages from package list (Enter 0 when you are done. Enter -1 to cancel order):");
			menu.viewMenuItem();
			ArrayList<Integer> packageIDs = new ArrayList<Integer>();
			Integer packageID;
			do {
				packageID = sc.nextInt();
				if (packageID == -1)
					return;
				if (packageID != 0) {
					packageIDs.add(packageID);
				}
			} while (packageID != 0);
			orderHistory.addPackagesToOrder(orderID, packageIDs, menu);
			return;
		case 3:
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	public void removeFromOrder(Scanner sc) {
		System.out.println("What order?");
		orderHistory.show();
		int orderID = sc.nextInt();
		System.out.println("Choose items to remove (-1 when finish):");
		orderHistory.viewOrder(orderID); // all items in orders are printed
											// according to their postion in
											// order
		// remove items by using its position in order
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int chosen = 0;
		while (chosen != -1) {
			chosen = sc.nextInt();
			if (chosen == -1)
				break;
			pos.add(chosen - 1);
		}
		orderHistory.removeFromOrder(orderID, pos);

	}

	public boolean tableAvail(int tableID) {
		return tablesManager.isAvail(tableID, reserve);
	}

	public void showAvailableTables() {
		tablesManager.showAvailableTables(reserve);
	}

	public void printOrderInvoice(Scanner sc) {
		System.out.println("What order");
		int orderID = sc.nextInt();
		orderHistory.printOrderInvoice(orderID);
		tablesManager.setStatus(orderHistory.getOrder(orderID).getTableID(), TableStatus.vacated);
	}

	public void printSaleRevenue(Scanner sc, int opt) {
		switch (opt) {
		case 1:
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			boolean flag = false;
			Date date = new Date();
			do {
				System.out.println("What date (dd-MM-yyyy). Enter -1 to go back");
				String in = sc.nextLine();
				if (in.equals("-1"))
					return;
				try {
					date = formatter.parse(in);
					flag = true;
				} catch (ParseException e) {
					System.out.println("Wrong format. Try again");
					flag = true;
				}
			} while (flag);
			orderHistory.printRevenueReport(date);
		case 2:
			System.out.println("What month (enter number):");
			Month month = Month.of(sc.nextInt());
			orderHistory.printRevenueReport(month);
		}
	}

	public void createReservation(Scanner sc) {
		System.out.println("Enter enter contact number:");
		String contact = sc.nextLine();
		System.out.println("Enter arrival time (dd/MM/yy HH:mm):");
		String arrival = sc.nextLine();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		Date arrTime = new Date();
		try {
			arrTime = formatter.parse(arrival);
		} catch (ParseException e) {
			System.out.println("Wrong format");
		}
		LocalDateTime arrivalTime = LocalDateTime.ofInstant(arrTime.toInstant(), ZoneId.systemDefault());
		System.out.println("Enter number of people:");
		int pax = sc.nextInt();
		ArrayList<Integer> reservedTables = reserve.newReservation(contact, arrivalTime, pax,
				tablesManager.getAvailTables(reserve));
		tablesManager.reserve(reservedTables);
	}

	public void checkReservation(Scanner sc) {
		System.out.println("Enter contact number used to book");
		String contact = sc.next();
		Reservation reservation = reserve.getReservation(contact);
		if (reservation == null)
			System.out.println("This number has not reserved.");
		else
			System.out.println(reservation);
	}

	public void removeReservation(Scanner sc) {
		System.out.println("Enter contact number used to book");
		String contact = sc.next();
		Reservation reservation = reserve.getReservation(contact);
		if (reservation == null)
			System.out.println("This number has not reserved.");
		else {
			ArrayList<Integer> releasedTables = reserve.removeReservation(reservation.getContact());
			tablesManager.release(releasedTables, reservation.getID());
		}
	}

	public void cleanUp() {
		orderHistory.cleanUp();
		menu.cleanUp();
		tablesManager.cleanUp();
		reserve.cleanUp();
	}
}
