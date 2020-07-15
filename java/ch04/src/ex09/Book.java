package ex09;

public class Book {
	private String bookName;
	private String author;
	private String press;
	private int year;
	private int price;
	private int amount;
	private int money;

	public Book() {
		System.out.println("생성자 호출");
	}

	public Book(String bookName, String author, String press, int year, int price, int amount) { //생성자
		System.out.println("매개변수가 있는 생성자");
		this.bookName = bookName;
		this.author = author;
		this.press = press;
		this.year = year;
		this.price = price;
		this.amount = amount;
	
	}

	public void calc() {   //매개변수가 있는 생성자
		money = amount * price;
	}

	public void print() { // 입력값 출력
		System.out.println("도서명\t저자\t출판사\t" + "출판연도\t가격\t판매수량\t판매금액");
		System.out.println(
				bookName + "\t" + author + "\t" + press + "\t" + year + "\t" + price + "\t" + amount + "\t" + money);
	}

}
