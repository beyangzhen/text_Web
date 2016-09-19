<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ajax | XHR</title>
	</head>
	<body>
		用户名：<input type="text" name="username"><br>
		密码：<input type="password" name="password"><br>
		<button id="get">GET提交</button>
		<button id="post">POST提交</button>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.1.0.min.js"></script>	
		<script type="text/javascript" >
		
			var root = '${pageContext.request.contextPath }';

			// 1. 发起get一般请求
			$.get(root + '/event.jsp');
			
			// 2. 发起get表单请求
			$('#get').on('click', function(){
				var data = {};
				$('input').map(function(){
					data[$(this).attr('name')] = $(this).val(); // 给data对象赋值
				});
				console.log('请求的数据：', data);
				// 会自动将 "data对象" 转成 "url参数形式（username=&password=）"
				$.get(root+'/ajax', data, function(d){ // function(d)：回调函数、d：返回的数据
					console.log('返回的数据：', d);
				});
			});	
			
			// 3. 发起post表单请求
			$('#post').on('click', function(){
				var data = {};
				$('input').map(function(){
					data[$(this).attr('name')]=$(this).val(); // 给data对象赋值
				}); 
				console.log('请求的数据：', data);
				$.post(root+'/ajax', data, function(d){ // function(d)：回调函数、d：返回的数据
					console.log('返回的数据：', d);
				});
			});	
			
		</script>
		
	</body>
</html>