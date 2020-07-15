package ex11;
class AAA{
	public AAA() {
	System.out.println("기본생성자 AAA");
	}
	public AAA(String msg) {
		System.out.println("생성자1 : " + msg);
	}
	public int abc(int x, int y) {
		return x+y;
	}
}
class BBB extends AAA{
	public BBB() {
		System.out.println("기본생성자BBB");
	}
	public BBB(String msg) {
		super("ccc");
		System.out.println("생성자2 : " + msg);
	} 
}

public class Instanance1 {

	public static void main(String[] args) {
		BBB b = new BBB();
		System.out.println("메소드 호출 : " + b.abc(3, 4) );
	}

}
