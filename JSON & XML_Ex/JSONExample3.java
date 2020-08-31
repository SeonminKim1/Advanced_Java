import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExample3 {
	public static void main(String args[]) {
		JSONExample3 example = new JSONExample3();
		
		// str문자열은 JSONArray 문자열 혹은 JSONObject 문자열일 수 있음.
		String str = example.getStringByJSONObject();
		Object obj = example.parseJSON(str);
		example.analysis(obj);
		System.out.println("--------------------------");
		
		str = example.getStringByJSONArray();
		obj=example.parseJSON(str);
		example.analysis(obj);
		System.out.println("--------------------------");
	}
	
	// JSONArray 객체를 만들기 위한....
	public String getStringByJSONArray() {
		JSONArray rtArray = new JSONArray();
		rtArray.add("Mongolia");
		rtArray.add("The Great Korea");
		rtArray.add("ITALY"); 
		
		return rtArray.toJSONString();
	}
	
	// JSONObject 객체를 만들기 위한....
	public String getStringByJSONObject() {
		JSONObject rtObj = new JSONObject();
		rtObj.put("Name",  "Kimseonmin");
		rtObj.put("LOCATION",  "SeongNam City");
		rtObj.put("FIELD",  "JAVA Programming");
		
		return rtObj.toJSONString();
	}
	
	// JSONParser의 parse()메소드는 어떤 형태든지 JSON문법에 맞는 문자열이면 파싱할 수 있는 기능을 제공함. 
	// 그래서 반환값도 JSONObject임 -> 함수 analysis로 어떤 형을 받았는지 체크
	public Object parseJSON(String jsonString) {
		Object rt = null;
		JSONParser parser = new JSONParser();
		try {
			rt=parser.parse(jsonString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Parsing ERROR : " + e.getStackTrace());
		}
		return rt;
	}

	// JSONParser에서 받은 객체가 어떤건지 모르니까 obj로 받고, obj 형을 찾아줌.
	public void analysis(Object obj) {
		if(obj instanceof JSONArray)
		{
			JSONArray array = (JSONArray)obj;
			Iterator iter = array.iterator();
			while(iter.hasNext()) {
				System.out.println("["+iter.next() + "]");
			}
			System.out.println("\n");
		}
		else if(obj instanceof JSONObject) {
			JSONObject jsonObj = (JSONObject) obj;
			Set keySet = jsonObj.keySet();
			for(Object key : keySet) {
				Object value = jsonObj.get(key);
				System.out.println("["+key+" / "+value+"]");
			} 
		}
		else {
			System.out.println("Can't analysis");
		}
	}
}
