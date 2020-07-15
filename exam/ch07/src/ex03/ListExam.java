package ex03;
import java.util.ArrayList;
public class ListExam {

	public static void main(String[] args) {
		ArrayList<Object> list=new ArrayList<>();   //ArrayList 선언
		list.add("하나"); //리스트에 자료 추가
		list.add(2);
		list.add(5.5);
		list.add(false);
		list.add(3,4);   //3번 인덱스에 값(4) 추가
		list.remove(0);  //0번 인덱스의 값 삭제
		//리스트.size() 데이터 갯수 리스트.get(인덱스) 읽기
		for(int i =0; i<list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
	}

}
