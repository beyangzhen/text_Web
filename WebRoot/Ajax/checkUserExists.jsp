<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkName.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		function checkUserExists(){
		    var f = document.form1;
		    var username = f.username.value;
		    //alert(username);
		    if(username == "") {
		   		alert("用户名不能为空！");
		    	return false;
		    } else {
		    	doAjax("CheckUserServlet?username=" + username);
		    }
		}
		
		var xmlhttp;
		function doAjax(url) {
		     try{
		        if(window.XMLHttpRequest) {
		         	//IE7+, chrome, FireFox
		        	xmlhttp = new XMLHttpRequest();
		        } else {
		        	//IE6, IE5
		       		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		        }
		     } catch(e) {
		     	var messdiv = document.getElementById("mess");
		     	messdiv.innerHTML = "error on creating xmlhttp";
		     	return;
		     }
		     xmlhttp.onreadystatechange = processRequest; // 请求状态改变后，就执行处理
		     //alert(url);
		     xmlhttp.open("post", url, true);
		     xmlhttp.send();
		}
		
		function processRequest() {
		     var messdiv = document.getElementById("mess");
		     if(xmlhttp.readyState == 4) {
		     	if (xmlhttp.status == 200) {		     	
		            //alert(xmlhttp.responseText);
			    //responseText表示请求完成后，"response对象中"返回的字符串信息
			    //(如：response.getWrite().println("")的输出信息就会存入responseText中)
		            if(xmlhttp.responseText == "false") { 
		            	messdiv.innerHTML = "用户名可以使用";
		            }		               
		            else {
		                messdiv.innerHTML = "用户名已被使用";
		            }
		        } else {
		        	alert("请求处理返回的数据有错误");
		        }	             
		     } else {
		     	messdiv.innerHTML = "处理中。。。。";
		     }
		}	
	</script>	
  </head>
  
  <body>
    <form name="form1" action="" method="post">
    	用户名：<input name="username" type="text" onblur="checkUserExists()" />
    	<div id="mess" style="dispiay:inline" ></div>
    </form>           
  </body>
</html>
