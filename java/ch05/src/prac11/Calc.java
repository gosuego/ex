package prac11;

public abstract class Calc {
	protected int a,b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public abstract int calculate();     //추상 메소드, 서브 클래스에서 적절히 구현
}
