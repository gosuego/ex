package ex02;

public class Book {
	private String title;
	private String isbn;
	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {         //toString값을 입력(리턴) 받아서 출력 아니면 그냥 문자열이 나옴
		return "ISBN: " + isbn + "; TITLE: " + title + ";";
	}
	public static void main(String[] args) {
		Book myBook = new Book("The Java Tutorial", "0123456");
		System.out.println(myBook);
	}

}
