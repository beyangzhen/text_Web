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
    
    <title>My JSP 'jstl.jsp' starting page</title>
    
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
  
 <!--  使用前需要导入资源<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
 <!-- span标签下的直接元素才会变颜色  -->
    <c:set var="example" value="${100+1 }" scope="session"></c:set>
    value: ${example }<br>
    value:<c:out value="${example }"/><br>
    <c:remove var="example"/>
    
    <c:if test="${3==3 }">
    <c:out value="相等"/><br>
    </c:if>
    
    <%
    	List list = new ArrayList();
    	list.add("one");
    	list.add("two");
    	list.add("three");
    	list.add("four");
    	request.setAttribute("list", list);
     %>
    <c:forEach var="item" items="${requestScope.list }" varStatus="status">
    	<span
    		<c:if test="${status.index%2==1 }">
    			style="background:#ff0000"
    		</c:if>
    	>
    	${item }<br>
    	</span>
    </c:forEach>
    
  </body>
</html>
