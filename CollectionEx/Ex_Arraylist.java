import java.util.ArrayList;
import java.util.Iterator;

public class Ex_Arraylist {
	ArrayList<String> arrlist;
	Iterator<String> it;
	public Ex_Arraylist() {
		arrlist = new ArrayList<String>();
		printArraylistmethod();
	}

	private void printArraylistmethod() {
		arrlist.add("선민");	arrlist.add("민수"); arrlist.add("강호"); arrlist.add(3, "도혁");
		System.out.println("어레이리스트의 사이즈는 "+arrlist.size());
		System.out.println("어레이리스트중 4이란 값을 가진 인덱스는? " + arrlist.indexOf(4));
		System.out.println("어레이리스트중 3이란 값을 가진 인덱스는? " + arrlist.indexOf(3));
		System.out.println("어레이리스트" + "중 3번쨰 인덱스 값은? " + arrlist.get(2));
		
		Iterator<String> it = arrlist.iterator(); // iterator 메소드를 통해 it 반복자 생성
		System.out.print("iterator를 이용해서 출력 한 값들은 -> ");
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		System.out.println();
		System.out.println("어레이리스트의에 5이 포함되어있나요? "+ arrlist.contains(5));
		System.out.println("인데스 2번쨰 값이 삭제 되었습니다."); arrlist.remove(2);
		System.out.println("전체 값이 삭제 되었습니다. "); arrlist.clear();
	}
}
