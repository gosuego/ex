import java.util.Scanner;
public class PrintAsterisk {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하시오>>");
		int n = scanner.nextInt(); 
		if (n <= 0) {
			System.out.println("0보다 커야 합니다.");
			scanner.close();
			return;
		}
		for(int a = n; a >= 0; a--) {
			for (int b = 0; b <= a; b++ ) {
				System.out.print("*");
			}
			System.out.println();
			scanner.close();
		}
	}

}
