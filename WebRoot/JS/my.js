
/*
 * 单双引号没区别（只是外层用双引号，内层就要用单引号）
 *          （外层用单引号，内层就要用双引号） 
 */
//alert("hello world!");
document.write('<p id="p1">this is para one</p>');
document.write("<p id='p2'>this is para two</p>");
var p1 = document.getElementById("p1");
p1.innerHTML = "hello world"; //改变id为p1的标签内容
p1.style.color = "red";
p1.style.background = "gray";
var ps = document.getElementsByTagName("p");
ps[1].innerHTML = "javascript"; //改变p标签的第二个内容
//myfun();
//myvar();
//string_obj();
//var r = add(1, 2); alert(r);
//quandeng();
//message();
var demo = document.getElementById("demo");
demo.onfocus = function() {
	demo.style.background = "red";
};
demo.onblur = function() {
	demo.style.background = "white";
};
demo.onchange = function() {
	demo.value = demo.value.toUpperCase(); //将输入的小写改成大写
};

function myfun() {
	alert("hello function");
}

function myvar() {
	var x = 1;
	var y = "a";
	alert(x + y);
	//定义数组的两种方式
	var cars = new array();
	cars[0] = "000";
	cars[1] = "111";
	cars[2] = "222";
	var cars = ["Audi", "BMW", "Volvo"];
	//定义对象属性的两种方式
	var person1 = {fristname:"Bill", lastname:"Gates", id:5566};
	alert(person.lastname);
	var person2 = new Object();
	person.firstname = "Bill";
}

function string_obj(){
	var txt = "hello world";
	alert(txt.length);
	alert(txt.indexOf("w", 0));
	var newtxt = txt.replace(" ", "+");
	alert(txt + "---" + newtxt);
	var person = new Object();
	person.firstname = "Bill";
	person.lastname = "Gates";
	person.age = 56;
	//定义对象的方法
	person.run = function() {
		alert("person is running");
	};
	//调用对象的方法
	person.run();
}

function add(a, b) {
	return a+b;
}

function quandeng() {
	/*javascript中5和"5"属于值相等*/
	var x = 5;
	var y = "5";
	alert(x==y); //值相等
	alert(x===y); //全等（值和类型都相等）
}

//用于调试错误
function message() {
	try {
		adddIert("Welcome guest!");
	} catch(err) {
		txt = "There was an error on this page.\n\n";
		txt += "Error description: " + err.message + "\n\n"; //"err.message"是捕捉错误信息
		txt += "Click OK to continue.\n\n";
		alert(txt);
	}
}

//判断输入文本框中输入的内容
function myFunction() {
	try {
		var x = document.getElementById("demo").value;
		if(x == "") throw "empty";
		if(isNaN(x)) throw "not a number";
		if(x < 5) throw "too low";
		if(x > 10) throw "too high";
	} catch(err) {
		var y = document.getElementById("mess");
		y.innerHTML = "Error: " + err + ",";
	}
}

//点击图片就更换图片
function clickImage() {
	var image = document.getElementById("image");
	var v = image.src;
	if(v.indexOf("background.jpg") >= 0) { //第二次点击时，v(look.jpg图片中)找不到"background.jpg"字符串返回-1，就执行else语句
		image.src = "look.jpg";
	} else {
		image.src = "background.jpg";
	}
}


