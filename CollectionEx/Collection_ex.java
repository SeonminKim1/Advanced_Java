import java.util.TreeMap;

// Collection <E> �ؿ�
// Set<E> / List<E> / Queue<E>
// HahSet<E> / ArrayList<E>, Vector<E>, LinkedList<E> 

// Map<K,V> �ؿ�
// HashMap<K,V>

// E : elementation , T:Type , K:Key, V:Value
// iterator<E> : Vector, ArrayList, LinkedList, Set�� ���� ����Ʈ ����� �÷��ǿ��� ��Ҹ� ���������� �˻�. 
// HashMap���� Ű ������ �����ϰ� ������ TreeMap ����, �� �������� �����ϰ� ������ Comp
public class Collection_ex {
	public static void main(String[] args) {
		// 1. ����
		//System.out.println("---------- Vector Ex -------------");
		//VectorEx vectorex = new VectorEx();
		
		// 2. Arraylist : ���� �����尡 ���ٽ� ���� �� ����. ��� �ӵ����� ���鿡�� ����.
		// 3. Iterator
		//System.out.println("---------- ArrayList & Iterator Ex -------------");
		//ArraylistEx arraylistex = new ArraylistEx();
		
		// 4. HashMap : �ؽ����� ���� Ű�θ� �˻��ϹǷ� ������ �߿����� ���� �����Ϳ� ���ؼ��� ������. �ӵ� O(1)
		//System.out.println("---------- HashMap Ex -------------");
		//HashMapEx hashmapex = new HashMapEx();
		
		// 5. LinkedHashMap : ������ �Է��� ������� ��µǰ� �ϱ�. �ӵ� O(1)
		//System.out.println("---------- LinkedHashMap Ex -------------");
		//LinkedHashMapEx linkedhashmapex = new LinkedHashMapEx();
		
		// 6. TreeMap : ����������  RedBlackTree�� �����. Ű ���� ������ �������� �����Ϸ��� �Ѵٸ� treemap ���. �ӵ� O(log(n))
		//System.out.println("---------- TreeMap Ex -------------");
		//TreeMapEx treemapex = new TreeMapEx();
		
		// 7. LinkedList & Collection Ŭ������ �Լ��� �̿�
		//System.out.println("---------- LinkedList Ex & Collections Method Ex-------------");
		//LinkedListEx linkedlistex = new LinkedListEx();
		
		// 8. comparator �������� Hashmap �� ���� �����ϱ� Comparator��� ��ü ����..
		Ex_Comparator comparatorex = new Ex_Comparator(); 
	}
}

