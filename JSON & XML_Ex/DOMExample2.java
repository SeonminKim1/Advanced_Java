import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExample2 {
	private static Logger logger = Logger.getLogger(DOMExample.class.toString());
	public static void main(String args[]) {
	/*
		DOMExample2 exam = new DOMExample2();
		Document doc = exam.parse(); // 전 단계에서 했던 XML에서 Document들 가져오기.
		
		// Tag들 가져오기. list, person, name, company의 태그들 : 가운데 내용들
		exam.printTagValue(doc,"list"); // Document객체 doc에서 태그 이름이 "list"인 노드의 CDATA 값을 화면에 출력하는 기능을 담당함.
		exam.printTagValue(doc,"person");
		exam.printTagValue(doc,"name");
		exam.printTagValue(doc,"company");
		
		// Attribute 속성값 가져오기. list, person, name, company id="1" 이런것들 가져오기.
		exam.printAttribute(doc,"list"); // Document 객체 doc에서 태그 이름이 "list"인 노드의 속성값을 화면에 출력. 속성은 name/value형식으로 여러개 지정 가능.
		exam.printAttribute(doc,"person");
		exam.printAttribute(doc,"name");
		exam.printAttribute(doc,"company");
	*/
	}
	
	public Document parse() { // xml의 document들 가져오기. rtObj로 document형 반환.
		Document rtObj = null;
		String path = "C:/Users/urse/Desktop/XMLFile.xml";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			rtObj = builder.parse(path);	
		}
		catch(ParserConfigurationException | SAXException | IOException e) {
			logger.warning("parsing error");
		}
	return rtObj;
	}

	// Tag들 가져오기. 순회를 하는데 nodeList로 순회함. nodeList중 태그값이 있는 것들이 있으면 출력.
	public void printTagValue(Document doc, String tagName) {
		NodeList nodeList = doc.getElementsByTagName(tagName);
		// getElementsByTagName 메소드는 null 객체를 반환하지 않는다.
		if(nodeList.getLength()==0) {
			System.out.println("No matched node [" + tagName + "]");
			return;
		}
		
		// tagName 매개변수와 매칭되는 노드들이 있으면 반복문을 돌며 값을 출력한다.
		for(int i=0; i<nodeList.getLength(); i++) {
			Node valueNode = nodeList.item(i).getChildNodes().item(0);
			// Tag에 값을 출력하기 위해서는 Node 타입이 Text_Node 혹은 CDATA_SECTION_NODE이어야 한다.
			if(valueNode.getNodeType()!=Node.TEXT_NODE && valueNode.getNodeType() != Node.CDATA_SECTION_NODE)continue;
			
			String value = valueNode.getNodeValue(); // 값 얻고. 양쪽 공백 없애기.
			if(value !=null)value=value.trim();
			System.out.println("Tag name : " + tagName + ", value : " + value);
		}
	}
	
	// Attribute 속성 값 가져오기. 순회를 하면서 nodeList를 순회하고, 속성 값들 가져오기.
	public void printAttribute(Document doc, String tagName1) {
		NodeList nodeList = doc.getElementsByTagName(tagName1);
		for(int i=0; i<nodeList.getLength(); i++) 
		{
			NamedNodeMap attrMap = nodeList.item(i).getAttributes();
			for(int j=0; j<attrMap.getLength(); j++) {
				Node node = attrMap.item(j);
				System.out.println("Attr name : " + node.getNodeName() + " , Attrvalue: " + node.getNodeValue());
			}
		}
	}

}
