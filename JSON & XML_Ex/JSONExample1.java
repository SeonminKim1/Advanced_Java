import java.util.HashMap;
import org.json.simple.JSONObject;

// JSONObject ��ü�� ����� �����, Map ��ü�� JSON ���ڿ��� �ٲٱ�.
public class JSONExample1 {
	public static void main(String args[]) {
	/*
		JSONExample1 example = new JSONExample1();
		// JSONObject�� ���������� HashMap�� ��ӹް� �־, �� ������ Hashmap�� �����. HashMap��ü�� JSON ���ڿ��� ��ȯ�ϴ� �͵� ����.
		JSONObject obj = example.createJSONObject(); // 
		HashMap map = example.getMapObject();
		
		System.out.println("Result1 : " + obj.toJSONString()); // obj�� �־��� �͵��� json ���ڿ��� ���.
		System.out.println("Result2 : " + JSONObject.toJSONString(map)); // Hashmap�� �־��� �͵��� json ���ڿ��� ���.
	*/
	}

	// JSONObject�� ���� �ֱ�(put).
	public JSONObject createJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("Name",  "SeonminKim");
		obj.put("AGE",  new Integer(33));
		obj.put("Marriage",  new Boolean(true));
		obj.put("Location",  "SeongNam City");
		return obj;
	}

	// HashMap�� ���� �ֱ�(put).
	public HashMap getMapObject() 
	{
		HashMap map = new HashMap();
		
		map.put("URL",  "www.facebook.com");
		map.put("ID", "byungboor");
		map.put("PW","1234");
		return map;
	}
}
