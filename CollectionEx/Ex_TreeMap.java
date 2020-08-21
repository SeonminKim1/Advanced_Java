import java.util.Iterator;
import java.util.TreeMap;

public class Ex_TreeMap {
	TreeMap<String, String> treemap;
	public Ex_TreeMap() {
		treemap = new TreeMap();
		treemap.put("c", "10");
		treemap.put("a", "5");
		treemap.put("b", "9");
		treemap.put("k", "3");
		printTreeMapMethod();
	}
	
	private void printTreeMapMethod() {
		Iterator<String> iteratorKey = treemap.keySet().iterator();   //키값 오름차순 정렬(기본)
		while(iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			System.out.println(key+","+treemap.get(key));
		}		
	}
}
