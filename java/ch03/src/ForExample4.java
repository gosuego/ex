import java.util.Scanner;

public class ForExample4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("반복 횟수 >>");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("홍길동");
		}
		sc.close();
	}

}
