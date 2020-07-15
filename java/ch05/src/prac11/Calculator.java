package prac11;
import java.util.Scanner;

class Add extends Calc{
	public int calculate() { return a+b; }
}
class Sub extends Calc{
	public int calculate() { return a-b;}
}
class Mul extends Calc{
	public int calculate() { return a*b;}
}
class Div extends Calc{
	public int calculate() {return a/b;}
}
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		char operator = scanner.next().charAt(0);
		Calc exp;
		switch (operator) {
		case'+':exp = new Add(); break;
		case'-':exp = new Sub(); break;
		case'*':exp = new Mul(); break;
		case'/':exp = new Div(); break;
		default:
			System.out.println("잘못된 연산자입니다.");
			scanner.close();
			return;
		}
		exp.setValue(a, b);
		if(exp instanceof Div && b == 0)
			System.out.println("계산할 수 없습니다.");
		else
			System.out.println(exp.calculate());
		scanner.close();
	}

}
