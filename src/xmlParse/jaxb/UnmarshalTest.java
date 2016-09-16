package xmlParse.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;


/**
 *	解组：xml生成java对象
 *
 */
public class UnmarshalTest {

	@Test
	public void test() throws JAXBException{
		// 创建JAXBContext
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		// 创建解组
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// 调用解组方法
		Customer c = (Customer)unmarshaller.unmarshal(new File("customer.xml"));
		System.out.println(c);
	}
}
