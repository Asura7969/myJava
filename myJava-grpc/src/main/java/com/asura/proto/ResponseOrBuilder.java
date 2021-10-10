// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.asura.proto;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.asura.rpc.Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.asura.rpc.Response.ResponseType response_type = 1;</code>
   * @return The enum numeric value on the wire for responseType.
   */
  int getResponseTypeValue();
  /**
   * <code>.com.asura.rpc.Response.ResponseType response_type = 1;</code>
   * @return The responseType.
   */
  com.asura.proto.Response.ResponseType getResponseType();

  /**
   * <code>.com.asura.rpc.SuccessMessage success = 2;</code>
   * @return Whether the success field is set.
   */
  boolean hasSuccess();
  /**
   * <code>.com.asura.rpc.SuccessMessage success = 2;</code>
   * @return The success.
   */
  com.asura.proto.SuccessMessage getSuccess();
  /**
   * <code>.com.asura.rpc.SuccessMessage success = 2;</code>
   */
  com.asura.proto.SuccessMessageOrBuilder getSuccessOrBuilder();

  /**
   * <code>.com.asura.rpc.FailMessage fail = 3;</code>
   * @return Whether the fail field is set.
   */
  boolean hasFail();
  /**
   * <code>.com.asura.rpc.FailMessage fail = 3;</code>
   * @return The fail.
   */
  com.asura.proto.FailMessage getFail();
  /**
   * <code>.com.asura.rpc.FailMessage fail = 3;</code>
   */
  com.asura.proto.FailMessageOrBuilder getFailOrBuilder();

  /**
   * <code>.com.asura.rpc.RpcResponse rpcResponse = 4;</code>
   * @return Whether the rpcResponse field is set.
   */
  boolean hasRpcResponse();
  /**
   * <code>.com.asura.rpc.RpcResponse rpcResponse = 4;</code>
   * @return The rpcResponse.
   */
  com.asura.proto.RpcResponse getRpcResponse();
  /**
   * <code>.com.asura.rpc.RpcResponse rpcResponse = 4;</code>
   */
  com.asura.proto.RpcResponseOrBuilder getRpcResponseOrBuilder();

  public com.asura.proto.Response.MessageBodyCase getMessageBodyCase();
}
