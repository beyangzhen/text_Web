package upload_Download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;


@WebServlet("/uploadFile")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadFileServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置返回字符集
		response.setContentType("text/html;charset=utf-8");
		// 判断是否为标准的文件上传表单
		boolean flag = ServletFileUpload.isMultipartContent(request);
		if (flag) {
			// 创建DiskFileItemFactory（附带缓存大小，存放路径）
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); // 获取临时目录
			System.out.println("repository:" + repository.getAbsolutePath());
			DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 100, repository);
			// 创建上传工具
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			try {
				// 解析文件
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if(!item.isFormField()){
						String name = item.getName(); 		// ①获取名称（但，IE浏览器下带路径）
						name = FilenameUtils.getName(name); // ②获取名称
						// 将文件存入项目中
						String uploadPath = this.getServletContext().getRealPath("/upload");	
						IOUtils.copy(item.getInputStream(), new FileOutputStream(uploadPath + File.separator + name));
						// 删除文件（只能删除存在临时目录下的文件）
						item.delete();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			// 处理内容
		} else {
			
		}
	}

}
