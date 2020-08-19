import java.util.Scanner;

public class SeasonExSwitch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요(1~12)>>");
		int month = scanner.nextInt();
		switch(month) {
		case 1:
		case 2:
		case 12:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
		System.out.println("여름");
			break;
		case 9:
		case 10:
		case 11:
		System.out.println("가을");
			break;
			default:
				System.out.println("잘못입력");
		}
		System.out.println("계절은" + month + "입니다.");
		scanner.close();
	}

}
