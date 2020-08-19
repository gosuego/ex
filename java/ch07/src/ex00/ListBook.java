package ex00;
import java.util.*;
public class ListBook {

	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		
		Book b1 = new Book();
		b1.input();
		Book b2 = new Book();
		b2.input();
		Book b3 = new Book();
		b3.input();
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		System.out.println("도서명\t출판사\t단가\t수량\t금액");
		for(int i =0; i<list.size(); i++) {
			Book b = list.get(i);
			System.out.println(b.getBookname()+"\t"+b.getPress()+"\t"+b.getPrice()+"\t"+b.getAmount()+"\t"+b.getMoney());
		}
	}

}
