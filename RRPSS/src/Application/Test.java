package Application;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
public class Test {
	public static void main (String[] args){
		System.out.println(Duration.between(LocalDateTime.of(2016, 12, 1, 1, 0), LocalDateTime.now())
				.toDays());
	}
	
	public static Table getTable(int id, ArrayList<Table> tables){
		for (Table table:tables)
			if (table.getTableID() == id) return table;
		return null;
	}
}
