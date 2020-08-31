import java.util.Vector;

import org.json.simple.JSONArray;

public class JSONExample2 {

	public static void main(String[] args) {
		/*
		JSONExample2 example2 = new JSONExample2();
		
		// JSONArray 클래스 내부를 보면 ArrayList를 상속받고 있어서 사용법이 매우 비슷함.
		JSONArray array1 = example2.createJSONArray();
		JSONArray array2 = example2.createMixedJSONArray();
		Vector vector = example2.createVector();
		
		System.out.println("Result1 : " + array1.toString());
		System.out.println("Result2 : " + array2.toString());
		System.out.println("Result3 : " + JSONArray.toJSONString(vector));
		*/
	}

	// JSONArray에 값들 넣기.
	public JSONArray createMixedJSONArray() {
		JSONExample1 exam = new JSONExample1();
		
		JSONArray array = new JSONArray();
		array.add("SEOUL");
		array.add("NEW YORK");
		array.add("KUALA LUMPUR");
		array.add(exam.createJSONObject());
		return array;
	}

	// JSONaRRAY에 값 넣는데, JSONObject 객체까지 넣음.
	public JSONArray createJSONArray() {
		JSONArray array = new JSONArray();
		array.add("Benjamin");
		array.add("Hamzani");
		array.add("Lodoss");
		return array;
	}
	
	// vector 버전 (벡터는 List의 자식 클래스니까)
	public Vector createVector() { 
		Vector vector = new Vector();
		vector.add("www.facebook.com");
		vector.add("www.daum.net");
		vector.add("www.google.co.kr");
		return vector;
	}

}
