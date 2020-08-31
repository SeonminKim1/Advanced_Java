import java.util.HashMap;
import org.json.simple.JSONObject;

// JSONObject 객체를 만드는 방법과, Map 객체를 JSON 문자열로 바꾸기.
public class JSONExample1 {
	public static void main(String args[]) {
	/*
		JSONExample1 example = new JSONExample1();
		// JSONObject는 내부적으로 HashMap을 상속받고 있어서, 그 사용법도 Hashmap과 비슷함. HashMap객체를 JSON 문자열로 변환하는 것도 가능.
		JSONObject obj = example.createJSONObject(); // 
		HashMap map = example.getMapObject();
		
		System.out.println("Result1 : " + obj.toJSONString()); // obj에 넣었던 것들을 json 문자열로 출력.
		System.out.println("Result2 : " + JSONObject.toJSONString(map)); // Hashmap에 넣었던 것들을 json 문자열로 출력.
	*/
	}

	// JSONObject에 값들 넣기(put).
	public JSONObject createJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("Name",  "SeonminKim");
		obj.put("AGE",  new Integer(33));
		obj.put("Marriage",  new Boolean(true));
		obj.put("Location",  "SeongNam City");
		return obj;
	}

	// HashMap에 값들 넣기(put).
	public HashMap getMapObject() 
	{
		HashMap map = new HashMap();
		
		map.put("URL",  "www.facebook.com");
		map.put("ID", "byungboor");
		map.put("PW","1234");
		return map;
	}
}
