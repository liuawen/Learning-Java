package com.itheima.netty_chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 通道初始化器
 * 用来加载通道处理器（ChannelHandler)
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    // 初始化通道
    // 在这个方法中去加载对应的ChannelHandler
    protected void initChannel(SocketChannel ch) throws Exception {
        // 获取管道，将一个一个的ChannelHandler添加到管道中
        ChannelPipeline pipeline = ch.pipeline();

        // 添加一个http的编解码器
        pipeline.addLast(new HttpServerCodec());
        // 添加一个用于支持大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 添加一个聚合器，这个聚合器主要是将HttpMessage聚合成FullHttpRequest/Response
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));

        // 需要指定接收请求的路由
        // 必须使用以ws后缀结尾的url才能访问
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 添加自定义的Handler
        pipeline.addLast(new ChatHandler());
    }
}
