package prac02;
import java.util.*;
public class ArrayListScore {
	public static void main(String[] args) {
		ArrayList<Character> a = new ArrayList<Character>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for(int i = 0; i<6; i++) {
			String s = scanner.next();
			if(s.length() > 1) {
				System.out.println("Not character");
				scanner.close();
				return;
			}
			char ch = s.charAt(0);
			if((ch >= 'A' && ch <= 'D') || ch == 'F')
				a.add(ch);
			else {
				System.out.println("Invalid");
				scanner.close();
				return;
			}
		}
		double score=0.0;
		for(int i = 0; i<a.size(); i++) {
			char ch = a.get(i);
			switch(ch) {
			case 'A' : score += 4.0; break;
			case 'B' : score += 3.0; break;
			case 'C' : score += 2.0; break;
			case 'D' : score += 1.0; break;
			case 'F' : score += 0.0; break;
			}
		}
		System.out.print(score/a.size());
		scanner.close();
			}

}
