import java.util.Random;

public class Prize {

	public static void main(String[] args) {
		String[] str = { "아이폰", "삼성노트북", "갤럭시노트10", "엘지 세탁기", "꽝" };
		Random rand = new Random();
		int num = rand.nextInt(5);
		System.out.println("추첨번호" + num);
		if (num == 4) {
			System.out.println("아쉽군요 깡");
		} else {
			System.out.println("축하합니다." + str[num] + "에 당첨되었습니다.");
		}
	}

}
