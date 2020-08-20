# 今日内容

	1. web概念概述
	2. HTML



## web概念概述
	* JavaWeb：
		* 使用Java语言开发基于互联网的项目

	* 软件架构：
		1. C/S: Client/Server 客户端/服务器端
			* 在用户本地有一个客户端程序，在远程有一个服务器端程序
			* 如：QQ，迅雷...
			* 优点：
				1. 用户体验好
			* 缺点：
				1. 开发、安装，部署，维护 麻烦
		2. B/S: Browser/Server 浏览器/服务器端
			* 只需要一个浏览器，用户通过不同的网址(URL)，客户访问不同的服务器端程序
			* 优点：
				1. 开发、安装，部署，维护 简单
			* 缺点：
				1. 如果应用过大，用户的体验可能会受到影响
				2. 对硬件要求过高

	* B/S架构详解
		* 资源分类：
			1. 静态资源：
				* 使用静态网页开发技术发布的资源。
				* 特点：
					* 所有用户访问，得到的结果是一样的。
					* 如：文本，图片，音频、视频, HTML,CSS,JavaScript
					* 如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器。浏览器中内置了静态资源的解析引擎，可以展示静态资源
			2. 动态资源：
				* 使用动态网页及时发布的资源。
				* 特点：
					* 所有用户访问，得到的结果可能不一样。
					* 如：jsp/servlet,php,asp...
					* 如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器


		* 我们要学习动态资源，必须先学习静态资源！

		* 静态资源：
			* HTML：用于搭建基础网页，展示页面的内容
			* CSS：用于美化页面，布局页面
			* JavaScript：控制页面的元素，让页面有一些动态的效果




