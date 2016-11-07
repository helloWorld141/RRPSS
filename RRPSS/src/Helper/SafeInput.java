package Helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeInput {
	SafeInput(){}
	
	public static int safeRead(int in, Scanner sc){
		try {
			in = sc.nextInt();
		} catch (InputMismatchException e){
			System.out.println("Invalid input!!! Try again.");
			sc.nextLine();
			in = safeRead(in, sc);
		}
		return in;
	}
	public static double safeRead(double in, Scanner sc){
		try {
			in = sc.nextDouble();
		} catch (InputMismatchException e){
			System.out.println("Invalid input!!!");
			sc.nextLine();
			in = safeRead(in, sc);
		}
		return in;
	}
}
