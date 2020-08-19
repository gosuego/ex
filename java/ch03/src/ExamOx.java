
public class ExamOx {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for(int j =i; j< 5 + i; j++) {
				if(j % 2 ==0) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}

}
