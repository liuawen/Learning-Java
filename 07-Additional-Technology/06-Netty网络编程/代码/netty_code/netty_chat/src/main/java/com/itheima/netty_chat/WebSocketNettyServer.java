package com.itheima.netty_chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketNettyServer {
    public static void main(String[] args) {
        // 创建两个线程池
        NioEventLoopGroup mainGrp = new NioEventLoopGroup(); // 主线程池
        NioEventLoopGroup subGrp = new NioEventLoopGroup(); // 从线程池

        try {
            // 创建Netty服务器启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 初始化服务器启动对象
            serverBootstrap
                    // 指定使用上面创建的两个线程池
                    .group(mainGrp, subGrp)
                    // 指定Netty通道类型
                    .channel(NioServerSocketChannel.class)
                    // 指定通道初始化器用来加载当Channel收到事件消息后，
                    // 如何进行业务处理
                    .childHandler(new WebSocketChannelInitializer());

            // 绑定服务器端口，以同步的方式启动服务器
            ChannelFuture future = serverBootstrap.bind(9090).sync();
            // 等待服务器关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅关闭服务器
            mainGrp.shutdownGracefully();
            subGrp.shutdownGracefully();
        }

    }
}
