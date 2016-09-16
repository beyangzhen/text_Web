package xmlParse.jaxb.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name = "Cust")
@XmlAccessorType(XmlAccessType.FIELD) // 表示注解可以写属性上（默认：注解写在属性的getter方法上）
//@XmlAccessorOrder()
@Data
public class Customer {

	// @XmlAttribute // 映射到xml头声明的属性上
	private int id;
	@XmlElement(name="customerName")
	private String name;
	private String phone;
	@XmlElement(name="email", required=true)
	private String email;
	private String qq;

	// @XmlElementWrapper // 在该数组或集合外部，生成包装的xml元素
	private List<Order> orders;
	
	/*
	@XmlElement(name="customerName", defaultValue="yz", required=true)
	public String getName() {
		return name;
	}
	*/

}
