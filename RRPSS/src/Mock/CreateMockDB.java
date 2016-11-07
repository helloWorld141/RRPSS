package Mock;
import java.io.*;
import java.util.*;
import Helper.*;
import Application.*;
public class CreateMockDB {
	public static void main (String[] args){
		ArrayList<Table> tbList = new ArrayList<Table>();
		createMockTables(tbList); //System.out.println(tbList);
		List list1 = (ArrayList) tbList;
		IOHandler.writeSerializedObject("Tables.db", list1);
		
		ArrayList<Staff> stList = new ArrayList<Staff>();
		createMockStaff(stList); //System.out.println(stList);
		List list2 = (ArrayList) stList;
		IOHandler.writeSerializedObject("Staff.db", list2);
		
		ArrayList<Order> odList = new ArrayList<Order>();
		createMockOrders(odList);
		List list3 = (ArrayList) odList;
		IOHandler.writeSerializedObject("OrdersHistory.db", list3);
		
		ArrayList<PromotionalPackage> pkList = new ArrayList<PromotionalPackage>();
		createMockPackages(pkList);
		List list4 = (ArrayList) pkList;
		IOHandler.writeSerializedObject("PromoPackages.db", list4);
		
		ArrayList<MenuItem> itList = new ArrayList<MenuItem>();
		createMockItems(itList);
		List list5 = (ArrayList) itList;
		IOHandler.writeSerializedObject("Items.db", list5);
		
		ArrayList<Reservation> reList = new ArrayList<Reservation>();
		createMockReservations(reList);
		List list6 = (ArrayList) reList;
		IOHandler.writeSerializedObject("Reservations.db", list6);
	}
	
	public static void createMockTables(ArrayList<Table> tbList){
		int i =0;
		for (;i<5; i++){
			tbList.add(new Table(i, 10));
		}
		for (;i<10; i++){
			tbList.add(new Table(i, 8));
		}
		for (;i<20; i++){
			tbList.add(new Table(i, 4));
		}	
		for (;i<30; i++){
			tbList.add(new Table(i, 2));
		}
	}
	
	public static void createMockStaff(ArrayList<Staff> stList){
		String[] gender = {"Male", "Female"};
		Random rand = new Random();
		String[] name = {"Kyle", "Jia Jing", "Zhi Yang", "Jacq", "Akman", "Matt", "Owen", "Jude", "Harry Potter", "Mark Zuckerberg"};
		Integer i = 0;
		for (;i<10;i++){
			stList.add(new Staff(name[i],gender[rand.nextInt(2)], i, "Server"));
		}
	}
	
	public static void createMockOrders(ArrayList<Order> odList){
		
	}
	
	public static void createMockPackages(ArrayList<PromotionalPackage> pkList){
		
	}
	
	public static void createMockItems(ArrayList<MenuItem> itList){
		Integer i = 0;
		String main = "Main Course ";
		String drinks = "Drink ";
		String desserts = "Dessert ";
		for(;i<5;i++){
			itList.add(new MenuItem(
					String.valueOf(1)+i.toString(),
					CourseType.valueOf("main"),
					main + i.toString(),
					"This is "+main+i.toString(),
					100.0));
			
			itList.add(new MenuItem(
					String.valueOf(2)+i.toString(),
					CourseType.valueOf("drinks"),
					drinks + i.toString(),
					"This is "+drinks+i.toString(),
					100.0));
			
			itList.add(new MenuItem(
					String.valueOf(3)+i.toString(),
					CourseType.valueOf("desserts"),
					desserts + i.toString(),
					"This is "+desserts+i.toString(),
					100.0));
		}
	}
	
	public static void createMockReservations(ArrayList<Reservation> reList){
		
	}
}
