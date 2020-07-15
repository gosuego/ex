package ex00;
import java.util.StringTokenizer;
public class StrToken {

	public static void main(String[] args) {
		String str = "apple,banana,grape,melon";
		String[] items = str.split(",");
		for(String s : items) {
			System.out.println(s);
		}
		
		StringTokenizer st = new StringTokenizer(str,",");
		int cnt = st.countTokens();
		System.out.println("토큰의 갯수" + cnt);
		while(st.hasMoreElements())
			System.out.println(st.nextToken());
	}

}
