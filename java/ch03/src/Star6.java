
public class Star6 {

	public static void main(String[] args) {
		for(int a = 1; a <=5; a++) {
			for (int b = 1; b <= 5; b++) {
				if (a==b)
					System.out.print("@");
				else
					System.out.println("$");
			}
			System.out.println();
		}
	}

}
