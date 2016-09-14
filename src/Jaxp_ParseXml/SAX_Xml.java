package Xml_JaxpParse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Xml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX解析工厂 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// SAX解析器
		SAXParser parser = factory.newSAXParser();
		// 取.project文件
		File file = new File(".project");
		parser.parse(file, new DefaultHandler(){

			@Override
			public void startDocument() throws SAXException {
				System.out.println("开始处理文档");
			}

			@Override
			public void endDocument() throws SAXException {
				System.out.println("文档处理结束");
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				System.out.println("读取到标签 ："  + qName);
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("标签读取结束 ："  + qName);
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				String text = new String(ch, start, length);
				if (file != null && !"".equals(text)) {
					System.out.println("标签内的文本"+text);
				}
			}	
			
		});
	}

}
