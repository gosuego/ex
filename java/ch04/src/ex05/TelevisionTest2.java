package ex05;

public class TelevisionTest2 {

	public static void main(String[] args) {
		Television2 myTv = new Television2();
		myTv.channel = 7;
		myTv.volume = 10;
		myTv.onOff = true;
		myTv.print();
		
		Television2 yourTv = new Television2();
		yourTv.channel = 9;
		yourTv.volume = 12;
		yourTv.onOff = true;
		yourTv.print();
	}

}
