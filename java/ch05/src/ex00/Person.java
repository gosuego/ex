package ex00;

public class Person {
	private String name;
	private int age;
	private double height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void print() {
		System.out.println("이름\t나이\t키");
		System.out.println(name+"\t"+age + "\t" +height);
	}
	

}
