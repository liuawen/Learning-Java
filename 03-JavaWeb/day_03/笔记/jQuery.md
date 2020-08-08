

![image-20200530175440760](assets/image-20200530175440760.png)



jQuery简介
一上来就描述
jQuery是一个兼容多浏览器的、轻量级的Javascript库
兼容多浏览器　轻量级　　字节多大　轻　流量　快　
这个我知道jQuery   直接IDEA　一直待着　笔记也在这里来写的

jQuery是一个兼容多浏览器的、轻量级的JavaScript库
jQuery是继prototype之后又一个优秀的JavaScript库，如今，jQuery已经成为最流行的JavaScript库
jQuery，顾名思义，也就是JavaScript和查询（Query），其宗旨是
     ——WRITE LESS,DO MORE

jQuery的使用
jQuery库实际上就是一个js文件，只需要在网页中直接引入这个文件就可以了。
将jQuery的库文件加入
在开发测试时, 用的是未压缩的版本:
     jquery-1.7.2.js
在上线项目中, 会使用压缩后的版本:
     jquery-1.7.2.min.js

HelloWorld

```javascript
<script type="text/javascript" src="../script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//使用$()代替window.onload
	$(function(){
		//获取按钮对象并绑定单机响应函数
		$("#btnId").click(function(){
			//弹出Hello
			alert('Hello');
		});
	});
</script>
</head>
<body>
	<button id="btnId">SayHello</button>
</body>

```



jQuery核心函数

```
$是jQuery的核心函数，jQuery的核心功能都是通过这个函数实现
$的四个作用:
$(function(){})
相当于window.onload = function(){}
$(“选择器”)
根据这个选择器查找元素节点对象
$(“html字符串”)
根据这个html字符串创建元素节点对象
$(DOM对象)
将DOM对象包装为jQuery对象

```



函数
选择器字符串
HTML字符串
DOM对象

jQuery对象与DOM对象的转换



```
DOM对象转jQuery对象
使用jQuery核心函数包装DOM对象
例如：var $btnEle = $(btnEle)
声明一个变量指向jQuery对象，那么这个变量习惯上要以$开头
jQuery对象转DOM对象
使用数组下标：$btnEle[0]
使用get(index)方法：$btnEle.get(0)



```



jQuery对象
对象访问
DOM操作
CSS
事件

jQuery的选择器

```
jQuery中的核武器
欲知后事如何……
请看jQueryAPI_1.7.1_CN.chm
哪里不会点哪里

```

