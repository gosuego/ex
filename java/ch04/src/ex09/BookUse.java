package ex09;

public class BookUse {
	public static void main(String[] args) {
		Book b1 = new Book("java", "김선생", "영진", 2018, 30000, 10);
		b1.calc();
		b1.print();
		Book b2 = new Book("김박사는 누구인가", "이기호", "마음산책", 2015, 15000, 87);
		b2.calc();
		b2.print();

		// System.out.println(b2);

	}

}
