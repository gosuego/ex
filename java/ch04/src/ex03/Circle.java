package ex03;

public class Circle {
	int radius;                                //반지름
	String name;                               //이름

	public Circle() {                          //매개 변수 없는 생성자
		radius = 1; name = "";                 //필드 초기화
	}

	public Circle(int r, String n) {           // 매개 변수를 가진 생성자
		radius = r; name = n;                  // 매개 변수로 필드 초기화
	}

	public double getArea() {
		return 3.14 * radius * radius;          //반지름을 구하는 값
	}

	public static void main(String[] args) {
		Circle pizza = new Circle(10, "자바피자"); //매개 변수를 가진 생성자로 초기화 (radius = 10 name = 자바피자)

		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area); 

		Circle donut = new Circle();             //매개 변수 없는 생성자로 필드 초기화  (radius = 1 name = 도넛피자)
		donut.name = "도넛피자";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);
	}
}
