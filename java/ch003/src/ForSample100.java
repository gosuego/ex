
public class ForSample100 {

	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			sum +=i;
			System.out.print(i);
			if(i<=99)
				System.out.println("+");
			else {
				System.out.print(" = ");
				System.out.println(sum);
			}
		}
	}

}
