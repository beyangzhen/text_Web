<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>jquery</title>

		<!-- 引入jquery类库 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
		
		
		
		<!-- 1. js和jquery对象之间转化 -->
		<script type="text/javascript">		
			//js -> jquery
			var f2 = $(f1)
			//jquery -> js（javascript文档对象dom）
			var f2 = f1[0]
		</script>
		
		
		
		<!-- 2. 开始入口 -->
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
		
		
		
		<!-- 3. 选择器 -->
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
			
			
			
		<!-- 4. 核心部分 -->	
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
		
		
		
		<!-- 5. 数组和对象操作 -->	
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
		
		
		
		<!-- 6. 测试操作 -->	
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
		
		
		
		<!-- 7. 效果 -->
		<script type="text/javascript">
			$(function(){
				var b = $('#block'), btnS = $('#show'), btnH = $('#hide'), btnT = $('#toggle');
				// 显示 
				btnS.on('click',function(){
					// b.show(3000);
					b.show(3000, function(){
						console.log('显示完成后的动作');
					});
				});
				// 隐藏
				btnH.on('click',function(){
					// b.hide(3000);
					b.hide(3000, function(){
						console.log('隐藏后的动作');
					});
				});
				// 隐藏或显示
				btnT.on('click',function(){
					// b.toggle(3000);
					b.toggle('fast', function(){ // ms, slow, fast
						console.log('显示或隐藏')
					});
					// 1.9版本 .toggle(function, function, … ) 方法删除（jQuery Migrate（迁移）插件恢复此功能）
					/* 
					b.toggle(function(){
						console.log('第一个函数')
					}, function(){
						console.log('第二个函数')					
					}) 
					*/
				});
				
				var btnSD = $('#sd'), btnSU = $('#su'), btnST = $('#st');
				// 向下滑动
				btnSD.on('click',function(){
					// b.slideDown(3000);
					b.slideDown(3000, function(){
						console.log('向下滑动完成后的动作');
					});
				});
				// 向上滑动
				btnSU.on('click',function(){
					// b.slideUp(3000);
					b.slideUp(3000, function(){
						console.log('向上滑动后的动作');
					});
				});
				// 向上或向下滑动
				btnST.on('click',function(){
					b.slideToggle('fast', function(){
						console.log('向上或向下滑动')
					});
				});
				
				var btnFi = $('#fi'), btnFo = $('#fo'), btnFt = $('#ft'), btnFtg = $('#ftg');
				// 淡入
				btnFi.on('click',function(){
					b.fadeIn(3000, function(){
						console.log('淡入完成后的动作');
					});
				});
				// 淡出
				btnFo.on('click',function(){
					b.fadeOut(3000, function(){
						console.log('淡出后的动作');
					});
				});
				// 淡入或淡出到0.25的程度
				btnFt.on('click',function(){
					b.fadeTo('slow', 0.25, function(){
						console.log('淡入或淡出')
					});
				});
				// 淡入或淡出
				btnFtg.on('click',function(){
					b.fadeToggle('fast', function(){
						console.log('第一个函数')
					});
				});
			});
		</script>
		
		
		
		<!-- 8. 属性 -->
		<script type="text/javascript">
			$(function(){
				// 获取属性 
				console.log($('#list').attr('class')); // main main-body
				// 移除属性
				$('#list').removeAttr('class');
				// 获取匹配元素中第一个元素的属性值
				console.log($('#list').prop('class')); // main main-body
				// 移除由.prop()方法设置的属性集
				$('#list').prop('username', '12345')
				$('#list').removeProp('username');
				// 添加样式
				$('#list').addClass('abc');
				// 删除样式
				$('#list').removeClass('abc');
				// 存在（不存在）就删除（添加）一个
				$('#list').toggleClass('main');
				// 取html内容
				console.log($('#list').html());
				// 取文本（即：标签内的内容）
				console.log($('#list').text());
				// 表单元素的值
				console.log($(':text').val());
			});
		</script>
		
		
		
		<!-- 9. 文档处理 -->
		<script type="text/javascript">
			$(function(){
				// 节点内的尾部追加内容（与js执行appendChild方法类似）
				$('#list').append('<div>Five</div>');
				// 节点内的尾部追加内容（反式操作）
				$('<div>Six</div>').appendTo('#list');
				// 节点内的头部追加内容
				$('#list').prepend('<div>Eight</div>');
				// 节点内的头部追加内容（反式操作）
				$('<div>Nine</div>').prependTo('#list');
				
				// 节点前添加元素
				$('#list').before('<h1>before</h1>');
				// 节点前添加元素（反式操作）
				$('<h1>insertBefore</h1>').insertBefore('#list');
				// 节点后添加元素（反式操作）
				$('<h1>insertAfter</h1>').insertAfter('#list');
				// 节点后添加元素
				$('#list').after('<h1>after</h1>');
				
				// 节点外包元素
				$('#list').wrap('<div class="wrap"/>');
				// 节点外取消包元素
				$('#list').unwrap();
				// 所有节点外包元素
				$('p').wrapAll('<div class="wrap"/>');
				// 节点内部包元素
				$('p').wrapInner('<strong/>');
				
				// 所有匹配元素替换成指定的HTML或DOM元素 --> 后替换前
				$('#list div').replaceWith('<h4>hello</h4>');
				// 所有匹配元素替换成指定的HTML或DOM元素（反式操作）
				$('<h3>word</h3>').replaceAll('p');
				// 清空里面内容
				$('#list').empty().append('<div>hello</div>');
				// 删除指定节点
				$('#list').remove();
				// 删除所有匹配的元素（绑定的事件、附加的数据等都会保留下来）
				$('p').detach();
				// 克隆一份，将此加入id为x标签内前面
				var x = $('span').clone();
				$('#x').append(x);
			});
		</script>
		
		
		
		<!-- 10. 过滤 -->
		<script type="text/javascript">
			$(function(){
				// 等于此下标值（索引）的元素
				console.log($('#list div').eq(2));
				// 第一个元素
				console.log($('#list div').first());
				// 最后一个元素
				console.log($('#list div').last());
				// 当前元素是否含有某个特定类（有：true）
				console.log($('#list div').first().hasClass('x'));
				// 与指定表达式匹配的元素集合
				console.log($('#list div').filter('.xx'))
				// 是否为某个类型
				console.log($('#list').is('form'));
				console.log($('#list').is('div'));
				
				// map（数据变换），get（jquery变成array），join（array变成string）
				$("p").append($("input").map(function(){ 
				    return $(this).val();
				}).get().join(", "));
				
				// 包含子元素的标签（返回自身节点）
				$('li').has('ul').css('background-color', 'red');
				// 删除与指定表达式匹配的元素
				$('div').not($('.xx')[0]);
				// 指定下标匹配的子集
				$('div').slice(2).remove();    // 选取第三个和之后的元素
				$('div').slice(1, 2).remove(); // 选取第二个元素
			});
		</script>
		
		
		
		<!-- 11. 查找 -->
		<script type="text/javascript">
			$(function(){
				// 查找儿子节点
				console.log($('#list').children('div'));
				// 查找最近的父节点
				console.log($('.sub').closest('div'));
				// 查找多级子节点
				console.log($('#list').find('span'))
				// 查找前面的第一个兄弟节点
				console.log($('#list div:last').prev());
				// 查找前面的所有兄弟节点
				console.log($('#list div:last').prevAll());
				// 查找前面的所有兄弟节点直到指定元素（不包括匹配元素）
				console.log($('#list div:last').prevUntil('.ok'));
				// 查找后面的第一个兄弟节点
				console.log($('#list div:first').next());
				// 查找后面的所有兄弟节点
				console.log($('#list div:first').nextAll());
				// 查找后面的所有兄弟节点直到指定元素（不包括匹配元素）
				console.log($('#list div:first').nextUntil('span'));
				// 查找两边的兄弟节点
				console.log($('#list div').eq(2).siblings());				
				// 查找父亲节点
				console.log($('.sub').parent());
				// 查找所有祖先 
				console.log($('.sub').parents('div'));
				// 查找所有祖先直到匹配条件（不包括匹配元素）
				console.log($('.sub').parentsUntil('.ok'));
			});
		</script>
		
	</head>
	<body>

	</body>
</html>
