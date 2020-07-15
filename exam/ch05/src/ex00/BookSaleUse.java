package ex00;

public class BookSaleUse {
	
	public static void main(String[] args) {
		BookSale b1 = new BookSale();    // BookSale값 초기화
		b1.setBookName("Java");
		b1.setAuthor("Kim");
		b1.setPress("gelBut");
		b1.setYear(2018);
		b1.setPrice(300000);
		b1.setAmount(5);
		b1.setRank(1);
		b1.setMoney();    //계산
		b1.print();       //출력
	}

}
