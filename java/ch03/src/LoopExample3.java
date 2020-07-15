import java.util.Scanner;
public class LoopExample3 {

	public static void main(String[] args) {
		int n;
		int i = 1;
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하시오: ");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		do  {
			System.out.println(n + "*" + i + "=" + n * i);
			i++;
		} while (i <= 9);
		scan.close();
	}

}
