import java.util.Scanner;
public class UpperLower {

	public static void main(String[] args) {
		String s;
		char ch;
		int upper = 0;
		int lower = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요>> ");
		s =scan.next();
		
		for (int idx = 0; idx < s.length(); idx++) {
			ch = s.charAt(idx);
			if (ch >= 'A' && ch <= 'Z')
				upper++;
			if (ch >= 'a' && ch <= 'z')
				lower++;
		}
		System.out.println("대문자 갯수:"+upper);
		System.out.println("소문자 갯수:"+lower);
		
		scan.close();
	}

}
