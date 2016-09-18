<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>jquery</title>

		<!-- 1.引入jquery类库 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
		
		<!-- 开始入口 -->
		<script type="text/javascript">
		
			<!-- javascript方式 -->
			// 方式一
			window.onload = function(){ 			    // 只能绑定一次（第二次会事件覆盖）
				 console.log(11);
			}; 
			// 方式二
			window.addEventListener('load', function(){ // 可以绑定多个，但低版本IE不支持
				 console.log(131)
			}, true); 			
			
			<!-- jquery方式 -->
			// 普通方式
			$(document).ready(function(){
				 console.log(22);
			});	
			// 简写方式 
			$(function(){
				 console.log(33);
			});						 
			// 另一种写法
			jQuery.ready(function(){
				 console.log(55);
			});			
			// 自动执行（最先执行）
			(function(){
				console.log(44);
			})($);
				
		</script>
		
		<!-- js和jquery对象之间转化 -->
		<script type="text/javascript">		
			//js -> jquery
			var f2 = $(f1)
			//jquery -> js
			var f2 = f1[0]
		</script>
		
		<!-- 选择器 -->
		<script type="text/javascript">
		// jq --> js, var f2 = f1[0]; //javascript 文档对象dom
			<!-- 基本选择器 -->
			$(function(){
				// id选择器
				var f1 = $('#f1');
				// 标签选择器
				var labels = $('label');
				// 类选择器
				var items = $('.item');
				// 通配符选择器
				var all = $('*');
				// 多个选择器
				var a = $('#f2 .item'));			
			});
			
			<!-- 层级选择器 -->
			$(function() {	
				 // 后代选择  （所有子代）
				 $('div span').css('background', 'red');
				 // 子代选择器（第一个子代）
				 $('div>span').css('background', 'green');
				 // 紧邻选择器（第一个相邻元素）
				 $('div+span').css('background', 'yellow');
				 // 兄弟选择器（所有相邻元素）
				 $('div~span').css('background', '#3f51b5');					
			});
			
		</script>
		
	</head>
	<body>

	</body>
</html>
