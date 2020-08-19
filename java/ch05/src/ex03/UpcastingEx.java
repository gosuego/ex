package ex03;
class Person {
	String name;
	String id;
	
	public Person(String name) {
		this.name =name;
	}
}
class Student extends Person {
	String grade;
	String deppartment;
	
	public Student(String name) {
		super(name);
	}
}
public class UpcastingEx {

	public static void main(String[] args) {
		Person p;
		Student s = new Student("이재문");
		p = s;  //업캐스팅
		
		System.out.println(p.name);  //오류없음
	}

}
