
public class NestedLoop {

	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 11; j++) {
				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print('\t');

			}
			System.out.println();
		}
	}

}
