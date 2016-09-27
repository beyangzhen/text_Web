package json;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *  json：1.json对象  ：符合json格式的对象
 *	  2.json数组  ：符合json格式的数组
 *	  3.json字符串：符合json格式的字符串
 *
 *
 *   方式一：手写json：{"Name":"dd","Password":"12345","Age":18, IC:null, IQ:250}
 * 
 *   方式二：浏览器生成json：
 *	  	(1) 写个javascript对象（不带function, undefined类型）
 *			var o = {username:'dd', password:'123456', age:18, IC:null, IQ:250}
 *	        (2) 用JSON.stringify(o)格式化成JSON输出
 *		        {"username":"dd","password":"123456","age":18,"IC":null,"IQ":250}
 * 
 * /

/**
 *   方式三：java代码生成json（jackson方式）
 * /
public class JsonTest {

	// java => json[string]
	@Test
	public void java2json() throws JsonProcessingException{
		
				/* 精简方式 */
		// String json = new ObjectMapper().writeValueAsString(new Person());
		
		
				/* 详细方式 */
		// 创建ObjectMapper()对象
		ObjectMapper mapper = new ObjectMapper();
		// 对象输出字符串
		Person person = new Person();
		person.setUsername("张三丰");
		person.setNickname("小3");
		person.setAge(103);
		person.setPassword("1314250");
		String json = mapper.writeValueAsString(person);
		// OutputStream os = response.getOutputStream();
		// mapper.writeValue(os, ps); // 结果返回到输出流中
		
		System.out.println(json);
	}
	
	
	// json[string] => java 
	@Test
	public void json2java() throws JsonParseException, JsonMappingException, IOException{
		
				/* 精简方式 */
		// Person person = new ObjectMapper().readValue("{\"username\":null,\"password\":null,\"sex\":false,\"age\":20}", Person.class);
		
		
				/* 详细方式 */
		// 创建ObjectMapper对象
		ObjectMapper mapper = new ObjectMapper();
		// 使用readValue方法转成对象
		Person person = mapper.readValue("{\"age\":103,\"Name\":\"张三丰\",\"Password\":\"1314250\",\"Sex\":false}", Person.class);
		
		System.out.println(person);
	}
	
}
