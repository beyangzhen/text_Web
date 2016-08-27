package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能: 图片验证码<br>
 * <a href="http://www.tuicool.com/articles/yyIVVrz">开挂的方式</a><br>
 * 1. 在内存里生成图（宽，高）<br>
 * 2. 取画笔<br>
 * 3. 设置颜色<br>
 * 4. 画矩形<br>
 * 5. 设置颜色<br>
 * 6. 画边框<br>
 * 7. 设置颜色<br>
 * 8. 设置字体<br>
 * 9. 输出到客户端<br>
 * 
 * ?? 添加干扰线
 */
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int width = 120;
	private int height = 38;

	public ValidateCodeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random();
		// 在内存里生成图（宽，高）
		// new BufferedImage(120, 50, BufferedImage.TYPE_INT_RGB); // Magic
		// Number 神奇的数字
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 取画笔<br>
		Graphics2D gs = (Graphics2D) image.getGraphics();
		// 设置颜色<br>
		gs.setColor(Color.gray);
		// 画矩形<br>
		gs.fillRect(0, 0, width, height);
		// 设置颜色<br>
		gs.setColor(Color.orange);
		// 画边框<br>
		gs.drawRect(0, 0, width - 1, height - 1);
		// 设置颜色<br>
		gs.setColor(Color.red);
		// 设置字体<br>
		gs.setFont(new Font("宋体", Font.BOLD, 30));

		// 随机取数字|字母
		String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int x = 20;
		int y = 30;
		for (int i = 0; i < 4; i++) {

			// 角度 30度之间
			int ar = random.nextInt(60) - 30;
			// 弧度
			double d = ar * Math.PI / 180;
			gs.rotate(d, x, y);

			int idx = random.nextInt(words.length());
			char c = words.charAt(idx);
			gs.drawString(c + "", x, y);

			gs.rotate(-d, x, y);

			x += 20;
		}
		// gs.drawString("!#Xo", 30, 30);
		// 输出到客户端<br>
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 'A'; i <= 'Z'; i++) { // char --> 65
			char a = (char) i;
			// System.out.println(a);
			sb.append(a);
		}
		String az = sb.toString();
		az += az.toLowerCase();
		for (int i = 0; i < 10; i++) {
			az += i;
		}
		System.out.println(az);
	}
}
