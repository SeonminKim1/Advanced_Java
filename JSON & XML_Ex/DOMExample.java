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
		try { // ������ �ִ��� ������ Ȯ��.
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
		// Document ���������� ��ȯ ��ü rtObj
		Document rtObj = null;
		
		// parameter path�� ��ȿ�� �˻�
		if(path==null||"".equals(path))
			throw new IllegalArgumentException("Parameter should not be null");
		
		// path �Ű������� �̿��� xmlFile ��ü �� ��ȿ�� �˻�
		File xmlFile = new File(path);
		if(!(xmlFile.exists() && xmlFile.isFile()))
			throw new IllegalArgumentException("Wrong paramgeter");
		
		// Dom�Ľ��� ���� �⺻ ����. �����δ� Document ��ü���� �����ڰ� �ʿ��� �����͸� ������� ������ �ʿ�. �Ʒ� 3�� �� ���.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // DocumentBuilder�� ����� ���� ���丮 Ŭ������, ���丮���� �ϳ� ����� �شٰ� ����.
		DocumentBuilder builder = factory.newDocumentBuilder(); // XML�������� DOM��ü�� ����� Parser ��ü�� �߻�ȭ�� Ŭ�����̴�. �׷��� �� ��ü�� �Ľ̰� ���õ� ���� API�� �����ϰ� �ִ�. 
		// parse() �޼ҵ尡 �Ľ��� ���.
		rtObj = builder.parse(xmlFile); // rtObj�� Document ��ü�� ��ȯ�޴´�. (xml������� ����)
		
		// ���  (1) DocumentBuilderFactory.newInstance()�� �ϳ� ����. 
		// ��� (2) newDocumentBuilder()�� Builder��ü �ϳ� �����
		// ��� (3) parse()�Լ��� ���ؼ� xml���Ͽ��� Document��ü ��ȯ����. 
		return rtObj;
	}
}