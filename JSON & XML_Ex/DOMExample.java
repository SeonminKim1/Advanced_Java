import java.io.File;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMExample{
	private static Logger logger = Logger.getLogger(DOMExample.class.toString());
	public static void main(String args[]) {
		/*
		DOMExample domParser = new DOMExample();
		String xmlFilePath = "C:/Users/urse/Desktop/XMLFile.xml";
		try { // 파일이 있는지 없는지 확인.
			Document domObj = domParser.getTreeObj(xmlFilePath);
		if(domObj !=null)
			logger.info("Parsing success");
		else
			logger.info("Parsing failure");
		}
		catch(Exception e) {
		logger.warning("DOM Parsing error");
		}
		*/
	}
	
	public Document getTreeObj(String path) throws Exception{
		// Document 데이터형인 반환 객체 rtObj
		Document rtObj = null;
		
		// parameter path의 유효성 검사
		if(path==null||"".equals(path))
			throw new IllegalArgumentException("Parameter should not be null");
		
		// path 매개변수를 이용한 xmlFile 객체 및 유효성 검사
		File xmlFile = new File(path);
		if(!(xmlFile.exists() && xmlFile.isFile()))
			throw new IllegalArgumentException("Wrong paramgeter");
		
		// Dom파싱의 가장 기본 구문. 실제로는 Document 객체에서 개발자가 필요한 데이터를 갖고오는 구문이 필요. 아래 3줄 꼭 명심.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // DocumentBuilder를 만들기 위한 팩토리 클래스로, 팩토리에서 하나 만들어 준다고 생각.
		DocumentBuilder builder = factory.newDocumentBuilder(); // XML문서에서 DOM객체를 만드는 Parser 객체를 추상화한 클래스이다. 그래서 이 객체는 파싱과 관련된 여러 API를 제공하고 있다. 
		// parse() 메소드가 파싱을 담당.
		rtObj = builder.parse(xmlFile); // rtObj는 Document 객체를 반환받는다. (xml문서라고 생각)
		
		// 요약  (1) DocumentBuilderFactory.newInstance()로 하나 생성. 
		// 요약 (2) newDocumentBuilder()로 Builder객체 하나 만들고
		// 요약 (3) parse()함수를 통해서 xml파일에서 Document객체 반환받음. 
		return rtObj;
	}
}