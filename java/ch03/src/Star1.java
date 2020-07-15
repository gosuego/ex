import java.util.Scanner;
public class Star1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요>>");
		
		int n = sc.nextInt();
		
		for (int y =0; y<n; y++){
			for(int x = 0; x<n; x++) {
				System.out.print("*");
			}
			System.out.println("");	
		}
		sc.close();
	}

}
