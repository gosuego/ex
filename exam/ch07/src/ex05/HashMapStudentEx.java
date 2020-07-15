package ex05;
import java.util.*;
class Student{
	private int id;
	private String tel;
	public Student(int id, String tel) {this.id = id; this.tel = tel;}
	public int getId() { return id;}
	public String getTel() {return tel;}
}
public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();     //학생의 이름, Student 객체를 저장하는 해시맵 생성
		map.put("황기태", new Student(1, "010-111-1111"));
		map.put("이재문", new Student(2, "010-222-2222"));               //3명의 학생 저장
		map.put("김남윤", new Student(3, "010-333-3333"));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 이름?");
			String name = scanner.nextLine();         //사용자로부터 이름 입력
			if(name.equals("exit"))
				break;    //while 문을 벗어나 프로그램 종료
			Student student = map.get(name);  //이름에 해당하는 Student 객체 검색
			if(student == null)
				System.out.println(name + "은 없는 사람입니다.");
			else
				System.out.println("id:" + student.getId() + ", 전화:" + student.getTel());
		}
		scanner.close();
	}

}
