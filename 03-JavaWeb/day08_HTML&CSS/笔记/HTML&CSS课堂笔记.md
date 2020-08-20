# 今日内容：

	1. HTML标签：表单标签

	2. CSS：


##  HTML标签：表单标签
	* 表单：
		* 概念：用于采集用户输入的数据的。用于和服务器进行交互。
		* form：用于定义表单的。可以定义一个范围，范围代表采集用户数据的范围
            * 属性：
                * action：指定提交数据的URL
                * method:指定提交方式
                    * 分类：一共7种，2种比较常用
                       * get：
                            1. 请求参数会在地址栏中显示。会封装到请求行中(HTTP协议后讲解)。
                            2. 请求参数大小是有限制的。
                            3. 不太安全。
                       * post：
                            2. 请求参数不会再地址栏中显示。会封装在请求体中(HTTP协议后讲解)
                            2. 请求参数的大小没有限制。
                            3. 较为安全。

            * 表单项中的数据要想被提交：必须指定其name属性

		
		* 表单项标签：
			* input：可以通过type属性值，改变元素展示的样式
				* type属性：
					* text：文本输入框，默认值
						* placeholder：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息	
					* password：密码输入框
					* radio:单选框
						* 注意：
							1. 要想让多个单选框实现单选的效果，则多个单选框的name属性值必须一样。
							2. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
							3. checked属性，可以指定默认值
					* checkbox：复选框
						* 注意：
							1. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
							2. checked属性，可以指定默认值

					* file：文件选择框
					* hidden：隐藏域，用于提交一些信息。
					* 按钮：
						* submit：提交按钮。可以提交表单
						* button：普通按钮
						* image：图片提交按钮
							* src属性指定图片的路径	

			   * label：指定输入项的文字描述信息
				   * 注意：
					   * label的for属性一般会和 input 的 id属性值 对应。如果对应了，则点击label区域，会让input输入框获取焦点。
			* select: 下拉列表
				* 子元素：option，指定列表项
				
			* textarea：文本域
				* cols：指定列数，每一行有多少个字符
				* rows：默认多少行。


## CSS：页面美化和布局控制
	1. 概念： Cascading Style Sheets 层叠样式表
		* 层叠：多个样式可以作用在同一个html的元素上，同时生效

	2. 好处：
		1. 功能强大
		2. 将内容展示和样式控制分离
			* 降低耦合度。解耦
			* 让分工协作更容易
			* 提高开发效率
	

	3. CSS的使用：CSS与html结合方式
		1. 内联样式
			 * 在标签内使用style属性指定css代码
			 * 如：<div style="color:red;">hello css</div>
		2. 内部样式
			* 在head标签内，定义style标签，style标签的标签体内容就是css代码
			* 如：
				<style>
			        div{
			            color:blue;
			        }
			
			    </style>
				<div>hello css</div>
		3. 外部样式
			1. 定义css资源文件。
    		2. 在head标签内，定义link标签，引入外部的资源文件
    		* 如：
	    		* a.css文件：
					div{
					    color:green;
					}
				<link rel="stylesheet" href="css/a.css">
				<div>hello css</div>
				<div>hello css</div>

		* 注意：
			* 1,2,3种方式 css作用范围越来越大
			* 1方式不常用，后期常用2,3
			* 3种格式可以写为：
				<style>
			        @import "css/a.css";
			    </style>

	4. css语法：
		* 格式：
			选择器 {
				属性名1:属性值1;
				属性名2:属性值2;
				...
			}
		* 选择器:筛选具有相似特征的元素
		* 注意：
			* 每一对属性需要使用；隔开，最后一对属性可以不加；


	5. 选择器：筛选具有相似特征的元素
		* 分类：
			1. 基础选择器
				1. id选择器：选择具体的id属性值的元素.建议在一个html页面中id值唯一
			        * 语法：#id属性值{}
			    2. 元素选择器：选择具有相同标签名称的元素
			        * 语法： 标签名称{}
			        * 注意：id选择器优先级高于元素选择器
			    3. 类选择器：选择具有相同的class属性值的元素。
			        * 语法：.class属性值{}
			        * 注意：类选择器选择器优先级高于元素选择器
			2. 扩展选择器：
				1. 选择所有元素：
					* 语法： *{}
				2. 并集选择器：
					* 选择器1,选择器2{}
				
				3. 子选择器：筛选选择器1元素下的选择器2元素
					* 语法：  选择器1 选择器2{}
				4. 父选择器：筛选选择器2的父元素选择器1
					* 语法：  选择器1 > 选择器2{}

				5. 属性选择器：选择元素名称，属性名=属性值的元素
					* 语法：  元素名称[属性名="属性值"]{}

				6. 伪类选择器：选择一些元素具有的状态
					* 语法： 元素:状态{}
					* 如： <a>
						* 状态：
							* link：初始化的状态
							* visited：被访问过的状态
							* active：正在访问状态
							* hover：鼠标悬浮状态
	6. 属性
		1. 字体、文本
			* font-size：字体大小
			* color：文本颜色
			* text-align：对其方式
			* line-height：行高 
		2. 背景
			* background：
		3. 边框
			* border：设置边框，符合属性
		4. 尺寸
			* width：宽度
			* height：高度
		5. 盒子模型：控制布局
			* margin：外边距
			* padding：内边距
				* 默认情况下内边距会影响整个盒子的大小
				* box-sizing: border-box;  设置盒子的属性，让width和height就是最终盒子的大小

			* float：浮动
				* left
				* right
			
