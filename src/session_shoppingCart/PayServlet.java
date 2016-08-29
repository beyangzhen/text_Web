package session_shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import session_shoppingCart.DB;
import session_shoppingCart.Product;

/**
 * 功用：商品结算
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 显示用户购买的商品
		HttpSession session = request.getSession();
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("ShoppingCart");
		if (cart != null) { // 用户选购了商品
			List<Product> ps = DB.findByMap(cart);
			response.setContentType("text/html;charset=UTF-8");
			// 显示商品
			PrintWriter writer = response.getWriter();
			writer.write("<ul>");
			for (Product p : ps) {
				writer.write(String.format("<li><a href=\"#\">%s</a><span>%s</span><span></span></li>",
						p.getName(), p.getDesc()));
			}
			writer.write("</ul>");
		}
	}

}
