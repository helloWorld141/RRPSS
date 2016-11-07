package Application;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
public class Test {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
		String in = sc.nextLine();
		Date date = new Date();
		try {
			date = formatter.parse(in);
		} catch (ParseException e){
			System.out.println("error");
		}
		System.out.println(formatter.format(date));
	}
}