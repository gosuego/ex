package prac01;

import java.util.Scanner;

public class CountingThreadConsole {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무키나 입력 >> ");
		scanner.nextLine();
		scanner.close();
		
		Thread th = new Thread(new CountingThread());
		th.start();
	}

}
class CountingThread implements Runnable{
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i =1; i<=10; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}