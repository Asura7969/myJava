package com.asura.service;

import com.asura.proto.*;
import com.google.protobuf.ByteString;
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
 * @create 2021-10-10-19:49
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
                            pipeline.addLast("decoder", new ProtobufDecoder(Message.getDefaultInstance()));
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
            Message m = (Message) msg;
            switch (m.getDataBodyCase()) {
                case REQUEST:

                    handleRequest(ctx, m.getRequest(), m.getTime());
                    break;
                case RESPONSE:
                    handleResponse(ctx, m.getResponse());
                    break;
                case DATABODY_NOT_SET:
                default:
                    // do nothing
            }

        }

        private void handleRequest(ChannelHandlerContext ctx, Request request, long time) {
            final String clientIp = request.getIp();
            final int port = request.getPort();
            switch (request.getMessageBodyCase()) {
                case FILE:
                    final FileMessage file = request.getFile();
                    final String fileName = file.getName();
                    final byte[] bytes = file.getData().toByteArray();

                    break;
                case ONEWAY:
                    final OneWayMessage oneWay = request.getOneWay();
                    final byte[] bytes1 = oneWay.getData().toByteArray();

                    break;
                case RPCREQUEST:
                    final RpcRequest rpcRequest = request.getRpcRequest();
                    final byte[] bytes2 = rpcRequest.getData().toByteArray();

                    break;
                case MESSAGEBODY_NOT_SET:
                default:

            }

        }

        private void handleResponse(ChannelHandlerContext ctx, Response response) {
            switch (response.getMessageBodyCase()) {
                case SUCCESS:
                    final SuccessMessage success = response.getSuccess();


                case FAIL:
                    final FailMessage fail = response.getFail();
                    final String content = fail.getContent();

                case RPCRESPONSE:
                    final RpcResponse rpcResponse = response.getRpcResponse();
                    final byte[] data = rpcResponse.getData().toByteArray();


                case MESSAGEBODY_NOT_SET:
                default:


            }
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
