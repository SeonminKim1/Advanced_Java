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
		arrlist.add("����");	arrlist.add("�μ�"); arrlist.add("��ȣ"); arrlist.add(3, "����");
		System.out.println("��̸���Ʈ�� ������� "+arrlist.size());
		System.out.println("��̸���Ʈ�� 4�̶� ���� ���� �ε�����? " + arrlist.indexOf(4));
		System.out.println("��̸���Ʈ�� 3�̶� ���� ���� �ε�����? " + arrlist.indexOf(3));
		System.out.println("��̸���Ʈ" + "�� 3���� �ε��� ����? " + arrlist.get(2));
		
		Iterator<String> it = arrlist.iterator(); // iterator �޼ҵ带 ���� it �ݺ��� ����
		System.out.print("iterator�� �̿��ؼ� ��� �� ������ -> ");
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		System.out.println();
		System.out.println("��̸���Ʈ�ǿ� 5�� ���ԵǾ��ֳ���? "+ arrlist.contains(5));
		System.out.println("�ε��� 2���� ���� ���� �Ǿ����ϴ�."); arrlist.remove(2);
		System.out.println("��ü ���� ���� �Ǿ����ϴ�. "); arrlist.clear();
	}
}
