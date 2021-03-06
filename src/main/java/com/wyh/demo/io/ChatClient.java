package com.wyh.demo.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author imai
 * @since 2021/2/3 10:22 下午
 */
public class ChatClient {
    public ChatClient connect(int port,String host,final String nickName){
        EventLoopGroup group = new NioEventLoopGroup();

        try{
           Bootstrap bootstrap = new Bootstrap();
           bootstrap.group(group).channel(NioSocketChannel.class)
                   .option(ChannelOption.SO_KEEPALIVE,true)
                   .handler(new ChannelInitializer<SocketChannel>() {
                       @Override
                       protected void initChannel(SocketChannel ch) throws Exception {

                       }
                   });
            ChannelFuture channelFuture = bootstrap.connect(host,port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
        return this;
    }

    public static void main(String[] args) {
        new ChatClient().connect(8080,"localhost","Tom老师");
    }
}
