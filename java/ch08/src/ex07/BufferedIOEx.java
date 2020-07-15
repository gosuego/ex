package ex07;
import java.io.*;
import java.util.Scanner;
public class BufferedIOEx {

	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\Temp\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,4);
			while ((c = fin.read()) != -1) {
				out.write(c);
			}
			new Scanner(System.in).nextLine();
			out.flush();    //강제 출력 장치
			fin.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
