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
		Document doc = exam.parse(); // �� �ܰ迡�� �ߴ� XML���� Document�� ��������.
		
		// Tag�� ��������. list, person, name, company�� �±׵� : ��� �����
		exam.printTagValue(doc,"list"); // Document��ü doc���� �±� �̸��� "list"�� ����� CDATA ���� ȭ�鿡 ����ϴ� ����� �����.
		exam.printTagValue(doc,"person");
		exam.printTagValue(doc,"name");
		exam.printTagValue(doc,"company");
		
		// Attribute �Ӽ��� ��������. list, person, name, company id="1" �̷��͵� ��������.
		exam.printAttribute(doc,"list"); // Document ��ü doc���� �±� �̸��� "list"�� ����� �Ӽ����� ȭ�鿡 ���. �Ӽ��� name/value�������� ������ ���� ����.
		exam.printAttribute(doc,"person");
		exam.printAttribute(doc,"name");
		exam.printAttribute(doc,"company");
	*/
	}
	
	public Document parse() { // xml�� document�� ��������. rtObj�� document�� ��ȯ.
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

	// Tag�� ��������. ��ȸ�� �ϴµ� nodeList�� ��ȸ��. nodeList�� �±װ��� �ִ� �͵��� ������ ���.
	public void printTagValue(Document doc, String tagName) {
		NodeList nodeList = doc.getElementsByTagName(tagName);
		// getElementsByTagName �޼ҵ�� null ��ü�� ��ȯ���� �ʴ´�.
		if(nodeList.getLength()==0) {
			System.out.println("No matched node [" + tagName + "]");
			return;
		}
		
		// tagName �Ű������� ��Ī�Ǵ� ������ ������ �ݺ����� ���� ���� ����Ѵ�.
		for(int i=0; i<nodeList.getLength(); i++) {
			Node valueNode = nodeList.item(i).getChildNodes().item(0);
			// Tag�� ���� ����ϱ� ���ؼ��� Node Ÿ���� Text_Node Ȥ�� CDATA_SECTION_NODE�̾�� �Ѵ�.
			if(valueNode.getNodeType()!=Node.TEXT_NODE && valueNode.getNodeType() != Node.CDATA_SECTION_NODE)continue;
			
			String value = valueNode.getNodeValue(); // �� ���. ���� ���� ���ֱ�.
			if(value !=null)value=value.trim();
			System.out.println("Tag name : " + tagName + ", value : " + value);
		}
	}
	
	// Attribute �Ӽ� �� ��������. ��ȸ�� �ϸ鼭 nodeList�� ��ȸ�ϰ�, �Ӽ� ���� ��������.
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
