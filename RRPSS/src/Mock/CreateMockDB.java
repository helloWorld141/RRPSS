package Mock;
import java.io.*;
import java.util.*;

import Application.*;

public class CreateMockDB {
	public static void main (String[] args){
		ArrayList<Table> tbList= new ArrayList<Table>();
		createTables(tbList);
		//System.out.println(tbList);
		List list = (ArrayList) tbList;
		writeSerializedObject("Tables.db", list);
		
	}
	public static void createTables(ArrayList<Table> tbList){
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
	
	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}