import java.util.ArrayList;

public class RestaurantApp {
	public static void main (String[] args){
		MenuItem test = new MenuItem(100, "hello", "fuck you", "test");
		System.out.println(test.getName());
		
		MenuItem test2 = test;
		test2.setName("hi");
		System.out.println(test.getName());
		
		ArrayList<Integer> hi = new ArrayList<Integer>();
		for (int i =0; i< 10; i++) hi.add(i);
		System.out.println(hi.get(5));
		hi.remove(5);
		System.out.println(hi.get(5));
	}
}
