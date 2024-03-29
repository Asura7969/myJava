// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.rpc.proto;

/**
 * Protobuf type {@code com.rpc.proto.StudentResponseList}
 */
public final class StudentResponseList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.rpc.proto.StudentResponseList)
    StudentResponseListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StudentResponseList.newBuilder() to construct.
  private StudentResponseList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StudentResponseList() {
    studentResponse_ = java.util.Collections.emptyList();
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new StudentResponseList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StudentResponseList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              studentResponse_ = new java.util.ArrayList<StudentResponse>();
              mutable_bitField0_ |= 0x00000001;
            }
            studentResponse_.add(
                input.readMessage(StudentResponse.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        studentResponse_ = java.util.Collections.unmodifiableList(studentResponse_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return StudentProto.internal_static_com_sail_proto_StudentResponseList_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return StudentProto.internal_static_com_sail_proto_StudentResponseList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            StudentResponseList.class, Builder.class);
  }

  public static final int STUDENTRESPONSE_FIELD_NUMBER = 1;
  private java.util.List<StudentResponse> studentResponse_;
  /**
   * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
   */
  @Override
  public java.util.List<StudentResponse> getStudentResponseList() {
    return studentResponse_;
  }
  /**
   * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
   */
  @Override
  public java.util.List<? extends StudentResponseOrBuilder>
      getStudentResponseOrBuilderList() {
    return studentResponse_;
  }
  /**
   * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
   */
  @Override
  public int getStudentResponseCount() {
    return studentResponse_.size();
  }
  /**
   * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
   */
  @Override
  public StudentResponse getStudentResponse(int index) {
    return studentResponse_.get(index);
  }
  /**
   * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
   */
  @Override
  public StudentResponseOrBuilder getStudentResponseOrBuilder(
      int index) {
    return studentResponse_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < studentResponse_.size(); i++) {
      output.writeMessage(1, studentResponse_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < studentResponse_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, studentResponse_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof StudentResponseList)) {
      return super.equals(obj);
    }
    StudentResponseList other = (StudentResponseList) obj;

    if (!getStudentResponseList()
        .equals(other.getStudentResponseList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getStudentResponseCount() > 0) {
      hash = (37 * hash) + STUDENTRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getStudentResponseList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static StudentResponseList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StudentResponseList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StudentResponseList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StudentResponseList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StudentResponseList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StudentResponseList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StudentResponseList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StudentResponseList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static StudentResponseList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static StudentResponseList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static StudentResponseList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StudentResponseList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(StudentResponseList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.rpc.proto.StudentResponseList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.rpc.proto.StudentResponseList)
      StudentResponseListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return StudentProto.internal_static_com_sail_proto_StudentResponseList_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return StudentProto.internal_static_com_sail_proto_StudentResponseList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StudentResponseList.class, Builder.class);
    }

    // Construct using com.rpc.proto.StudentResponseList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getStudentResponseFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      if (studentResponseBuilder_ == null) {
        studentResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        studentResponseBuilder_.clear();
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return StudentProto.internal_static_com_sail_proto_StudentResponseList_descriptor;
    }

    @Override
    public StudentResponseList getDefaultInstanceForType() {
      return StudentResponseList.getDefaultInstance();
    }

    @Override
    public StudentResponseList build() {
      StudentResponseList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public StudentResponseList buildPartial() {
      StudentResponseList result = new StudentResponseList(this);
      int from_bitField0_ = bitField0_;
      if (studentResponseBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          studentResponse_ = java.util.Collections.unmodifiableList(studentResponse_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.studentResponse_ = studentResponse_;
      } else {
        result.studentResponse_ = studentResponseBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof StudentResponseList) {
        return mergeFrom((StudentResponseList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(StudentResponseList other) {
      if (other == StudentResponseList.getDefaultInstance()) return this;
      if (studentResponseBuilder_ == null) {
        if (!other.studentResponse_.isEmpty()) {
          if (studentResponse_.isEmpty()) {
            studentResponse_ = other.studentResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureStudentResponseIsMutable();
            studentResponse_.addAll(other.studentResponse_);
          }
          onChanged();
        }
      } else {
        if (!other.studentResponse_.isEmpty()) {
          if (studentResponseBuilder_.isEmpty()) {
            studentResponseBuilder_.dispose();
            studentResponseBuilder_ = null;
            studentResponse_ = other.studentResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
            studentResponseBuilder_ =
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getStudentResponseFieldBuilder() : null;
          } else {
            studentResponseBuilder_.addAllMessages(other.studentResponse_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      StudentResponseList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (StudentResponseList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<StudentResponse> studentResponse_ =
      java.util.Collections.emptyList();
    private void ensureStudentResponseIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        studentResponse_ = new java.util.ArrayList<StudentResponse>(studentResponse_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        StudentResponse, StudentResponse.Builder, StudentResponseOrBuilder> studentResponseBuilder_;

    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<StudentResponse> getStudentResponseList() {
      if (studentResponseBuilder_ == null) {
        return java.util.Collections.unmodifiableList(studentResponse_);
      } else {
        return studentResponseBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public int getStudentResponseCount() {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.size();
      } else {
        return studentResponseBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public StudentResponse getStudentResponse(int index) {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.get(index);
      } else {
        return studentResponseBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder setStudentResponse(
        int index, StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.set(index, value);
        onChanged();
      } else {
        studentResponseBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder setStudentResponse(
        int index, StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.set(index, builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.add(value);
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        int index, StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.add(index, value);
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.add(builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        int index, StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.add(index, builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder addAllStudentResponse(
        Iterable<? extends StudentResponse> values) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, studentResponse_);
        onChanged();
      } else {
        studentResponseBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder clearStudentResponse() {
      if (studentResponseBuilder_ == null) {
        studentResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        studentResponseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public Builder removeStudentResponse(int index) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.remove(index);
        onChanged();
      } else {
        studentResponseBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public StudentResponse.Builder getStudentResponseBuilder(
        int index) {
      return getStudentResponseFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public StudentResponseOrBuilder getStudentResponseOrBuilder(
        int index) {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.get(index);  } else {
        return studentResponseBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<? extends StudentResponseOrBuilder>
         getStudentResponseOrBuilderList() {
      if (studentResponseBuilder_ != null) {
        return studentResponseBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(studentResponse_);
      }
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public StudentResponse.Builder addStudentResponseBuilder() {
      return getStudentResponseFieldBuilder().addBuilder(
          StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public StudentResponse.Builder addStudentResponseBuilder(
        int index) {
      return getStudentResponseFieldBuilder().addBuilder(
          index, StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.rpc.proto.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<StudentResponse.Builder>
         getStudentResponseBuilderList() {
      return getStudentResponseFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        StudentResponse, StudentResponse.Builder, StudentResponseOrBuilder>
        getStudentResponseFieldBuilder() {
      if (studentResponseBuilder_ == null) {
        studentResponseBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            StudentResponse, StudentResponse.Builder, StudentResponseOrBuilder>(
                studentResponse_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        studentResponse_ = null;
      }
      return studentResponseBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.rpc.proto.StudentResponseList)
  }

  // @@protoc_insertion_point(class_scope:com.rpc.proto.StudentResponseList)
  private static final StudentResponseList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new StudentResponseList();
  }

  public static StudentResponseList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StudentResponseList>
      PARSER = new com.google.protobuf.AbstractParser<StudentResponseList>() {
    @Override
    public StudentResponseList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StudentResponseList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StudentResponseList> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<StudentResponseList> getParserForType() {
    return PARSER;
  }

  @Override
  public StudentResponseList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