## HTML
	1. 概念：是最基础的网页开发语言
		* Hyper Text Markup Language 超文本标记语言
			* 超文本:
				* 超文本是用超链接的方法，将各种不同空间的文字信息组织在一起的网状文本.
			* 标记语言:
				* 由标签构成的语言。<标签名称> 如 html，xml
				* 标记语言不是编程语言

	2. 快速入门：
		* 语法：
			1. html文档后缀名 .html 或者 .htm
			2. 标签分为
				1. 围堵标签：有开始标签和结束标签。如 <html> </html>
				2. 自闭和标签：开始标签和结束标签在一起。如 <br/>

			3. 标签可以嵌套：
				需要正确嵌套，不能你中有我，我中有你
				错误：<a><b></a></b>
				正确：<a><b></b></a>

			4. 在开始标签中可以定义属性。属性是由键值对构成，值需要用引号(单双都可)引起来
			5. html的标签不区分大小写，但是建议使用小写。

		* 代码：
			<html>
			
				<head>
					<title>title</title>
				</head>
				
				<body>
					<FONT color='red'>Hello World</font><br/>
					
					<font color='green'>Hello World</font>
				
				</body>
		
			</html>

	3. 标签学习：
		1. 文件标签：构成html最基本的标签
			* html:html文档的根标签
			* head：头标签。用于指定html文档的一些属性。引入外部的资源
			* title：标题标签。
			* body：体标签
			* <!DOCTYPE html>：html5中定义该文档是html文档
		2. 文本标签：和文本有关的标签
			* 注释：<!-- 注释内容 -->
			* <h1> to <h6>：标题标签
				* h1~h6:字体大小逐渐递减
			* <p>：段落标签
			* <br>：换行标签
			* <hr>：展示一条水平线
				* 属性：
					* color：颜色
					* width：宽度
					* size：高度
					* align：对其方式
						* center：居中
						* left：左对齐
						* right：右对齐
			* <b>：字体加粗
			* <i>：字体斜体
			* <font>:字体标签
			* <center>:文本居中
				* 属性：
					* color：颜色
					* size：大小
					* face：字体

			* 属性定义：
				* color：
					1. 英文单词：red,green,blue
					2. rgb(值1，值2，值3)：值的范围：0~255  如  rgb(0,0,255)
					3. #值1值2值3：值的范围：00~FF之间。如： #FF00FF
				* width：
					1. 数值：width='20' ,数值的单位，默认是 px(像素)
					2. 数值%：占比相对于父元素的比例

			* 案例：公司简介
				<!DOCTYPE html>
				<html lang="ch">
				<head>
				    <meta charset="UTF-8">
				    <title>黑马程序员简介</title>
				</head>
				<body>
				
				<h1>
				    公司简介
				</h1>
				<hr color="#ffd700">
				
				<p>
				<font color="#FF0000">"中关村黑马程序员训练营"</font>是由<b><i>传智播客</i></b>联合中关村软件园、CSDN， 并委托传智播客进行教学实施的软件开发高端培训机构，致力于服务各大软件企业，解决当前软件开发技术飞速发展， 而企业招不到优秀人才的困扰。
				</p>
				
				<p>
				目前，“中关村黑马程序员训练营”已成长为行业“学员质量好、课程内容深、企业满意”的移动开发高端训练基地， 并被评为中关村软件园重点扶持人才企业。
				</p>
				
				<p>
				
				黑马程序员的学员多为大学毕业后，有理想、有梦想，想从事IT行业，而没有环境和机遇改变自己命运的年轻人。 黑马程序员的学员筛选制度，远比现在90%以上的企业招聘流程更为严格。任何一名学员想成功入学“黑马程序员”， 必须经历长达2个月的面试流程，这些流程中不仅包括严格的技术测试、自学能力测试，还包括性格测试、压力测试、 品德测试等等测试。毫不夸张地说，黑马程序员训练营所有学员都是精挑细选出来的。百里挑一的残酷筛选制度确 保学员质量，并降低企业的用人风险。
				中关村黑马程序员训练营不仅着重培养学员的基础理论知识，更注重培养项目实施管理能力，并密切关注技术革新， 不断引入先进的技术，研发更新技术课程，确保学员进入企业后不仅能独立从事开发工作，更能给企业带来新的技术体系和理念。
				</p>
				
				<p>
				
				一直以来，黑马程序员以技术视角关注IT产业发展，以深度分享推进产业技术成长，致力于弘扬技术创新，倡导分享、 开放和协作，努力打造高质量的IT人才服务平台。
				</p>
				
				<hr color="#ffd700">
				
				<font color="gray" size="2">
				    <center>
				        江苏传智播客教育科技股份有限公司<br>
				        版权所有Copyright 2006-2018&copy;, All Rights Reserved 苏ICP备16007882
				    </center>
				</font>
				
				
				
				</body>
				</html>

		3. 图片标签：
			* img：展示图片
				* 属性：
					* src：指定图片的位置

			* 代码：
				 <!--展示一张图片 img-->

			    <img src="image/jingxuan_2.jpg" align="right" alt="古镇" width="500" height="500"/>
			
			    <!--
			        相对路径
			            * 以.开头的路径
			                * ./：代表当前目录  ./image/1.jpg
			                * ../:代表上一级目录
			     -->
			
			    <img src="./image/jiangwai_1.jpg">
			
			    <img src="../image/jiangwai_1.jpg">
		4. 列表标签：
			* 有序列表：
				* ol:
				* li:
			* 无序列表：
				* ul:
				* li:
		5. 链接标签：
			* a:定义一个超链接
				* 属性：
					* href：指定访问资源的URL(统一资源定位符)
					* target：指定打开资源的方式
						* _self:默认值，在当前页面打开
						* _blank：在空白页面打开

			* 代码：
				 <!--超链接  a-->

			    <a href="http://www.itcast.cn">点我</a>
			    <br>
			
			    <a href="http://www.itcast.cn" target="_self">点我</a>
			    <br>
			    <a href="http://www.itcast.cn" target="_blank">点我</a>
			
			    <br>
			
			    <a href="./5_列表标签.html">列表标签</a><br>
			    <a href="mailto:itcast@itcast.cn">联系我们</a>
			
			    <br>
			    <a href="http://www.itcast.cn"><img src="image/jiangwai_1.jpg"></a>
		6. div和span：
			* div:每一个div占满一整行。块级标签
        	* span：文本信息在一行展示，行内标签 内联标签

		7. 语义化标签：html5中为了提高程序的可读性，提供了一些标签。
			1. <header>：页眉
			2. <footer>：页脚


		8. 表格标签：
			* table：定义表格
				* width：宽度
				* border：边框
				* cellpadding：定义内容和单元格的距离
				* cellspacing：定义单元格之间的距离。如果指定为0，则单元格的线会合为一条、
				* bgcolor：背景色
				* align：对齐方式
			* tr：定义行
				* bgcolor：背景色
				* align：对齐方式
			* td：定义单元格
				* colspan：合并列
				* rowspan：合并行
			* th：定义表头单元格
			* <caption>：表格标题
			* <thead>：表示表格的头部分
			* <tbody>：表示表格的体部分
			* <tfoot>：表示表格的脚部分
				

