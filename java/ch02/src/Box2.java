import java.util.Scanner;

public class Box2 {

	public static void main(String[] args) {
		double w;
		double a;
		double h;
		double area;

		Scanner input = new Scanner(System.in);

		System.out.print("사다리꼴의 윗변 길이는 무엇입니까? ");
		w = input.nextDouble();
		System.out.print("사다리꼴의 아랫변 길이는 무엇입니까? ");
		a = input.nextDouble();
		System.out.print("사다리꼴의 높이는 무엇입니까? ");
		h = input.nextDouble();
		area = (w + a) * h / 2.0;

		System.out.println("사다리꼴의 넓이는 " + area + "입니다.");
		input.close();

	}

}
