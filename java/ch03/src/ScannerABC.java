import java.util.Scanner;
public class ScannerABC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("소문자 알파벳을 입력하시오");
		String s = scanner.nextLine();
		
		char c = s.charAt(0); 
		
		for (char a = c; a >= 'a'; a-- ) {
			for (char b = 0; b<=a; b++) {
			//	System.out.print(c[a][b] +"  ");
			}
			System.out.println();
			scanner.close();
		}
	}

}
