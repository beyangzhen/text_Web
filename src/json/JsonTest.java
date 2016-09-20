package json;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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
