import java.util.Scanner;

public class ForExample2 {

	public static void main(String[] args) {
		int n;
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하십시오");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		for (int i = 1; i <= 19; i++)
			System.out.println(n + "*" + i + "=" + n * i);
		scanner.close();

	}

}
