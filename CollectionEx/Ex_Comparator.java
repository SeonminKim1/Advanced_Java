import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ex_Comparator {
	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
	Iterator it;
	public Ex_Comparator() {
		hashmap.put("c", 10); hashmap.put("a", 5);
		hashmap.put("b", 9); hashmap.put("k", 3);
		hashmap.put("e", 17); hashmap.put("f",3);
		printComparatorMethod();
	}
	
	public void printComparatorMethod() {
		
        System.out.println("------------ Value�� ���� ���� �� -------------");
		it = hashmap.keySet().iterator();
        while(it.hasNext()) {
        	String temp = (String)it.next();
            System.out.println(temp + " = " + hashmap.get(temp));
        }
        
		it = sortByValue(hashmap).iterator();
        System.out.println("------------ Value�� ���� ���� �� -------------");
        while(it.hasNext()) {
            String temp = (String) it.next();
            System.out.println(temp + " = " + hashmap.get(temp));
        }
	}

	// https://city7310.blog.me/220996168638 �߰���ũ
	public List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                System.out.println(v1+"��"+v2+"�� "+((Comparable) v2).compareTo(v1));
                return ((Comparable) v2).compareTo(v1);
            }
        });
        
        Collections.reverse(list); // �ּ������ ��������
        return list;
    }
}
