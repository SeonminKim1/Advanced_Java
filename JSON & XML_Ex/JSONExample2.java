import java.util.Vector;

import org.json.simple.JSONArray;

public class JSONExample2 {

	public static void main(String[] args) {
		/*
		JSONExample2 example2 = new JSONExample2();
		
		// JSONArray Ŭ���� ���θ� ���� ArrayList�� ��ӹް� �־ ������ �ſ� �����.
		JSONArray array1 = example2.createJSONArray();
		JSONArray array2 = example2.createMixedJSONArray();
		Vector vector = example2.createVector();
		
		System.out.println("Result1 : " + array1.toString());
		System.out.println("Result2 : " + array2.toString());
		System.out.println("Result3 : " + JSONArray.toJSONString(vector));
		*/
	}

	// JSONArray�� ���� �ֱ�.
	public JSONArray createMixedJSONArray() {
		JSONExample1 exam = new JSONExample1();
		
		JSONArray array = new JSONArray();
		array.add("SEOUL");
		array.add("NEW YORK");
		array.add("KUALA LUMPUR");
		array.add(exam.createJSONObject());
		return array;
	}

	// JSONaRRAY�� �� �ִµ�, JSONObject ��ü���� ����.
	public JSONArray createJSONArray() {
		JSONArray array = new JSONArray();
		array.add("Benjamin");
		array.add("Hamzani");
		array.add("Lodoss");
		return array;
	}
	
	// vector ���� (���ʹ� List�� �ڽ� Ŭ�����ϱ�)
	public Vector createVector() { 
		Vector vector = new Vector();
		vector.add("www.facebook.com");
		vector.add("www.daum.net");
		vector.add("www.google.co.kr");
		return vector;
	}

}
