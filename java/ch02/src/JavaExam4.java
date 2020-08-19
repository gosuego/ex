import java.util.Scanner;
public class JavaExam4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수3개를 입력하시오");
		int a = scanner.nextInt(); 
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int m = a;
	
		
		if ((a >= b && a <= c) || (a >= c && b <= a)) 
			m = a;
			
	
		else if ((b >= a && b <= c) || (b >= c && b<= a)) 
			 m = b;
		
		else if ((c >= a && c <= b) || (c >= b && c <= a)) 
			 m = c;
		
	System.out.println("3 정수의 중간값은" + m + "입니다.");
	scanner.close();
	}
	

}
