package ex10;

public class OrderedPairTest {

	public static void main(String[] args) {
		OderedPair<String, Integer> p1 = new OderedPair<>("mykey", 12345678);
		OderedPair<String, String> p2 = new OderedPair<>("java", "a programming");
		System.out.println(p1.getKey()+ " " + p1.getValue());
		System.out.println(p2.getKey()+ " " + p2.getValue());
	}

}
