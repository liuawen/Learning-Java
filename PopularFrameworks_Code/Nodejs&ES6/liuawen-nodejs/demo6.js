//引入http模块
var http = require("http");
var url = require("url");
//创建服务，监听8888端口
http.createServer(function (request, response) {
    //发送http头部
    //http响应状态200
    //http响应内容类型为text/plain
    response.writeHead(200, {"Content-Type": "text/plain"});

    //解析参数
    //参数1：请求地址；
    //参数2：true时query解析参数为一个对象，默认false
    var params = url.parse(request.url, true).query;
    //将所有请求参数输出
    for (var key in params) {
        response.write(key + " = " + params[key]);
        response.write("\n");
    }
    response.end("");
}).listen(8888);
console.log("Server running at http://127.0.0.1:8888 ")
