package Xml_JaxpParse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *  dom解析 .project
 *  
 *  	DocumentBuilderFactory: 解析器工厂类
 *  	DocumentBuilder 解析器对象
 * 
 *  回写到xml 
 *		TransformerFactory 
 *      Transformer
 *
 * @author wxhl
 *
 */
public class Dom_Xml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// 取.project文件
		File pro = new File(".project");
		System.out.println(pro.getAbsolutePath());
		
		// 解析器工厂类
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 解析文档, 获取文档对象
		Document document = builder.parse(pro);
		// 获取标签
		NodeList list = document.getElementsByTagName("name");
		Node node = list.item(0);	
		System.out.println(node.getNodeName());
		// 获取标签内容
		if(node instanceof Element) {
			Element el = (Element) node;
			System.out.println(el.getTextContent());
		}
		
		// 修改标签内容
		Node item = document.getElementsByTagName("comment").item(0);
		if(item instanceof Element) {
			Element e = (Element) item;
			e.setTextContent("我在测试");
		}
		// 回写类工厂
		TransformerFactory instance = TransformerFactory.newInstance();
		// 回写类
		Transformer transformer = instance.newTransformer();
		Source xmlSource = new DOMSource(document);
		Result outputTarget = new StreamResult(pro);
		// 回写方法
		transformer.transform(xmlSource, outputTarget);
		
	}

}
