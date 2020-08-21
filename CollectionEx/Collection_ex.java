import java.util.TreeMap;

// Collection <E> 밑에
// Set<E> / List<E> / Queue<E>
// HahSet<E> / ArrayList<E>, Vector<E>, LinkedList<E> 

// Map<K,V> 밑에
// HashMap<K,V>

// E : elementation , T:Type , K:Key, V:Value
// iterator<E> : Vector, ArrayList, LinkedList, Set과 같은 리스트 모양의 컬렉션에서 요소를 순차적으로 검색. 
// HashMap에서 키 값기준 정렬하고 싶으면 TreeMap 쓰고, 값 기준으로 정렬하고 싶으면 Comp
public class Collection_ex {
	public static void main(String[] args) {
		// 1. 벡터
		//System.out.println("---------- Vector Ex -------------");
		//VectorEx vectorex = new VectorEx();
		
		// 2. Arraylist : 여러 스레드가 접근시 꼬일 수 있음. 대신 속도적인 측면에서 빠름.
		// 3. Iterator
		//System.out.println("---------- ArrayList & Iterator Ex -------------");
		//ArraylistEx arraylistex = new ArraylistEx();
		
		// 4. HashMap : 해쉬맵은 오직 키로만 검색하므로 순서가 중요하지 않은 데이터에 대해서만 설정함. 속도 O(1)
		//System.out.println("---------- HashMap Ex -------------");
		//HashMapEx hashmapex = new HashMapEx();
		
		// 5. LinkedHashMap : 무조건 입력한 순서대로 출력되게 하기. 속도 O(1)
		//System.out.println("---------- LinkedHashMap Ex -------------");
		//LinkedHashMapEx linkedhashmapex = new LinkedHashMapEx();
		
		// 6. TreeMap : 내부적으로  RedBlackTree로 저장됨. 키 값을 일정한 기준으로 정렬하려고 한다면 treemap 사용. 속도 O(log(n))
		//System.out.println("---------- TreeMap Ex -------------");
		//TreeMapEx treemapex = new TreeMapEx();
		
		// 7. LinkedList & Collection 클래스의 함수들 이용
		//System.out.println("---------- LinkedList Ex & Collections Method Ex-------------");
		//LinkedListEx linkedlistex = new LinkedListEx();
		
		// 8. comparator 구현으로 Hashmap 값 기준 정렬하기 Comparator라는 객체 생성..
		Ex_Comparator comparatorex = new Ex_Comparator(); 
	}
}

