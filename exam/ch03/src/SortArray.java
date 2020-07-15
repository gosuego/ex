import java.util.Scanner;
public class SortArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n[] = new int[5];
		
		System.out.print("정수 5개 입력>>");
		for(int i = 0; i<n.length; i++) {
			n[i] = scanner.nextInt(); //정수 읽기
			
		}
		//버블 소팅
		for(int i =0; i<n.length; i++) {
			for(int j=i; j<n.length; j++) { //버블 소팅
				if(n[i] > n[j]) {//정수 읽기
					int tmp = n[i];
				n[i]=n[j];
				n[j]=tmp;
				}
			}
			
		}
		for(int i=0; i<n.length; i++) {
			System.out.print(n[i]+" ");
		}
		scanner.close();
	}
}
