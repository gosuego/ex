package ex10;

public class GenericMethodTest {

	public static void main(String[] args) {
		Integer[] iArray = { 10, 20, 30, 40, 50 };
		Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5,};
		Character[] cArray = { 'K', 'O', 'R', 'E', 'A'};
		
		printArray(iArray);
		printArray(dArray);
		printArray(cArray);
	}
	public static <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.printf("%s", element);
		}
		System.out.println();
	}

}
