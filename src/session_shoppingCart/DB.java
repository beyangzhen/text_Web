package session_shoppingCart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.tribes.util.Arrays;

public class DB {

	private static Map<Integer, Product> ps;

	static {
		ps = new HashMap<>();
		ps.put(1,new Product(1, "iphone5", "iphone5", 4500.0));
		ps.put(2,new Product(2, "iphone5s", "iphone5s", 4500.0));
		ps.put(3,new Product(3, "iphone6", "iphone6", 4500.0));
		ps.put(4,new Product(4, "iphone6 plus", "iphone6 plus", 4500.0));
		ps.put(5,new Product(5, "Mac Book", "Mac Book", 8500.0));
		ps.put(6,new Product(6, "Mac Book Pro", "Mac Book Pro", 10500.0));
	}

	public static Collection<Product> getFindAll() {
		//ps.values();
		return ps.values();
	}

	/**
	 * 按照id找到相关的商品
	 * @param value 1,2,3
	 * @return
	 */
	public static List<Product> findByIds(String value) {
		List<Product> result = new ArrayList<>(); //结果集
		if (value != null && !"".equals(value)) {
			String[] ids = value.split(",");
			System.out.println(Arrays.toString(ids));
			for (String id : ids) {
				Product product = ps.get(Integer.parseInt(id));
				if (product != null) {
					result.add(product);
				}
			}
		}
		return result;
	}

	public static List<Product> findByMap(Map<String, Integer> cart) {
		List<Product> result = new ArrayList<>(); //结果集
		for(Map.Entry<String, Integer> e: cart.entrySet()){
			String productId = e.getKey();
			Product product = ps.get(Integer.parseInt(productId));
			if (null != product) {
				result.add(product);
			}
		}
		return result;
	}

}
