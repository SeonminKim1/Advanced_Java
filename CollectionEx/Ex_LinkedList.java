import java.util.Collections;
import java.util.LinkedList;

public class Ex_LinkedList {
	LinkedList<String> linkedlist ;
	public Ex_LinkedList() {
		linkedlist = new LinkedList<String>();
		linkedlist.add("���ܻ�");
		linkedlist.add("�ڹ�");
		linkedlist.addFirst("�����");
		linkedlist.addLast("������");
		linkedlist.add(2,"�����α׷���");
		linkedlist.add("ABC");
		
		printLinkedlistMethod();
	}
	private void printLinkedlistMethod() {
		System.out.println("�ʱ���� : " + linkedlist);
		
		// �Ϲ� ���� sort
		Collections.sort(linkedlist);
		System.out.println("���� �� ���� : " + linkedlist);

		// binarySearch�� �ϱ����� ������ ���ĵǾ��־�� ��.
		int index = Collections.binarySearch(linkedlist, "������");
		System.out.println("�������� �ε��� �˻� : " + index);

		// ������ reverse
		Collections.reverse(linkedlist);
		System.out.println("�������� ���� : " + linkedlist);
		
		// max , min �Լ�
		System.out.println("�ִ��� :" + Collections.max(linkedlist) +"     �ּڰ��� :" + Collections.min(linkedlist));
		
		// 1��1 ��ȯ swap�Լ�
		Collections.swap(linkedlist, 0,4);
		System.out.println("0��°�� 4������ �ٲ� ����� " + linkedlist);
		
		// shuffle�Լ�
		Collections.shuffle(linkedlist);
		System.out.println("�ٽ� ������ ���� �� ����� " + linkedlist);
	}
}
