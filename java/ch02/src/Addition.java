import java.util.Scanner;
public class Addition {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("두 정수를 입력하세요>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int sum = a + b;
		System.out.println(a + "+" + b + "은" + sum);
	scanner.close();
	}

}
