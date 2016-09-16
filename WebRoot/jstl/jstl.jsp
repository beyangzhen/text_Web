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
  
 <!--  core标签库：使用前需要导入资源<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
 <!--  fn标签库  ：使用前需要导入资源<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> -->
 <!--  fmt标签库 ：使用前需要导入资源<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> -->
 
 
    						<!-- core标签库-->
 						
    <!-- span标签下的直接元素才会变颜色  -->
    <c:set property="name" value="yz" target="${user}"></c:set>
    
    <c:set var="example" value="${100+1 }" scope="session"></c:set>
    value: ${example }<br>
    value:<c:out value="${example }"/><br>
    <c:remove var="example"/>
    
    <c:if test="${3==3 }">
    	<!--
    	c:if的test中的只能写一个el表达式
    	    比如：${pageBean.currentPage == 1 && pageBean.totalPage == 2 }
    	-->
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
    <c:forEach begin="0" end="10" step="2"><!-- 相当于<c:forEach begin="0" end="5" step="1"> -->
    <!--
    其他属性：
	    begin(默认0)  	     ：开始索引 
	    end(默认集合最后一个元素)：结束索引	
	    step   	             ：迭代的步长
    -->
    	<c:out value="hello"></c:out>
    </c:foreach>
    
    <c:forEach var="item" items="${requestScope.list }" varStatus="status"> 
    
    	<span
    		<!-- var代表每次获取的(一组)值 -->
    		<!-- status代表索引下标 -->
    		<c:if test="${status.index%2==1 }">
    		<!--
	    	c:if的test中的只能写一个el表达式
	    	    比如：${pageBean.currentPage == 1 && pageBean.totalPage == 2 }
	    	-->
    			style="background:#ff0000"
    		</c:if>
    	>
    	${item }<br>
    	</span>
    	
    	<c:out value="${item}"></c:out>
    	<c:out value="${status.count}"></c:out> <!-- 从1开始 -->
    	<c:out value="${status.index}"></c:out> <!-- 从0开始 -->
    	<!--
    	<c:out value="${item.key}"></c:out>
    	<c:out value="${item.value}"></c:out>
    	-->
    	
    </c:forEach>
    
    <c:set var="var" value="10" scope="page"></c:set>
    <c:choose>
    	<c:when test="${var gt 10}">
    	    var &gt; 10
    	</c:when>
    	<c:when test="${var lt 10}">
    	    var &lt; 10
    	</c:when>
    	<c:otherwise>
    	    var &et; 10
    	</c:otherwise>
    </c:choose>
    
    						<!-- fn标签库 -->
    <br/>
    ${fn:trim("  hello   ")} 
    <br/>
    ${fn:toUpperCase("world")}
    
    						<!-- fmt标签库-->
    
    <%-- 有时会附带jseesionid=xxxxxx --%>
	<a href='<c:url value="login_fmt.jsp?lan=zh"></c:url>'>中文</a>
	<a href='<c:url value="login_fmt.jsp?lan=en"></c:url>'>英文</a>
	
	<%-- 根据参数设置默认语系 --%>
	<c:choose>
		<c:when test="${param.lan == 'en' }">
			<fmt:setLocale value="en"/>
		</c:when>
		<c:otherwise>
			<fmt:setLocale value="zh"/>
		</c:otherwise>
	</c:choose>
	
	<%-- 引入资源 --%>
	<fmt:setBundle basename="com.wxhledu.webapp.message" var="bundle"/>
	
	<%-- 获取资源 --%>	
	<fmt:message bundle="${bundle }" key="login.title"/>
	<form action="">
		<fmt:message bundle="${bundle }" key="login.label.name"/><input type="text" name="name"><br>
		<fmt:message bundle="${bundle }" key="login.label.password"/><input type="password" name="password"><br>
		<input type="submit" value="<fmt:message bundle="${bundle }" key="login.label.submit"/>">
	</form>
    
  </body>
</html>
