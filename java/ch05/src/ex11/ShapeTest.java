package ex11;

class Shape{
	protected int x,y;
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Rectangle extends Shape{
	private int width, height;
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle extends Shape {
	private int base, height;
	public void draw() {
		System.out.println("Triangle Draw");
	}
}
class Circle extends Shape{
	private int radius;
	public void draw() {
		System.out.println("Circle Draw");
	}
}
public class ShapeTest {

	public static void main(String[] args) {
		Shape b1, b2, b3, b4;
		
		b1 = new Shape();
		b2 = new Rectangle();
		b3 = new Triangle();
		b4 = new Circle();
		
		b1.draw();
		b2.draw();
		b3.draw();
		b4.draw();
		
	}

}
