package ex07;

public class StrMethod {

	public static void main(String[] args) {
		String strl="java";
		
		strl = strl + " programming";
		System.out.println(strl);   //programming
		System.out.println(strl.length());  //16
		
		String str2 = strl.concat(" programming");   //문자 붙이기
		System.out.println(str2);   
		
		System.out.println(strl);  //v
		System.out.println(str2.charAt(2));   //5
		str2 = "java program";
		
		System.out.println(str2.indexOf("program"));
		System.out.println(str2.indexOf("오라클"));
		if(str2.indexOf("java") != -1) {
			System.out.println("찾는 내용이 있습니다.");
		}else {
			System.out.println("찾는 내용이 없습니다.");
		}
		str2 = "java program";
		
		System.out.println(str2.substring(5));
		System.out.println(str2.replace("java", "jsp"));
		System.out.println(str2);
		str2=str2.replace("java", "jsp");
		System.out.println(str2);
	}

}
