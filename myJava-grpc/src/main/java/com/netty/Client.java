package com.netty;

import com.rpc.proto.MyRequest;
import com.rpc.proto.MyResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * @author asura7969
 * @create 2021-10-10-13:24
 */
public class Client {

    public static void main(String[] args) {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("encoder", new ProtobufEncoder()); // protobuf 编码器
                            // 需要指定要对哪种对象进行解码
                            pipeline.addLast("decoder", new ProtobufDecoder(MyResponse.getDefaultInstance()));
                            pipeline.addLast();
                            pipeline.addLast(new NettyClientHandler());
                        }
                    });

            ChannelFuture future = client.connect("127.0.0.1", 8080).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static class NettyClientHandler extends ChannelInboundHandlerAdapter {
        /**
         * 通道就绪触发该方法
         */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("HelloWorldClientHandler Active");
            // 发送 User POJO 对象到服务器
            final MyRequest zhangsan = MyRequest.newBuilder().setUsername("zhangsan").build();
            ctx.writeAndFlush(zhangsan);
        }

        /**
         * 当通道有读取事件时触发该方法
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 读取服务器发送的数据
            MyResponse response = (MyResponse) msg;
            System.out.println("收到服务器响应: " + response.getRealname());
        }
    }
}
