<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JNDI.jsp' starting page</title>
    
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
  
  <!-- JNDI连接数据库 -->
    <!--  之前需要配置tomcat的context.xml文件，增加resourse标签 -->
    
    <%@ page import="javax.naming.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="java.sql.*" %>
    <%
      Context ctx = new InitialContext();   
      DataSource source = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
      Connection connection = source.getConnection();
      PreparedStatement pstmt = connection.prepareStatement("select * from student");
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()) {
      		System.out.print("id:" + rs.getInt(1));
      		System.out.print("\tfirstname:" + rs.getString(2));
      		System.out.print("\tlastname:" + rs.getString(3));
      		System.out.print("\tmarks:" + rs.getInt(4));
      		System.out.print("");
      }
      connection.close();
    %>
    
  </body>
</html>
