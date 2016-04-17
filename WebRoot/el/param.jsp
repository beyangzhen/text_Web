<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'param.jsp' starting page</title>
    
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
    <form action="el/el.jsp" method="post">
    	<input type="text" name="username"><br>
    	<input type="checkbox" name="hobby" value="游泳">游泳
    	<input type="checkbox" name="hobby" value="登山">登山
    	<input type="checkbox" name="hobby" value="远足">远足
    	<input type="checkbox" name="hobby" value="打球">打球
    	
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
