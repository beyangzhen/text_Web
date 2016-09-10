package upload_Download;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


/**
 *  1.fileupload
 *  2.IOUtils工具类
 *  3.FilenameUtils工具类
 */
@WebServlet("/upload")
public class Upload1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Upload1Servlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
						/* ①字节流获取文件内容 */
		InputStream is = request.getInputStream(); // 获取上传的消息内容
		
		// 1. 普通方式
		int len;
		byte[] b = new byte[1024];
		while ((len = is.read(b )) != -1) { // 读取内容	
			System.out.println(new String(b, 0, len));
		}
		is.close();		
		
		// 2. apache commons-fileupload方式
		IOUtils.toString(is);
		IOUtils.closeQuietly(is);
		
		
					    /* ②apache commons-fileupload获取文件指定信息 和 复制文件(即：上传文件) */
		// 创建文件目录工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();		
		// 创建文件下载对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 解析request传来的内容
			List<FileItem> items = upload.parseRequest(request);
			// 遍历集合
			for (FileItem item : items) {
				String name = item.getName(); 		// 文件本身的名称（特例：IE会获取全路径）
				String contentType = item.getContentType();
				long size = item.getSize();
				String fieldName = item.getFieldName(); // 表单上取得名称
				System.out.println(String.format("name:%s, contenttype:%s, size:%d, fieldName:%s", name, contentType, size, fieldName));
				// 再把文件复制
				if(!item.isFormField()){ // 文件部分 <input type="file">					
					String uploadPath = "C:\\Users\\qinhaizong\\WXHL\\upload\\";
					// IOUtils 复制文件
					IOUtils.copy(item.getInputStream(), new FileOutputStream(uploadPath+name)); 
				} else { 				 // 正常表单内容部分 <input type="text">									
				}
				// 删除文件（只能删除存在临时目录下的文件）
				item.delete();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
						/* ①网页文件，字节流获取文件内容 */
		@Test
		public void testWithoutIOUtils() throws IOException{
			// 1. 普通方式
			InputStream in = new URL( "https://www.baidu.com/" ).openStream();
			try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			   String line;
			   while ( ( line = buf.readLine() ) != null ) {
				 System.out.println( line );
			   }
			} finally {
			   in.close();
			}
			 
			// 2. apache commons-fileupload方式
			System.out.println( IOUtils.toString( buf ) );
			IOUtils.closeQuietly(buf);
		}
		
		
					    /* ②网页文件，apache commons-fileupload复制文件(即：上传文件) */
		@Test
		public void testIOUtils() throws MalformedURLException, IOException{
			InputStream in = new URL( "http://commons.apache.org" ).openStream();
			 try {
			   // 文件的复制
			   IOUtils.copy(in, new FileOutputStream("baidu.html"));
			 } finally {
			   IOUtils.closeQuietly(in);
			 }
		}
		
		// FilenameUtils工具类
		@Test
		public void testFilenameUtils(){
			String fn = "C:\\Users\\qinhaizong\\WXHL\\2016_haizong\\workspace_std\\day20\\test\\com\\wxhledu\\cn\\io\\IOTest.java";
			//取扩展名
			String extension = FilenameUtils.getExtension(fn);
			System.out.println(extension);
			//取基名
			String BaseName = FilenameUtils.getBaseName(fn);
			System.out.println(BaseName);
			//取全名（不是全路径）
			String name = FilenameUtils.getName(fn);
			System.out.println(name);
		}
		
	}

}
