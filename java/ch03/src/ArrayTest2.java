import java.util.Scanner;
public class ArrayTest2 {

	public static void main(String[] args) {
		final int STUDENTS =5;
		int total = 0;
		Scanner scan = new Scanner(System.in);
		
		int[] scores = new int[STUDENTS];
		
		for (int i =0; i<scores.length; i++) {
			System.out.print("성적을 입력하시오: ");
			scores[i] = scan.nextInt();
		}
		for (int i = 0; i < scores.length; i++)
			total += scores[i];
		System.out.println("평균 성적은" + total / STUDENTS + "입니다");
		scan.close();
	}

}
