<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upLoad.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <!--   需要加载jsmartcom_zh_CN.jar包（新建的Referenced Libraries下） -->
  
    <form enctype="multipart/form-data" method="post" action="upload/uploadManager.jsp">
    	<!-- 用于选择要上传的文件 -->
    	上传文件：<input type="file" name="nfile"><br/> 
    	文件描述：<input type="text" name="explanation"><br/>
    	<!-- 跳转到相应的页面(处理) -->
    	<input type="submit" value="上传"> 
    </form>
  </body>
</html>
