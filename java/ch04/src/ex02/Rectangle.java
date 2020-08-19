package ex02;

import java.util.Scanner;

public class Rectangle {
	int width;   
	int height;
	public int getArea() {
		return width*height;
	}
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();                    //객체생성
		Scanner scanner = new Scanner(System.in);            //스캐너
		System.out.print(">> ");                             //입력할 값 받기
		rect.width = scanner.nextInt();                      //길이 
 		rect.height = scanner.nextInt();                     //높이
		System.out.println("사각형의 면적은 " + rect.getArea()); //사각형의 면적 구함
		scanner.close();
	}

}
