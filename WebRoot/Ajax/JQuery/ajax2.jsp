<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ajax</title>
		<style type="text/css">
			
		</style>
	</head>
	<body>
		<div class="nav">
			<a class="btn">点我</a>
			<a class="btn2">点我2</a>
			<a class="btn3">点我3</a>
		</div>
		<div id="main">
			
		</div>

		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.1.0.min.js"></script>
		<script type="text/javascript">

			  $(function(){
					var root = '${pageContext.request.contextPath }'; 
					
					// $.get(root+'/json')   : Accept:*/*
					// $.getJSON(root+'/json'): Accept:application/json
					
					// getJSON()
					$.getJSON(root+'/jsonServlet', {username:'dd',password:'123456'}, function(res){
						// 参数data，作url参数
						console.log(res); // 可以直接当作javascript对象使用
					});
					
					// getScript() --> 请求一个js文件并加载运行
					$.getScript(root+'/Ajax/Jquery/resources/js/alert.js');
					
					// get() --> 返回的数据交给用户处理
					$('.btn3').on('click', function(){
						$.get(root+'/Ajax/Jquery/resources/js/persons.js', {}, function(res){
							
							var s = '<table>'
							// 第一种解法（[{},{}] ==> <table></table>）
							$.each(JSON.parse(res), function(idx,val){
								s += '<tr><td>'+val.Name+'</td><td>'+val.Password+'</td><td>'+val.Age+'</td></tr>'; // {} => <tr> <td></td> ... </tr>
							});
							
							// 第二种装逼解法
							var trs = $.map(JSON.parse(res), function(v){ // [] => []
								var tds = $.map(v,function(val){          // {} => []
									return '<td>'+val+'</td>';
								});
								return '<tr>'+tds.join(' ')+'</tr>';
							});
							
							s+=trs.join(' ');
							s+='</table>';
							$('#main').empty().append(s);
						})
					});
					
					// load() --> 加载页面到指定元素中		
					$('.btn').on('click',function(){
						$('#main').load(root+'/main.html');
					});
					$('.btn2').on('click',function(){
						$('#main').load(root+'/page2.html', {username:'dd'}, function(){
							console.log('我回来啦！');
						});
					});
					
			  });
		</script>
	</body>
</html>