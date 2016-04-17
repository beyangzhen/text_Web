<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upLoadManager.jsp' starting page</title>
    
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
  
  <!-- 用到了类包中的"SmartUpload类" 和 "File类"  -->
  <!-- "①上传文件"后还需要"②存储文件" -->
  
    <%@ page import="com.jspsmart.upload.*" %>
    <%
    	System.out.println("hello==================");
    	SmartUpload su = new SmartUpload();
    	su.initialize(pageContext);
    	try {
    		su.setAllowedFilesList("gif,jpg,doc,txt"); //设置可上传文件的格式
    		//上传文件
    		su.upload(); 
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	//获取单个上传文件
    	com.jspsmart.upload.File file = su.getFiles().getFile(0);
    	//设置文件在服务器的保存位置
    	String filepath = "upload\\"; //文件保存在web项目的upload文件夹下
    	filepath += file.getFileName();
    	System.out.println(filepath);
    	//文件存储
    	file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);
    	out.println("文件上传成功！");
     %>
    
  </body>
</html>
