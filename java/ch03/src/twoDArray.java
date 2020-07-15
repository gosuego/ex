
public class twoDArray {

	public static void main(String[] args) {
		int intArray[][] = new int[4][4];
		
		for (int i =0; i<intArray.length; i++)
			for (int j = 0; j< intArray[i].length; j++)
				intArray[i][j] = (int)(Math.random()*10+1);
		
		for (int i =0; i<intArray.length; i++) {
			for (int j = 0; j< intArray[i].length; j++)
		System.out.print(intArray[i][j] + "\t");
		System.out.println();
		}
	}

}
