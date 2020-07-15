
public class Star4 {

	public static void main(String[] args) {
		int num = 6;
		for (int i = 0; i < num; i++) {
			for (int j = i; j < num - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