## 案例：
		<!DOCTYPE html>
		<html lang="en">
		<head>
		    <meta charset="UTF-8">
		    <title>注册页面</title>
		<style>
		    *{
		        margin: 0px;
		        padding: 0px;
		        box-sizing: border-box;
		    }
		    body{
		        background: url("img/register_bg.png") no-repeat center;
		        padding-top: 25px;
		    }
		
		    .rg_layout{
		        width: 900px;
		        height: 500px;
		        border: 8px solid #EEEEEE;
		        background-color: white;
		        /*让div水平居中*/
		        margin: auto;
		    }
		
		    .rg_left{
		        /*border: 1px solid red;*/
		        float: left;
		        margin: 15px;
		    }
		    .rg_left > p:first-child{
		        color:#FFD026;
		        font-size: 20px;
		    }
		
		    .rg_left > p:last-child{
		        color:#A6A6A6;
		        font-size: 20px;
		
		    }
		
		
		    .rg_center{
		        float: left;
		       /* border: 1px solid red;*/
		
		    }
		
		    .rg_right{
		        /*border: 1px solid red;*/
		        float: right;
		        margin: 15px;
		    }
		
		    .rg_right > p:first-child{
		        font-size: 15px;
		
		    }
		    .rg_right p a {
		        color:pink;
		    }
		
		    .td_left{
		        width: 100px;
		        text-align: right;
		        height: 45px;
		    }
		    .td_right{
		        padding-left: 50px ;
		    }
		
		    #username,#password,#email,#name,#tel,#birthday,#checkcode{
		        width: 251px;
		        height: 32px;
		        border: 1px solid #A6A6A6 ;
		        /*设置边框圆角*/
		        border-radius: 5px;
		        padding-left: 10px;
		    }
		    #checkcode{
		        width: 110px;
		    }
		
		    #img_check{
		        height: 32px;
		        vertical-align: middle;
		    }
		
		    #btn_sub{
		        width: 150px;
		        height: 40px;
		        background-color: #FFD026;
		        border: 1px solid #FFD026 ;
		    }
		
		</style>
		
		</head>
		<body>
		
		<div class="rg_layout">
		    <div class="rg_left">
		        <p>新用户注册</p>
		        <p>USER REGISTER</p>
		
		    </div>
		
		    <div class="rg_center">
		        <div class="rg_form">
		            <!--定义表单 form-->
		            <form action="#" method="post">
		                <table>
		                    <tr>
		                        <td class="td_left"><label for="username">用户名</label></td>
		                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="password">密码</label></td>
		                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="email">Email</label></td>
		                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="name">姓名</label></td>
		                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="tel">手机号</label></td>
		                        <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label>性别</label></td>
		                        <td class="td_right">
		                            <input type="radio" name="gender" value="male"> 男
		                            <input type="radio" name="gender" value="female"> 女
		                        </td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="birthday">出生日期</label></td>
		                        <td class="td_right"><input type="date" name="birthday" id="birthday" placeholder="请输入出生日期"></td>
		                    </tr>
		
		                    <tr>
		                        <td class="td_left"><label for="checkcode" >验证码</label></td>
		                        <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
		                            <img id="img_check" src="img/verify_code.jpg">
		                        </td>
		                    </tr>
		
		
		                    <tr>
		                        <td colspan="2" align="center"><input type="submit" id="btn_sub" value="注册"></td>
		                    </tr>
		                </table>
		
		            </form>
		
		
		        </div>
		
		    </div>
		
		    <div class="rg_right">
		        <p>已有账号?<a href="#">立即登录</a></p>
		    </div>
		
		
		</div>
		
		
		</body>
		</html>