<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'beans.jsp' starting page</title>
    
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
  	<!-- java代码块  获取javaBean属性的方法 -->
    <%@ page import="beans.*" %>
    <%
    	Person per = new Person();
    	per.setName("abc");
    	per.setAge(11);
    	out.println("name=" + per.getName() + "<br>");
    	out.println("age=" + per.getAge() + "<br>");
     %>
     
     <!-- jsp标签  获取javaBean属性的方法 -->
     <jsp:useBean id="per2" class="beans.Person">
     	<jsp:setProperty name="per2" property="name" value="xyz"/>
     	<jsp:setProperty name="per2" property="age" value="12"/>
     </jsp:useBean>
     name=<jsp:getProperty property="name" name="per2"/><br>
     age=<jsp:getProperty property="age" name="per2"/><br>
       
  </body>
</html>