## 案例：旅游网站首页
	1. 确定使用table来完成布局	
	2. 如果某一行只有一个单元格，则使用<tr><td></td></tr>
	3. 如果某一行有多个单元格，则使用
		<tr>
			<td>
				<table></table>
			</td>
		</tr>

	4. 代码实现

		<!DOCTYPE html>
		<html lang="en">
		<head>
		    <meta charset="UTF-8">
		    <title>黑马旅游网</title>
		</head>
		<body>
		
		    <!--采用table来完成布局-->
		    <!--最外层的table，用于整个页面的布局-->
		    <table width="100%" align="center">
		       <!-- 第1行 -->
		        <tr>
		            <td>
		                <img src="image/top_banner.jpg" width="100%" alt="">
		            </td>
		        </tr>
		
		        <!-- 第2行 -->
		        <tr>
		            <td>
		                <table width="100%" align="center">
		                    <tr>
		                        <td>
		                            <img src="image/logo.jpg" alt="">
		                        </td>
		                        <td>
		                            <img src="image/search.png" alt="">
		                        </td>
		                        <td>
		                            <img src="image/hotel_tel.png" alt="">
		                        </td>
		                    </tr>
		                </table>
		
		            </td>
		        </tr>
		
		        <!-- 第3行 -->
		        <tr>
		            <td>
		                <table width="100%" align="center">
		                    <tr bgcolor="#ffd700" align="center" height="45" >
		                        <td>
		                            <a href="">首页</a>
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		
		                        <td>
		                            门票
		                        </td>
		                    </tr>
		                </table>
		            </td>
		        </tr>
		
		        <!-- 第4行 轮播图 -->
		        <tr>
		            <td>
		                <img src="image/banner_3.jpg" alt="" width="100%">
		            </td>
		        </tr>
		
		        <!-- 第5行 黑马精选-->
		        <tr>
		            <td>
		                <img src="image/icon_5.jpg" alt="">
		                黑马精选
		                <hr  color="#ffd700" >
		            </td>
		        </tr>
		
		        <!-- 第6行 -->
		        <tr>
		            <td>
		                <table align="center" width="95%">
		                    <tr>
		                        <td>
		
		                            <img src="image/jiangxuan_1.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 899</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_1.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 899</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_1.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 899</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_1.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 899</font>
		                        </td>
		                    </tr>
		                </table>
		            </td>
		        </tr>
		
		        <!-- 第7行 国内游 -->
		        <tr>
		            <td>
		                <img src="image/icon_6.jpg" alt="">
		                国内游
		                <hr  color="#ffd700" >
		            </td>
		        </tr>
		
		        <!-- 第8行 -->
		        <tr>
		            <td>
		                <table align="center" width="95%">
		                    <tr>
		                        <td rowspan="2">
		                            <img src="image/guonei_1.jpg" alt="">
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="" height="100%">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_2.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		
		                    </tr>
		                </table>
		            </td>
		        </tr>
		
		        <!-- 第9行 境外游 -->
		        <tr>
		            <td>
		                <img src="image/icon_7.jpg" alt="">
		                境外游
		                <hr  color="#ffd700" >
		            </td>
		        </tr>
		
		        <!-- 第10行 -->
		        <tr>
		            <td>
		                <table align="center" width="95%">
		                    <tr>
		                        <td rowspan="2">
		                            <img src="image/jiangwai_1.jpg" alt="">
		                        </td>
		
		                        <td>
		
		                            <img src="image/jiangxuan_3.jpg" alt="" height="100%">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                           <img src="image/jiangxuan_3.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                           <img src="image/jiangxuan_3.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <td>
		
		                           <img src="image/jiangxuan_3.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                           <img src="image/jiangxuan_3.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		                        <td>
		
		                           <img src="image/jiangxuan_3.jpg" alt="">
		                            <p>上海飞三亚五天4晚自由行(春节销售+亲子+蜜月+自由行)</p>
		                            <font color="red">&yen; 699</font>
		                        </td>
		
		
		                    </tr>
		                </table>
		            </td>
		        </tr>
		        <!-- 第11行 -->
		        <tr>
		            <td>
		                <img src="image/footer_service.png" alt="" width="100%">
		            </td>
		        </tr>
		
		        <!-- 第12行 -->
		        <tr>
		            <td align="center" bgcolor="#ffd700" height="40">
		                <font color="gray" size="2">
		                江苏传智播客教育科技股份有限公司
		                版权所有Copyright 2006-2018&copy;, All Rights Reserved 苏ICP备16007882
		                </font>
		            </td>
		        </tr>
		        
		    </table>
		
		
		</body>
		</html>