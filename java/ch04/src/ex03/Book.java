package ex03;

public class Book {
	String title;
	String author;
	
	public Book(String t) {
		title = t;
		author = "작자미상";
	}
	public Book(String t, String a) {
		title = t;
		author = a;
	}
	public static void main(String[] args) {
		Book littlePrince = new Book("어린왕자", "생텍쥐페리");
		Book loveStory = new Book("춘향전");
		Book funStory = new Book("김박사는 누구인가", "이기호");
		Book goodBook = new Book("제주에 혼자 살고 술은 약해요", "이원하");
		Book poetBook = new Book("내가 아니라 그가 나의 꽃", "이원하");
		Book rainBook = new Book("비오는 구덩이");
		
				
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
		System.out.println(funStory.title + " " + funStory.author);
		System.out.println(goodBook.title + " " + goodBook.author);
		System.out.println(poetBook.title + " " + poetBook.author);
		System.out.println(rainBook.title + " " + rainBook.author);
	}

}
