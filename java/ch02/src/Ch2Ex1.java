
public class Ch2Ex1 {

	public static void main(String[] args) {
		int x = 10;
		int k;
		
		++x;
		k = ++x;
		System.out.println("k =" + k + " x =" + x);
		k = x++;
		System.out.println("k =" + k + " x =" + x);
		--x;
		k = x--;
		System.out.println("k =" + k + " x =" + x);
		k = --x;
		System.out.println("k =" + k + " x =" + x);
		
	}
}
