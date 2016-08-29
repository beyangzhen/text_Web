package session_shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import session_shoppingCart.DB;
import session_shoppingCart.Product;

/**
 * 功用：购物车后台
 */
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.购物车 Map<名称:String, 数量:Integer> cart ,把购物车存入session中
		 * 2.先获取购物车，
		 * 		为空：创建购物车，的商品的名称和数量加入车里, 存入session
		 * 		非空：
		 * 			有无此类商品：
		 * 				有：数量，存入session
		 * 				无：直接存入session
		 * 3.继续购物|结算
		 */
		 
		// 查询所有商品
		Collection<Product> ps = DB.getFindAll();
		response.setContentType("text/html;charset=UTF-8");
		// 显示所有商品
		PrintWriter writer = response.getWriter();
		writer.write("<ul>");
		for (Product p : ps) {
			writer.write(String.format("<li><span>%s</span><span>%s</span><a href=\"scs?id=%d\">购买</a></li>",
					p.getName(), p.getDesc(), p.getId()));
		}
		writer.write("</ul>");
		 
		// 获取用户所购买的商品编号 
		String id = request.getParameter("id");
		if (null != id && !"".equals(id)) { // 区别用户查看|还点击
			HttpSession session = request.getSession();
			String shoppingCartName = "ShoppingCart";
			// 取得session
			Map<String, Integer> shoppingCartSession = (Map<String, Integer>) session.getAttribute(shoppingCartName);
			if (shoppingCartSession == null) {
				//创建购物车，的商品的名称和数量加入车里, 存入session
				Map<String, Integer> map = new HashMap<>();
				map.put(id, 1);
				session.setAttribute(shoppingCartName, map);
			} else {
				
				//有购物车
				if (shoppingCartSession.containsKey(id)) { // 处理同类商品
					// 数量
					Integer count = shoppingCartSession.get(id);
					shoppingCartSession.put(id, count+1);
				} else { //新加商品
					// 直接存入session
					shoppingCartSession.put(id, 1);
				}
				session.setAttribute(shoppingCartName, shoppingCartSession);
			}
		}
	}

}
