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
				
				// ajax()
				/*
				$.ajax({ 
					url: root+'/json', 
					type:'', // 默认: "GET"
					data: {username:'dd', password:'12345'},
					dataType:'json', // xml，html, script, json, jsonp, text
					success: function(d){
				    	console.log(d);
					},
					error: function(){
				              alert('服务有异常');
					}
				});
				*/
				
				// 发起get请求（相当于使用get()）
				$.ajax({url:root+'/json', success:function(d){
					cosnole.log(d);
				}});
				// 发起post请求
				$.ajax({url:root+'/json', type:'post', success:function(d){
					console.log(d);
				}});
				// error
				$.ajax({url:root+'/json2', type:'post', success:function(d){
					console.log(d);
				}, error: function(){
					console.log('error');
				}});
				
				
				$.ajax({url:'${pageContext.request.contextPath }/powers', type:'POST', 
					success:function(res) { // res 是json对象（数据库查询后，通过writeValue(os, obj)转成json，以相应流的形式返回json，回调函数获取该响应流中json对象）
						var table = '<table class="table table-striped table-bordered">'+ $.map(res, function(v){
							return '<tr>'+$.map(v, function(o){
								return '<td>'+o+'</td>';
							}).join(' ') + '</tr>';
						}).join(' ') + '</table>';
						$('.content').empty().append(table);
					}, error:function(){
						alert('服务有异常');
					}
				});
					
		       });
		</script>
	</body>
</html>
