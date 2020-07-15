package ex02;
class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
}
public class ToStringEx {

	public static void main(String[] args) {
		Point p = new Point(2,3);
		System.out.println(p.toString());
		System.out.println(p);     //P는 p.toString()으로 변환
		System.out.println(p + "입니다.");    // p.toString() + "입니다"로 자동 변환
	}

}
