package ex00;
import java.util.*;
public class ListMember {

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<>();
		
		Member m1 = new Member();
		m1.setName("김철수");
		m1.setUserid("kim");
		m1.setPasswd("1234");
		m1.setTel("02-999-8888");
		m1.setEmail("kim@gmail.com");
		list.add(m1);
		
		Member m2 = new Member();
		m2.setName("홍길동");
		m2.setUserid("hong");
		m2.setPasswd("4321");
		m2.setTel("02-888-9999");
		m2.setEmail("hong@gmail.com");
		list.add(m2);
		
		Member m3 = new Member();
		m3.setName("동길홍");
		m3.setUserid("hog");
		m3.setPasswd("5521");
		m3.setTel("02-777-3333");
		m3.setEmail("hotdong@gmail.com");
		list.add(m3);
		
		System.out.println("이름\t아이디 \t비번 \t전화번호\t\t 이메일");
		for(int i = 0; i<list.size(); i++) {
			Member m= list.get(i);
			System.out.println(m.getName()+"\t"+m.getUserid()+"\t"+m.getPasswd()+"\t"+m.getTel()+"\t"+m.getEmail());
		}
		
	}

}
