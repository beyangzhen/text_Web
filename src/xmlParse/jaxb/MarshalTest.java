package xmlParse.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import xmlParse.jaxb.domain.Customer;
import xmlParse.jaxb.domain.Order;


/**
 *  jaxb可以对XML和Java对象进行相互转换
 *
 *  编组：java对象生成xml（底层：SAX实现的）
 */
public class MarshalTest {

	@Test
	public void test() throws JAXBException{
		Customer customer = new Customer();
		customer.setName("小强");
		customer.setPhone("12345678901");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("红牛", 5.0));
		orders.add(new Order("月饼", 500.0));
		customer.setOrders(orders );
		
		// 创建JAXBContext
		// JAXBContext.newInstance(customer.getClass());
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		
		// 创建解组
		Marshaller marshaller = context.createMarshaller();	
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // 是否省略xm头声明信息
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.wxhledu.cn"); // 加命名空间
		
		// 调用解组方法，输出到xml文件中
		marshaller.marshal(customer, new File("customer.xml"));
		
		// 调用解组方法，输出到输出流中
		// Writer writer = new StringWriter();
		// marshaller.marshal(customer, writer);
		// System.out.println(writer.toString());
	}
}
