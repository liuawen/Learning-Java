## 1. Nodejs概述

**目标**：Node.js用途；安装Node.js

### 什么是Node.js

简单的说 Node.js 就是运行在服务端的 JavaScript。
Node.js 是一个基于Chrome JavaScript 运行时建立的一个平台。
Node.js是一个事件驱动I/O服务端JavaScript环境，基于Google的V8引擎，V8引擎执行Javascript的速度非常快，性能非常好。

### Node.js安装

下载对应系统的Node.js版本

[https://nodejs.org/en/download/](https://nodejs.org/en/download/)

推荐下载LTS版本

完成以后，在控制台输入：

查看Node版本信息

```
C:\Users\x1c>node -v
v11.9.0

C:\Users\x1c>

```

### 快速入门



**小结**：

Node.js是一个可以在js中接收和处理web请求的应用平台。

简单的说Node.js就是运行在服务端的JavaScript





## 2. Nodejs模块化编程

**目标**：编写模块文件使用require引入模块后使用node.js执行

**小结**：

可以使用exports将js方法导出，并使用require引入对应的js模块，然后再引入之后可以使用对应的方法。

## 3. 创建Nodejs Web服务器

**目标**：引入http模块监听8888端口实现输出字符

**小结**：

可以利用node.js创建web服务器：

```js
//引入node.js内置http模块
var http = require("http");

//创建并监听web服务器
http.createServer(function (request, response) {

    //发送http头部
    //参数1：响应状态码，200表示成功
    //参数2：响应头部信息，Content-Type内容类型：纯文本
    response.writeHead(200, {"Content-Type": "text/plain"});

    //发送响应数据
    response.end("Hello World \n");
}).listen(8888);
console.log("服务器运行在 http://127.0.0.1:8888 ");
```



## 4. 处理Nodejs Web请求参数

**目标**：引入http和url模块创建web容器并使用url解析请求路径中参数且输出

**分析**：

需求：http://127.0.0.1:8888?id=123&name=heima 获取到请求路径中参数及值并输出

实现步骤：

1. 创建web服务器；
2. 引入url模块；
3. 利用url解析请求地址中的参数和值并输出
4. 启动测试；

**小结**：

在node.js中可以引入url内置模块对请求地址进行处理：

```js
//引入node.js内置http模块
var http = require("http");
var url = require("url");

//创建并监听web服务器
http.createServer(function (request, response) {

    //发送http头部
    //参数1：响应状态码，200表示成功
    //参数2：响应头部信息，Content-Type内容类型：纯文本
    response.writeHead(200, {"Content-Type": "text/plain"});

    //解析请求地址
    //参数1：请求地址
    //参数2：true的话使用query解析参数到一个对象，默认false
    var params = url.parse(request.url, true).query;
    for(var key in params){
        response.write( key + " = " + params[key]);
        response.write("\n");
    }

    //发送响应数据
    response.end("");
}).listen(8888);
console.log("服务器运行在 http://127.0.0.1:8888 ");
```



## 5. 包资源管理器NPM

**目标**：说出npm的作用；区别本地安装和全局安装

**小结**：

npm是一个node.js的管理和分发工具，可以根据配置package.json下载js库。

- 本地安装：将下载的模块安装到当前目录（项目）；
- 全局安装：将下载的模块安装到全局的目录（ `npm root -g` ）

## 6. 切换NPM镜像

**目标**：安装nrm组件将npm的镜像切换为淘宝镜像

**小结**：

- 使用nrm 切换镜像源

```sh
npm install nrm -g

nrm use taobao
```



- 使用cnpm下载

```sh
npm install -g cnpm --registry=https://registry.npm.taobao.org

cnpm install **
```



## 7. webpack概述

**目标**：webpack的作用是什么并安装webpack

**小结**：

webpack作用：可以将多个静态资源js、css等打包成一个js文件。

安装命令如下：

```sh
npm install webpack -g
npm install webpack-cli -g
```



## 8. webpack打包js

**目标**：创建2个js文件，使用webpack命令打包js文件到 `dist/bundle.js` 文件中并测试。

**分析**：

实现步骤：

1. 创建2个js文件；
2. 创建入口文件main.js；
3. 创建webpack的配置文件；
4. 运行webpack命令；
5. 创建index.html页面进行测试

**小结**：

webpack打包js的配置文件：

```js
var path = require("path");

module.exports = {
    //入口文件
    entry: "./src/main.js",
    output: {
        //路径
        path: path.resolve(__dirname, "./dist"),
        filename: "bundle.js"
    }
}
```

> webpack可以将多个js文件打包成一个js

## 9. webpack打包css

**目标**：安装style-loader css-loader组件，创建并使用css文件，使用webpack命令打包js文件到 `dist/bundle.js` 文件中并测试。

**分析**：

实现步骤：

1. 安装转换css的组件；
2. 修改配置文件；
3. 创建css文件；
4. 修改入口文件，加载css文件；
5. 打包并测试

**小结**：

webpack打包css文件需要安装转换的组件，并修改配置文件：

```js
var path = require("path");

module.exports = {
    //入口文件
    entry: "./src/main.js",
    output: {
        //路径
        path: path.resolve(__dirname, "./dist"),
        filename: "bundle.js"
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ["style-loader", "css-loader"]
            }
        ]
    }
}
```



## 10. ES6概述&创建测试工程

**目标**：了解es6应用场景；创建测试工程

**小结**：

ECMAScript是前端js的语法规范；可以应用在各种js环境中。如：浏览器或者node.js环境。

它有很多版本：es1/2/3/5/6，很多新特性，可以在js环境中使用这些新特性。

## 11. let和const命令及模板字符串

**目标**：使用let和const定义变量说出区别；模板字符串的好处以及对象初始化简写

**小结**：

- let所声明的变量只能在let命令所在的代码块中使用
- const声明的变量是常量，也就是值不可以改变
- 模板字符串：可以不用通过反斜杠拼接多行字符，直接使用`
- 对象初始化简化：可以在返回的对象时，不用指定属性名。

## 12. 解构表达式

**目标**：将数组、对象中的值或属性使用解构表达式设置到对应变量

**小结**：

解构表达式：可以对数组、对象的元素或者属性按顺序、名称的方式进行赋值到对应变量中。

## 13. 函数优化

**目标**：箭头函数的好处；对象的函数属性简写，箭头函数与解构表达式的应用

**小结**：

箭头函数：可以不用编写基础函数的解构（如：function），直接使用 `=>` 

```js
        var print = function (obj) {
            console.log(obj);
        };
        print("print");
        //箭头函数
        var print2 = obj => console.log(obj);
        print2("print2");

        var sum = function (a, b) {
            return a+b;
        };
        console.log(sum(1,2));

        //箭头函数
        var sum2 = (a,b) => a+b;
        console.log(sum2(1,2));

        var sum3 = (a,b) => {
            console.log(a+b);
            return a+b;
        };
        console.log(sum3(1,2));

        let person = {
            "name": "heima",
            learn1: function (course="java") {
                console.log(this.name + " 在学习 " + course);
            },
            //箭头函数；不能使用this
            learn2: (course) => console.log(person.name + " 在学习 " + course),
            //简写
            learn3(course){
                console.log(this.name + " 在学习 " + course);
            }
        };
        person.learn1("java");
        person.learn2("js");
        person.learn3("css");

        const person = {
            name:"heima",
            age:13,
            language:["java","js","css"]
        };
         function hello(person) {
             console.log("hello " + person.name);
         }
         hello(person);

         //箭头函数、解构表达式
        var hello2 = ({name}) => console.log("hello2 " + name);
        hello2(person);

```



## 14. map方法使用

**目标**：数组中map方法的应用场景

**小结**：

map方法可以将原数组中的所有元素通过一个函数进行处理并放入到一个新数组中并返回该新数组。

## 15. reduce方法使用

**目标**：数组中reduce方法的应用场景

**小结**：

reduce方法会从左到右依次把数组中的元素用函数处理（reduce方法的第一个参数），会返回一个执行结果。

> let arr = [1, 2, 3]
>
> arr.reduce((a,b)=>a+b)
>
> 第1次：(1,2) => 1+2
>
> 第2次：(3, 3) => 3+3  --------》 6

## 16. promise应用示例

**目标**：promise的应用场景及示例

**小结**：

promise是一个对象，保存着预期事件执行的结果；可以应用在异步操作时候，指定异步操作的成功与失败的结果。

```js
        const promise = new Promise(function (resolve, reject) {
            setTimeout(()=>{
                let num = Math.random();
                if(num < 0.5){
                    resolve("操作成功！num=" + num);
                } else {
                    reject("操作失败！num=" + num);
                }
            },300);
        });

        promise.then(function (msg) {
            console.log(msg);
        }).catch(function (msg) {
            console.log(msg);
        });

```



## 17. 对象的扩展方法使用

**目标**：Object对象中的keys/values/assign的作用

**小结**：

Object的方法：

- keys：获取对象的属性名
- values：获取对象的属性值
- entries：获取对象的属性和属性值
- assign：可以将对象进行拷贝

## 18. 数组的扩展方法使用

**目标**：数组中的find/findIndex/includes的作用

**小结**：

数组的扩展方法：

- find：根据函数条件查找数组中符合条件的元素
- findIndex：与find类似，返回的不是元素而是元素对应的索引号
- includes：判断指定的元素是否存在

## 19. 安装babel

**目标**：安装babel及了解babel的作用

**小结**：

babel是一个javaScript语法编译器，可以将es6的语法进行转换并执行。

需要安装babel：

```sh
cnpm install babel-preset-es2015 --save-dev 
cnpm install babel-cli -g
```

编写.babelrc文件，指定es的版本

可以通过命令去执行对应的js文件：babel-node

## 20. export和import联合应用

**目标**：export和import的联合应用场景；使用export导出模板文件，import引入模板文件

**小结**：

可以通过export导出模块，通过import导入模块并使用其内容。

导出有两种方式：命名导出和默认导出。

因为浏览器默认不支持export和import命令，所以需要安装babel对export和import进行解析和执行。

