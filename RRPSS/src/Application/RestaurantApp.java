package Application;
import java.util.*;
import java.io.*;

public class RestaurantApp {
	public static void main (String[] args){
		ArrayList<Table> tbList = new ArrayList<Table>();
		tbList = (ArrayList)readSerializedObject("Tables.db");
		System.out.println(tbList);
	}
	
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}
}
