package com.netty;

import com.rpc.proto.MyRequest;
import com.rpc.proto.MyResponse;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * @author asura7969
 * @create 2021-10-10-13:24
 */
public class Server {

    public static void main(String[] args) {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap()
                    .group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    //.localAddress(new InetSocketAddress(port))
                    //.option(ChannelOption.SO_BACKLOG, 128)
                    //.childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("encoder", new ProtobufEncoder()); // protobuf 编码器
                            // 需要指定要对哪种对象进行解码
                            pipeline.addLast("decoder", new ProtobufDecoder(MyRequest.getDefaultInstance()));
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });

            // 绑定端口
            ChannelFuture future = server.bind(8080).sync();
            System.out.println("server started and listen " + 8080);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static class NettyServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("HelloWorldServerHandler active");
        }

        @Override
        public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("server channelRead...");
            // 读取客户端发送的数据 UserMOdel.User
            MyRequest request = (MyRequest) msg;
            System.out.println("客户端发送的数据: " + request.getUsername());
        }

        /**
         * 数据读取完毕
         */
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            final MyResponse response = MyResponse.newBuilder().setRealname("张三").build();
            ctx.writeAndFlush(response);
        }

        /**
         * 处理异常，关闭通道
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.channel().close();
        }
    }
}
