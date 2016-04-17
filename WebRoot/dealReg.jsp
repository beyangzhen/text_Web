<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dealRed.jsp' starting page</title>
    
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
    <%
    	String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        
        if(username.equals("abc") && pwd.equals("123")) {
      		//转发（不再经过浏览器），处理同一个请求，url保持不变，还保留原来的request对象
      		request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
      		//重定向，处理新的请求，url变成新页面,原来的request对象没了
      		//response.sendRedirect("loginSuccess.jsp");
      	} else {
     	 	request.getRequestDispatcher("loginFail.jsp").forward(request, response);
      		//response.sendRedirect("loginFail.jsp");
     	 }
     %>
  </body>
</html>
