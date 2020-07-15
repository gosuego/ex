package ex06;

public class AutBoxingUnBoxingEx {

	public static void main(String[] args) {
		int n = 10;
		Integer intObject = n;
		System.out.println("intObject = " + intObject);
		
		int m = intObject + 10;
		System.out.println("m = " + m);
	}

}
