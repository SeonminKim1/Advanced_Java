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
		hash.put(25,"선민"); hash.put(24,"두혁"); hash.put(22,"민수"); hash.put(10, "무민"); 
		System.out.println("해쉬맵에서 키값은 30 값은 " + hash.get(30));
		System.out.println("해쉬맵에서 키값은 22 값은 " + hash.get(22));
		System.out.println("해쉬맵에서 키값 24 를 가지고 있나? " + hash.containsKey(24));
		System.out.println("해쉬맵 사이즈 갯수 " + hash.size());
		System.out.println(hash.containsValue("민수"));
		
		// Hash자체는 순서가 없는 것이니 Set으로 바꿔서 순서만질 수 있게 함.
		Set<Integer> keys = hash.keySet();
		Iterator it = keys.iterator();
		System.out.println("해쉬안에 들어있는 멤버는 ");
		while(it.hasNext()) {
			int age = (int) it.next(); // it.next()만 하면 object 형으로 리턴 됨.
			String name = hash.get(age);
			System.out.println("나이 : "+age + ", 이름: " + name);
		}
	}
}
