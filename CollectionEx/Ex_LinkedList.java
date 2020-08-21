import java.util.Collections;
import java.util.LinkedList;

public class Ex_LinkedList {
	LinkedList<String> linkedlist ;
	public Ex_LinkedList() {
		linkedlist = new LinkedList<String>();
		linkedlist.add("씨쁠쁠");
		linkedlist.add("자바");
		linkedlist.addFirst("씨언어");
		linkedlist.addLast("개발자");
		linkedlist.add(2,"웹프로그래밍");
		linkedlist.add("ABC");
		
		printLinkedlistMethod();
	}
	private void printLinkedlistMethod() {
		System.out.println("초기상태 : " + linkedlist);
		
		// 일반 정렬 sort
		Collections.sort(linkedlist);
		System.out.println("정렬 후 상태 : " + linkedlist);

		// binarySearch는 하기전에 무조건 정렬되어있어야 함.
		int index = Collections.binarySearch(linkedlist, "개발자");
		System.out.println("개발자의 인덱스 검색 : " + index);

		// 역정렬 reverse
		Collections.reverse(linkedlist);
		System.out.println("역정렬후 상태 : " + linkedlist);
		
		// max , min 함수
		System.out.println("최댓값은 :" + Collections.max(linkedlist) +"     최솟값은 :" + Collections.min(linkedlist));
		
		// 1대1 교환 swap함수
		Collections.swap(linkedlist, 0,4);
		System.out.println("0번째와 4번쨰를 바꾼 결과는 " + linkedlist);
		
		// shuffle함수
		Collections.shuffle(linkedlist);
		System.out.println("다시 순서를 섞은 후 결과는 " + linkedlist);
	}
}
