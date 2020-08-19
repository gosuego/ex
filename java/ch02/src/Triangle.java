import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력하시오>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		if ((a+b)<c || (a+c)<b || (b+c)<a) // 두변의 합이 다른 한변보다 작은 경우
			System.out.println("삼각형을 만들 수 없습니다.");
		else
			System.out.println("삼각형이 됩니다");
		scanner.close();
	}

}
