<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 以超链接访问文件的方式下载 -->
	<a href="${pageContext.request.contextPath }/download/apache-tomcat-8.5.4-windows-x64.zip">apache-tomcat-8.5.4-windows-x64.zip</a>
	<br><a href="${pageContext.request.contextPath }/download/Java XML and JSON.pdf">Java XML and JSON.pdf</a>
	<br><a href="${pageContext.request.contextPath }/download/VisualSVN-Server-3.5.4-x64.msi">VisualSVN-Server-3.5.4-x64.msi</a>
	<br><a href="${pageContext.request.contextPath }/download/web-module.gif">web-module.gif</a>
	
	<!-- 访问超链接时，文件作为参数（?filename=下载文件名）的方式 -->
	<hr/>
	<br><a href="${pageContext.request.contextPath }/download?filename=download/web-module.gif">web-module.gif</a>
	<br><a href="${pageContext.request.contextPath }/download?filename=download/apache-tomcat-8.5.4-windows-x64.zip">apache-tomcat-8.5.4-windows-x64.zip</a>
	<br><a href="${pageContext.request.contextPath }/download?filename=download/Java XML and JSON.pdf">Java XML and JSON.pdf</a>
	<br><a href="${pageContext.request.contextPath }/download?filename=download/VisualSVN-Server-3.5.4-x64.msi">VisualSVN-Server-3.5.4-x64.msi</a>
</body>
</html>