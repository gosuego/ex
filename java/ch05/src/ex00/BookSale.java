package ex00;

public class BookSale extends Book {  //extends 슈퍼클래스 불러옴
	private int amount;
	private int rank;
	private int money;
	//getter setter
	public int getAmount() { 
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setMoney() {  //계산
		money=price*amount;
		if(money > 100000) money=(int)(money*0.9);
	}
	public void print() {  //출력
		System.out.println("도서명\t출판사\t저자\t" +
	"출판년도\t단가\t판매수량\t판매금액\t판매순위");
		System.out.println(bookName + "\t" + press + "\t" + author + "\t" + year 
				+"\t" + price + "\t" + amount + "\t" + money + "\t" + rank);
	}
	
	

}
