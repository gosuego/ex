package ex01;
class Point{
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());     //obj가 가리키는 객체의 클래스 이름 출력
		System.out.println(obj.hashCode());               //obj가 가리키는 객체의 해시코드 출력
		System.out.println(obj.toString());               //obj가 가리키는 객체를 문자열로 출력
		System.out.println(obj);                          //객체 출력
	}
	
	public static void main(String[] args) {
		Point p = new Point(2,3);
		print(p);
	}
}
