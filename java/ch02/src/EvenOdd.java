import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {

		int number;

		Scanner input = new Scanner(System.in);
		System.out.print("정수를 입력하시오");
		number = input.nextInt();

		if (number % 2 == 0) {
			System.out.println(number + "은 짝수입니다.");
		}

		else {
			System.out.println(number + "은 홀수입니다.");

			System.out.println("프로그램이 종료되었습니다.");
			input.close();
		}
	}

}
