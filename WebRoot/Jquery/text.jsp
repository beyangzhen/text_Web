<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>jquery</title>

		<!-- 引入jquery类库 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
		
		
		
		<!-- js和jquery对象之间转化 -->
		<script type="text/javascript">		
			//js -> jquery
			var f2 = $(f1)
			//jquery -> js（javascript文档对象dom）
			var f2 = f1[0]
		</script>
		
		
		
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
		
		
		
		<!-- 选择器 -->
		<script type="text/javascript">

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
			
			
			<!-- 基本筛选器 -->
			$(function() {
				// 第一个
				$('div:first').css('backgroundColor', 'yellow');
				// 最后一个
				$('div:last').css('backgroundColor', '#ffe082');
				// not(selector) $("input:not(:checked)") 没有
				// 奇数
				$('div:even').css('backgroundColor', '#e91e63');
				// 偶数
				$('div:odd').css('backgroundColor', '#66bb6a');
				// equal（从0开始）
				$('div:eq(2)').css('backgroundColor', '#03a9f4');
				// greater than
				$('div:gt(2)').css('backgroundColor', '#fff176');
				// less than
				$('div:lt(2)').css('backgroundColor', '#3949ab');				
			});
			
			
			<!-- 内容筛选器 -->
			$(function() {
				// 包含文本
				$('div:contains(\'b\')').css('backgroundColor', '#bf360c');
				// 内容为空（标签内没有文本、没有包含标签）
				$('div:empty').css('backgroundColor', '#009688');
				// 该元素含有子元素或文本
				$('div:parent').css('backgroundColor', '#9e9e9e');
				// 包含标签
				$('div:has(label)').css('backgroundColor', '#9c27b0');
			}
			
			
			<!-- 可见性选择器 -->
			$(function() {
				// 可看见的标签
				$('div:visible').css('backgroundColor', '#f44336');
				// 隐藏的标签（如：div为空的标签）
				$('div:hidden').css('backgroundColor', '#cddc39').show();
			}
			
			
			<!-- 属性选择器 -->
			$(function() {
				// 属性选择器
				$('[title]').css('backgroundColor', 'red');
				// 属性值等于
				$('[id="d"]').css('backgroundColor', '#ff5722').show();
				// 属性值不等于
				$('span[title!="2b"]').css('backgroundColor', '#f0f4c3');
				// 属性值以什么开头
				$('[title^="我"]').css('backgroundColor', '#2196f3');
				// 属性值以什么结束
				$('[title$="提示"]').css('backgroundColor', '#e91e63');
				// 属性值包含字符元素
				$('[title*="b"]').css('backgroundColor', '#00bcd4');
				// 多个属性一起使用
				$('[id][style]').css('backgroundColor', '#3f51b5');	
			});
			
			
			<!-- 子元素选择器 -->
			$(function() {
				// 第一个子元素
				$('span:first-child').css('backgroundColor', '#03a9f4');
				// 最后一个子元素
				$('span:last-child').css('backgroundColor', '#9c27b0');
				// 父元素下的第N个子元素或奇偶元素
				$('span:nth-child(3)').css('backgroundColor', '#4caf50');
				// 父元素中唯一子元素，将被匹配
				$('span:only-child').css('backgroundColor', '#4caf50');
			}
			
			
			<!-- 表单选择器 -->
			$(function(){	
				// 所有表单元素
				$(':input');
				// 文本元素
				$(':text');
				// 密码元素
				$(':password');
				// 单选按钮
				$(':radio');
				// 多选按钮
				$(':checkbox');
				// 提交按钮
				$(':submit');
				// 重置按钮
				$(':reset');
				// 选择按钮
				$(':button');
				// 文件
				$(':file');
			}
		
		
			<!-- 表单对象属性选择器 -->
			$(function(){	
				// 选择不可用的（标签属性disabled="disabled"）
				$(':disabled');
				// 选择已经选中的（标签属性checked="checked"，包含下拉选框）
				$(':checked');
				$('[name=hoby]:checked');
				// 选择下拉框
				$(':selected');
			});
		</script>
			
			
			
		<!-- 核心部分 -->	
		<script type="text/javascript">
			$(function() {
				/**
				each(callback)
				size()
				length
				selector
				context
				get([index])
				index([selector|element])
				*/
				
				// 循环 each for(var i = 0 ; i<length; i++){}
				$('div:gt(2)').each(function(i,v){
					//console.log(v);
					$(this).attr('title', '我是第' + i + '个');
				});
				// 取下标为n的元素，返回dom节点
				var divDom = $('div').get(3); 	   // 返回dom
				$(divDom).css('background','red'); // 需要使用${}将dom节点转成jquery对象
			});
		</script>
		
		
		<!-- 数组和对象操作 -->	
		<script type="text/javascript">
			// 数组，new Array(), []
			// 对象  new Object(), {}
			$(function(){
				// 遍历
				var arr = [1,2,3,4,5], obj = {a:1,b:2,c:3};
				$.each(arr, function(i,v){
					console.log({i:i,v:v});
				});
				$.each(obj, function(k,v){
					console.log({k:k,v:v});
				});
				// 对象扩展（js中：var a = {}; a['a']=1; a['b']=3）
				var o2 = $.extend({a:1,b:2},{a:2,c:3});			
				var o3 = {};
				$.extend(o3, {a:1,b:2},{a:3, c:4});
				// 过滤数组元素，第三个参数改成false就是反操作（js中：var a = [1,2,3,4]; var b = a.filter(function(n){return n>=3});）
				var nArr=$.grep([1,2,3,4], function(n){return n>3;}, true);
				// 将HtmlCollection变成Array（能使用数组各种操作方法）
				var mArr = $.makeArray(document.getElementsByTagName('div'));
				mArr.pop();
				mArr.reverse();
				console.log(mArr);
				// 数据变形
				var rows = [{name:'xiaoqiang', age:18}, {name:'xiaofang', age:18}, {name:'dd', age:25}];			
				var arrM = $.map(rows, function(v,idx){                            // [{},{}] ==> []
					return v.name;
				});		
				var arrN = $.map(["xiaoqiang", "xiaofang", "dd"], function(v,idx){ // [] ==> [{},{}]
					return {name:v, age:18+idx};
				});
				// 值是否在数组里（-1不在数组里）
				console.log($.inArray([1,2,3,4], 5));
				// jquery数组对象变成真正的数组
				console.log($('div').toArray());
				// 合并两个数组
				console.log($.merge([1,3,5,7], [2,4,6,8]).sort());			
			});
		</script>
		
		
		<!-- 测试操作 -->	
		<script type="text/javascript">	
			$(function(){
				// DOM节点是否包含另一DOM节点
				console.log($.contains(document, document.getElementById('list')))				
				// 测试类型
				console.log($.type([1,2,3]));
				console.log($.type({a:1}));
				// 是否是数组
				console.log($.isArray([1,2]));
				console.log($.isArray({a:1}));
				// 是否是函数
				var a = function(){};
				console.log($.isFunction(a));
				// 是否为空（null、undefined 、'' 、[] 、{} 都是空）
				var b = {};
				console.log($.isEmptyObject(b));
				// 是否是纯粹的对象
				console.log($.isPlainObject(""));
				console.log($.isPlainObject({}));
				// 是否是数字。
				$.isNumeric("-10");  // true
				$.isNumeric("");     // false			
				// 将对象转成url参数 username=dd&password=123456
				console.log($.param({username:'dd', password:'123456'}))
			});
		</script>
		
	</head>
	<body>

	</body>
</html>
