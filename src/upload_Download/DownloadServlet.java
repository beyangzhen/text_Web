package upload_Download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/** 
 *	访问超链接时，文件作为参数（?filename=下载文件名）的方式 --> ① download.jsp中使用
 *															 	 ② 直接以url输入，带上参数?filename=下载文件名
 *
 *
 *	如果单独使用 response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
 *  --> 能将文件下载，但是一个无效的文件															 
 *
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取下载文件名（?filename=下载文件名）
		String filename = request.getParameter("filename");
		// 处理中文编码
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		// 输入流接收文件
		InputStream inputStream = this.getServletContext().getResourceAsStream(filename);
		// 设置响应头
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
		IOUtils.copy(inputStream, response.getOutputStream());
		
		inputStream.close();
		
	}

}
