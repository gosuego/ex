
public class RandomTen {

	public static void main(String[] args) {
		int n [] = new int [10];
		
		for (int i = 0; i<n.length; i++) {
			int r = (int)(Math.random()*10 + 1);
			n[i] = r;
		}
		int sum = 0;
		for(int i = 0; i<n.length; i++)
			sum += n[i];
		System.out.print("랜덤한 정수들: ");
		for(int i = 0; i<n.length; i++)
			System.out.print(n[i] + " ");
		System.out.println("\n평균은" + (double)sum/n.length);
	}

}
