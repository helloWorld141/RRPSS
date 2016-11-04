package Application;
//For the purpose of managing orders history and revenue report
import java.io.*;
import java.time.*;
import java.util.ArrayList;

public class OrderHistory {
	private ArrayList<Order> ordersList;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	OrderHistory() throws IOException{
		FileInputStream fi = new FileInputStream("OrderHistory.db");
		BufferedInputStream bi = new BufferedInputStream(fi);
		in = new ObjectInputStream(bi);
		//TODO read into ordersList
		in.close();
		
		FileOutputStream fo = new FileOutputStream("OrderHistory.db");
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		out = new ObjectOutputStream(bo);
		
	}
	
	public void addOder(Order order ){
		//TODO add to file
		ordersList.add(order);
	}
	
	public void printRevenueReport(Month month){
		//TODO filter orders in OrderList by its month and print to the screen
		// use Order.forReport()
	}
	
	public void printRevenueReport(LocalDate date){
		//TODO filter orders in OrderList by its date and print to the screen
		// use Order.forReport()
	}
	
	@Override
	public String toString(){
		String result = new String();
		for (Order order : ordersList)
			result.concat(order.info());
		return toString();
	}
	
	public void show(){
		System.out.println(this);
	}
}