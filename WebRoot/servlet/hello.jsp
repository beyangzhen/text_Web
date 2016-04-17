<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hello.jsp' starting page</title>
    
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
  	<!-- 
  		1.通过form表单提交，可以"调用doPost()方法或doGet()方法" （如：http://localhost:9009/text/servlet/hello.jsp）
  		2.在url中直接输入web.xml中定义的访问路径，"只能调用的是doGet()方法 "(如：http://localhost:9009/text/hello)
  	-->
    <form name="form1" method="post" action="hello">
    	<input type="submit" value="提交">
    </form>

  </body>
</html>
