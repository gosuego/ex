package ex11;

class StaticSample {
	public int n;
	public void g() {
		m = 20;
	}
	public void h() {
		m = 30;
	}
	public static int m;
	public static void f() {
		m = 5;
	}

}

public class Ex {
	public static void main(String[] args) {
		StaticSample.m = 10;
		
		StaticSample s1;
		s1 = new StaticSample();
		System.out.println(s1.m);
		s1.f();                                                              //객체 레퍼런스로 static 맴버 f() 호출
		StaticSample.f();                                                    //클래스명을 이용하여 static 멤버 f() 호출
	}

}
