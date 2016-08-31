<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EL.jsp' starting page</title>
    
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
  
  <!-- requestScope,param,paramValues,pageContext -->
  
  requestScope对象:（或sessionScope）
    <%	
    	Map names = new HashMap();
    	names.put("one", "杨祯");
    	names.put("two", "李华");
    	request.setAttribute("names", names); //数据加入request域中 
    	request.setCharacterEncoding("utf-8"); //设定编码 
     %>
                姓名：${names.one}<br>
                姓名：${names["two"]}<br> 
                姓名：${requestScope.names.one}<br>           
                
  param对象:<!-- form表单中的参数  --> 
     username:${param.username}<br> <!-- 获取参数 -->
     
  paramValues对象： 
     hobby: ${paramValues.hobby[0]}${paramValues.hobby[1]}
     		${paramValues.hobby[2]}${paramValues.hobby[3]}<br>
     		
  pageContext对象:		
     <%-- 
     ${pageContext.out}
     ${pageContext.page}
     ${pageContext.request}
     ${pageContext.response}
     ${pageContext.session}
     ${pageContext.servletConfig}
     ${pageContext.ServletConnext}
     ${pageContext.exception} 
     --%>
     ${pageContext.request }<br>
     characterEncoding: ${pageContext.request.characterEncoding }<br>
     contentLength: ${pageContext.request.contentLength }<br>
     contextPath: ${pageContext.request.contextPath }<br>
     localName: ${pageContext.request.localName }<br>
     localAddr: ${pageContext.request.localAddr }<br>
     localPort: ${pageContext.request.localPort }<br>
     serverName: ${pageContext.request.serverName }<br>
     serverPort: ${pageContext.request.serverPort }<br>
     
  </body>
</html>
