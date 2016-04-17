<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsList.jsp' starting page</title>
    
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
  	<%@ page import="javax.naming.*"%>
  	<%@ page import="javax.sql.*" %>
    <%@ page import="java.sql.*" %>
  	<% 	
  		/* 声明三个List数组容器 */	
  		List list1 = new ArrayList(); //商品名称
  		List list2 = new ArrayList(); //产地
  		List list3 = new ArrayList(); //价格
  		
  		/* 通过JNDI连接数据库 */
    	Context ctx = new InitialContext();
    	DataSource source = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
    	Connection connection = source.getConnection();
      	PreparedStatement pstmt = connection.prepareStatement("select * from 商品");
     	ResultSet rs = pstmt.executeQuery();
     	while(rs.next()) {
     		/* 将数据库中数据保存到List数组容器中 */
        	list1.add(rs.getString(1));
      		list2.add(rs.getString(2));
      		list3.add(rs.getInt(3));
      	}
      	/* 将List中数据加载到request对象中 */
      	request.setAttribute("list1", list1);
      	request.setAttribute("list2", list2);
      	request.setAttribute("list3", list3);
      	connection.close();
    %>
    
    <!-- 将数据库中获取的数据打印成表格 -->
    <br>第一种：<br>
    <table border="1">
    	<tr>
			<td>商品名称</td> <td>产地</td> <td>价格</td>
		</tr>
		<c:forEach var="item1" items="${requestScope.list1 }" varStatus="status">
		    <c:forEach var="item2" items="${requestScope.list2[status.index] }" >
	    		<tr><td>${item1 }</td> <td>${item2 }</td> <td>${list3[status.index] }</td></tr>		    			    						    
			</c:forEach> 	
	    </c:forEach>  
    </table>
   
   	<br>第二种：<br>
   	 商品名称&nbsp;&nbsp;产地&nbsp;&nbsp;价格<br>
    <c:forEach var="item1" items="${requestScope.list1 }" varStatus="status">   	
    	<c:forEach var="item2" items="${requestScope.list2[status.index] }" >
    		<span
    			<c:if test="${status.index%2==1 }">
    				style="background:#ff0000"
    			</c:if>
    		> 
    			${item1 }&nbsp;${item2 }&nbsp;&nbsp;${list3[status.index] }<br>
    		</span>		
    	</c:forEach>
    </c:forEach>
 
    
  </body>
</html>
