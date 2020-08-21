import java.util.Vector;

public class Ex_Vector {
	Vector<Integer> vec;
	public Ex_Vector() {
		vec = new Vector<Integer>();
		printVectormethod();
	}

	private void printVectormethod() {
		vec.add(3);	vec.add(5); vec.add(7);
		System.out.println("벡터의 사이즈는 "+vec.size());
		System.out.println("벡터중 4이란 값을 가진 인덱스는? " + vec.indexOf(4));
		System.out.println("벡터중 3이란 값을 가진 인덱스는? " + vec.indexOf(3));
		System.out.println("벡터중 3번쨰 인덱스 값은? " + vec.get(2));
		System.out.println("벡터 중간에 10이 삽입되었습니다."); vec.add(3, 10);
		System.out.print("벡터를 배열로 바꾸면? ");
		Object[] arr = vec.toArray();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("벡터에 5이 포함되어있나요? "+ vec.contains(5));
		System.out.println("벡터의 용량은? " + vec.capacity());
		System.out.println("인데스 2번쨰 값이 삭제 되었습니다."); vec.remove(2);
		System.out.println("전체 값이 삭제 되었습니다. "); vec.removeAllElements(); vec.clear();
	}	
}
