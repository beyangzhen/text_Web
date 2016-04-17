<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'css.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">

  </head>
  
  <body>
  
  	<a href="#">Link me!</a>
  	
  	<h2>静夜思</h2>
  	<h3 title class="important italic">作者： 李白</h3>
  	<p class="red">床前明月光</p>  
  	<p class="blue">疑是地上霜</p>
  	<p class="red">举头望明月</p>
  	<p class="blue">低头思故乡</p>
  	
  	<table id="company">
  		<tr>
  			<td title name>联想</td>
  			<td>百度</td>
  			<td>腾讯</td>
  		</tr>
  		<tr>
  			<td>谷歌</td>
  			<td>微软</td>
  			<td>甲骨文</td>
  		</tr>
  	</table>
  	
  	<img src="CSS/look.jpg" alt="red" />
  	<img src="CSS/look.jpg" alt="blue" />
  	
  	<p str="one two">段落一</p>
  	<p str="two">段落二</p>
  	
  	<ul> 
  		<li>一</li>
  		<li>二</li>
  		<li>三</li>
  		<li>四
  			<ol>
  				<li>a</li>
  				<li>b</li>
  				<li>c</li>
  			</ol>
  		</li>
  	</ul>
  	
  	<p id="t1">这是段落，这是段落，这是段落，这是段落，这是段落，这是段落，这是段落，这是段落，这是段落
  	这是段落，这是段落，这是段落，这是段落，这是段落，这是段落。</p>
  	
  	<span>span1</span>
  	<span>sapn2</span>
  	
  	<br>
  	<div id="divs">
  	<img id="img1" src="CSS/look.jpg" width="100px" height="100px"/>
  	</div>
  	
  	<div id="bigdiv">
  		<div id="smalldiv1">1</div>
  		<div id="smalldiv2">2</div>
  		<div id="smalldiv3">3</div>
  	</div>
  	
  	<br>
  	
  	<div id="divclear">
  		<img id="img3" src="CSS/look.jpg" width="100px" height="100px">
  		<p id="p3">这是一段文字</p>
  		<div class="clear"></div>
  	</div>
  	
  	<div>this is a text</div>
  	<br>
  	<div id="head">this is head</div>
  	<ul>
  		<li><a href="#">Link one</a></li>
  		<li><a href="#">Link two</a></li>
  		<li><a href="#">Link three</a></li>
  		<li><a href="#">Link four</a></li>
		<div class="clear"></div>	
  	</ul>
  	<hr>
  	<div>
  		<div id="left">this is left this is left this is left this is left</div>
  		<div id="right">this is right this is right this is right this is right</div>
  		<div class="clear"></div>
  	</div>
  	<hr>
  	<div id="foot">this is foot</div>
  </body>
</html>
