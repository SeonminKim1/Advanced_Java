import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Ex_LinkedHashMap {
	
	public Ex_LinkedHashMap() {
		LinkedHashMap<String,Integer> myList = new LinkedHashMap<String,Integer>();
		myList.put("����", 50); myList.put("��ȣ",70); myList.put("����",30); myList.put("����",40);
		
		Object str[] = myList.keySet().toArray();
		Object num[] = myList.values().toArray();
		
		for(int i=0; i<myList.size(); i++) {
			System.out.println(str[i] +"," + num[i]);
		}
	}
	
}
