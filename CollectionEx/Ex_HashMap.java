import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Ex_HashMap {
	HashMap<Integer, String> hash;
	public Ex_HashMap() {
		hash = new HashMap<Integer,String>();
		printHashMapMethod();
	}

	private void printHashMapMethod() {
		hash.put(25,"����"); hash.put(24,"����"); hash.put(22,"�μ�"); hash.put(10, "����"); 
		System.out.println("�ؽ��ʿ��� Ű���� 30 ���� " + hash.get(30));
		System.out.println("�ؽ��ʿ��� Ű���� 22 ���� " + hash.get(22));
		System.out.println("�ؽ��ʿ��� Ű�� 24 �� ������ �ֳ�? " + hash.containsKey(24));
		System.out.println("�ؽ��� ������ ���� " + hash.size());
		System.out.println(hash.containsValue("�μ�"));
		
		// Hash��ü�� ������ ���� ���̴� Set���� �ٲ㼭 �������� �� �ְ� ��.
		Set<Integer> keys = hash.keySet();
		Iterator it = keys.iterator();
		System.out.println("�ؽ��ȿ� ����ִ� ����� ");
		while(it.hasNext()) {
			int age = (int) it.next(); // it.next()�� �ϸ� object ������ ���� ��.
			String name = hash.get(age);
			System.out.println("���� : "+age + ", �̸�: " + name);
		}
	}
}
