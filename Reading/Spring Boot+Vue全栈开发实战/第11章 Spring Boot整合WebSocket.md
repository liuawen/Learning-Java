# 第11章 Spring Boot整合WebSocket

• 为什么需要WebSocket

• WebSocket简介

• Spring Boot整合WebSocket

# 为什么需要WebSocket

WebSocket

在HTTP协议中，所有的请求都是由客户端发起的，由服务端进行响应，服务端无法向客户端推送消息，但是在一些需要即时通信的应用中，又不可避免地需要服务端向客户端推送消息，传统的解决方案主要有如下几种。



请求 客户端发起的   服务端进行响应