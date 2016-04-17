<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
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
    	Cookie[] cs = request.getCookies();
    	for(int i=0; i<cs.length; i++) {
    		String username = request.getParameter("username");
   			Cookie c = cs[i];
   			String name = c.getName();
   			String value = c.getValue();
   			if("login".equals(name) && "success".equals(value)) {
   				out.println("欢迎" + username + "来到本网站");
   			}	
       	}	
     %>
  </body>
</html>
