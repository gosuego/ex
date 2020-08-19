package ex06;
class Shape {
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println(name);
	}
}
public class Circle extends Shape {
	protected String name;
	
	@Override
	public void draw() {
		name = "Circle";
		super.name = "Shape";  //슈퍼 클래스 먼저 실행
		super.draw();
		System.out.println(name);
	}
	public static void main(String[] args) {
		Shape b = new Circle();
		b.paint();
	}
	

}
