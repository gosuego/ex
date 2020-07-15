
public class ArrayTest6 {

	public static void main(String[] args) {
		 int[][] array = {
				 { 10, 20, 30, 40 },
				 { 50, 60, 70, 80 },
				 {90, 100, 110, 120}
		 };
		 
		 for (int r = 0; r < array.length; r++) {
			 for(int c = 0; c < array[r].length; c++) {
				 System.out.println(r + "행" + c + "열: " + array[r][c]);
			 }
		 }
	}

}
