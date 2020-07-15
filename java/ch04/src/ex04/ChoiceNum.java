package ex04;

import java.util.Random;
import java.util.Scanner;

public class ChoiceNum {
	public static void main(String[] args) {
		Random rand = new Random();
		int com = rand.nextInt(100)+1;                        //0부터 100까지가 아닌 1부터 100까지의 정수로 하기 위해  +1을 한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("1부터 100까지의 숫자를 입력해보세요: ");
		int count = 0;                                        //입력하는 수를 카운트 한다. 
		while(true) {
			count++;                                          //입력받을 수록 증가하는 값
			int user = sc.nextInt();                          //입력값 초기화
			if(com==user) {                                   //랜덤한 수와 내가 입력한 수가 맞을 때
				System.out.println("맞았습니다.");
				break;
			}else if(com>user) {                              //랜덤한 수가 내가 입력한 수보다 클 때
				System.out.println("숫자를 좀 더 높게 불러보세요~");
			                                                  //	return; 나의 오답 필요 없음
			}else if(com<user) {                              // 랜덤한 수가 내가 입력한 수보다 작을 때
				System.out.println("숫자를 좀 더 낮게 불러보세요~");
			                                                  //	return; 나의 오답 필요 없음
			}
		}
		System.out.println("컴퓨터의 숫자:"+com);
		System.out.println(count+ "번만에 맞추셨습니당");
		if(count<5) {                                         //if문 중가로 꼭 열고  
			System.out.println("당신의 추측력은 최상입니다.");       //system.out.print하고
		}else if(count<10) {                                  //닫기 다시 else if 중가로 열고
			System.out.println("당신의 추측력은 훌륭합니다.");
		}else if(count<20) {
			System.out.println("끈기있는 당신이 정답입니다.");
		}else {
			System.out.println("다음번엔 더 잘할 수 있어요 ^^");
		}
		sc.close();
	}

}
