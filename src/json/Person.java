package json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** 
 *  lombok方式
 *
 */
@Data 
@JsonIgnoreProperties({"nickname","hoby"}) // 字符串 <=> java对象不对称时，忽略该组属性
public class Person {
	
	@JsonProperty("Name")
	private String username;
	
	//@JsonIgnore // 字符串 <=> java对象不对称时，忽略该属性
	private String nickname;
	
	private String password;
	
	private boolean sex;
	
	private int age;
	
}
