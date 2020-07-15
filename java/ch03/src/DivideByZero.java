import java.util.Scanner;
public class DivideByZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend;
		int divisor;
		
		System.out.println("나뉨수를 입력하시오:");
		dividend = scanner.nextInt();
		System.out.println("나눗수를 입력하시오:");
		divisor = scanner.nextInt();
		System.out.println(dividend+"를 " + divisor + "로 나누면 몫은 " + dividend/divisor + "입니다."); //0으로 나누면 오류를 잡아냄
		scanner.close();
	}

}
