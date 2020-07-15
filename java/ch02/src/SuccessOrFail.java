import java.util.Scanner; 
public class SuccessOrFail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수를 입력하시오: ");
		int score = scanner.nextInt();
		if (score >= 80) 
			System.out.println("축하합니다.! 합격입니다.");
		if (score <= 79)
			System.out.println("아쉽게도 불합격입니다!");
		
		scanner.close();
	}

}
