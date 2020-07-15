package ex09;

public class BoxTest {

	public static void main(String[] args) {
		Box b = new Box(20, 20, 30);
//		Box b;
//		b = new Box(20, 20, 30);
//		
		Box c = new Box (34, 2, 2);
		Box d;
		d= new Box(2, 4, 5);
		System.out.println("상자의 부피는 " + b.getVolume() + "입니다.");
		System.out.println("상자의 부피는 " + c.getVolume() + "입니다.");
		System.out.println("상자의 부피는 " + d.getVolume() + "입니다.");
	}

}
