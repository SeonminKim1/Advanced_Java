import java.util.Vector;

public class Ex_Vector {
	Vector<Integer> vec;
	public Ex_Vector() {
		vec = new Vector<Integer>();
		printVectormethod();
	}

	private void printVectormethod() {
		vec.add(3);	vec.add(5); vec.add(7);
		System.out.println("������ ������� "+vec.size());
		System.out.println("������ 4�̶� ���� ���� �ε�����? " + vec.indexOf(4));
		System.out.println("������ 3�̶� ���� ���� �ε�����? " + vec.indexOf(3));
		System.out.println("������ 3���� �ε��� ����? " + vec.get(2));
		System.out.println("���� �߰��� 10�� ���ԵǾ����ϴ�."); vec.add(3, 10);
		System.out.print("���͸� �迭�� �ٲٸ�? ");
		Object[] arr = vec.toArray();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("���Ϳ� 5�� ���ԵǾ��ֳ���? "+ vec.contains(5));
		System.out.println("������ �뷮��? " + vec.capacity());
		System.out.println("�ε��� 2���� ���� ���� �Ǿ����ϴ�."); vec.remove(2);
		System.out.println("��ü ���� ���� �Ǿ����ϴ�. "); vec.removeAllElements(); vec.clear();
	}	
}
