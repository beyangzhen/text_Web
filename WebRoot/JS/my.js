
/*
 * ��˫����û����ֻ�������˫���ţ��ڲ��Ҫ�õ����ţ�
 *          ������õ����ţ��ڲ��Ҫ��˫���ţ� 
 */
//alert("hello world!");
document.write('<p id="p1">this is para one</p>');
document.write("<p id='p2'>this is para two</p>");
var p1 = document.getElementById("p1");
p1.innerHTML = "hello world"; //�ı�idΪp1�ı�ǩ����
p1.style.color = "red";
p1.style.background = "gray";
var ps = document.getElementsByTagName("p");
ps[1].innerHTML = "javascript"; //�ı�p��ǩ�ĵڶ�������
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
	demo.value = demo.value.toUpperCase(); //�������Сд�ĳɴ�д
};

function myfun() {
	alert("hello function");
}

function myvar() {
	var x = 1;
	var y = "a";
	alert(x + y);
	//������������ַ�ʽ
	var cars = new array();
	cars[0] = "000";
	cars[1] = "111";
	cars[2] = "222";
	var cars = ["Audi", "BMW", "Volvo"];
	//����������Ե����ַ�ʽ
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
	//�������ķ���
	person.run = function() {
		alert("person is running");
	};
	//���ö���ķ���
	person.run();
}

function add(a, b) {
	return a+b;
}

function quandeng() {
	/*javascript��5��"5"����ֵ���*/
	var x = 5;
	var y = "5";
	alert(x==y); //ֵ���
	alert(x===y); //ȫ�ȣ�ֵ�����Ͷ���ȣ�
}

//���ڵ��Դ���
function message() {
	try {
		adddIert("Welcome guest!");
	} catch(err) {
		txt = "There was an error on this page.\n\n";
		txt += "Error description: " + err.message + "\n\n"; //"err.message"�ǲ�׽������Ϣ
		txt += "Click OK to continue.\n\n";
		alert(txt);
	}
}

//�ж������ı��������������
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

//���ͼƬ�͸���ͼƬ
function clickImage() {
	var image = document.getElementById("image");
	var v = image.src;
	if(v.indexOf("background.jpg") >= 0) { //�ڶ��ε��ʱ��v(look.jpgͼƬ��)�Ҳ���"background.jpg"�ַ�������-1����ִ��else���
		image.src = "look.jpg";
	} else {
		image.src = "background.jpg";
	}
}


