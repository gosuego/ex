
public class DoWhileSample {

	public static void main(String[] args) {
		char c ='a';
		
		do {
			System.out.println(c);
			c = (char) (c + 1);
			
		} while (c <= 'z');
	}

}
