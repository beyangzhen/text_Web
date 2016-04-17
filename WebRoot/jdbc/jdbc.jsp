<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jdbc.jsp' starting page</title>
    
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
    <%@ page import="java.sql.*" %>
    <%
    	Connection conn = null;
    	Statement st = null;
    	ResultSet rs = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver"); //加载驱动
    		String url = "jdbc:mysql://localhost:3306/test";
	    	String username = "root";
	    	String pwd = "root";
	    	String sql = "select* from student";
		   	conn = DriverManager.getConnection(url, username, pwd); //连接数据库
		   	st = conn.createStatement(); //创建Statement对象
		   	rs = st.executeQuery(sql); //查询数据库并获取结果
	    	while(rs.next()) {
	    		int id = rs.getInt(1);
	    		String name = rs.getString(2);
	    		int age = rs.getInt(3);
	    		out.println(id + "&nbsp;&nbsp;&nbsp;&nbsp;" + name + "&nbsp;&nbsp;&nbsp;&nbsp;" + age + "<br>");
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
			conn.close();
			st.close();
			rs.close();    	
    	}
     %>
  </body>
</html>
