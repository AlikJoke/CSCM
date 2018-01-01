// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RequestFilterProto.proto

package ru.project.cscm.rest.protos;

/**
 * Protobuf type {@code model.RequestProto}
 */
public  final class RequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:model.RequestProto)
    RequestProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestProto.newBuilder() to construct.
  private RequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestProto() {
    id_ = 0;
    descx_ = "";
    isSended_ = false;
    requestDate_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
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
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            ru.project.cscm.rest.protos.RequestFilterProto.Builder subBuilder = null;
            if (filter_ != null) {
              subBuilder = filter_.toBuilder();
            }
            filter_ = input.readMessage(ru.project.cscm.rest.protos.RequestFilterProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(filter_);
              filter_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            descx_ = s;
            break;
          }
          case 32: {

            isSended_ = input.readBool();
            break;
          }
          case 40: {

            requestDate_ = input.readInt64();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.project.cscm.rest.protos.CscmProto.internal_static_model_RequestProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.project.cscm.rest.protos.CscmProto.internal_static_model_RequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.project.cscm.rest.protos.RequestProto.class, ru.project.cscm.rest.protos.RequestProto.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int FILTER_FIELD_NUMBER = 2;
  private ru.project.cscm.rest.protos.RequestFilterProto filter_;
  /**
   * <code>.model.RequestFilterProto filter = 2;</code>
   */
  public boolean hasFilter() {
    return filter_ != null;
  }
  /**
   * <code>.model.RequestFilterProto filter = 2;</code>
   */
  public ru.project.cscm.rest.protos.RequestFilterProto getFilter() {
    return filter_ == null ? ru.project.cscm.rest.protos.RequestFilterProto.getDefaultInstance() : filter_;
  }
  /**
   * <code>.model.RequestFilterProto filter = 2;</code>
   */
  public ru.project.cscm.rest.protos.RequestFilterProtoOrBuilder getFilterOrBuilder() {
    return getFilter();
  }

  public static final int DESCX_FIELD_NUMBER = 3;
  private volatile java.lang.Object descx_;
  /**
   * <code>string descx = 3;</code>
   */
  public java.lang.String getDescx() {
    java.lang.Object ref = descx_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      descx_ = s;
      return s;
    }
  }
  /**
   * <code>string descx = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDescxBytes() {
    java.lang.Object ref = descx_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      descx_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ISSENDED_FIELD_NUMBER = 4;
  private boolean isSended_;
  /**
   * <code>bool isSended = 4;</code>
   */
  public boolean getIsSended() {
    return isSended_;
  }

  public static final int REQUESTDATE_FIELD_NUMBER = 5;
  private long requestDate_;
  /**
   * <code>int64 requestDate = 5;</code>
   */
  public long getRequestDate() {
    return requestDate_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (filter_ != null) {
      output.writeMessage(2, getFilter());
    }
    if (!getDescxBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, descx_);
    }
    if (isSended_ != false) {
      output.writeBool(4, isSended_);
    }
    if (requestDate_ != 0L) {
      output.writeInt64(5, requestDate_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (filter_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFilter());
    }
    if (!getDescxBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, descx_);
    }
    if (isSended_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, isSended_);
    }
    if (requestDate_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, requestDate_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.project.cscm.rest.protos.RequestProto)) {
      return super.equals(obj);
    }
    ru.project.cscm.rest.protos.RequestProto other = (ru.project.cscm.rest.protos.RequestProto) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (hasFilter() == other.hasFilter());
    if (hasFilter()) {
      result = result && getFilter()
          .equals(other.getFilter());
    }
    result = result && getDescx()
        .equals(other.getDescx());
    result = result && (getIsSended()
        == other.getIsSended());
    result = result && (getRequestDate()
        == other.getRequestDate());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    if (hasFilter()) {
      hash = (37 * hash) + FILTER_FIELD_NUMBER;
      hash = (53 * hash) + getFilter().hashCode();
    }
    hash = (37 * hash) + DESCX_FIELD_NUMBER;
    hash = (53 * hash) + getDescx().hashCode();
    hash = (37 * hash) + ISSENDED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsSended());
    hash = (37 * hash) + REQUESTDATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRequestDate());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.project.cscm.rest.protos.RequestProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.project.cscm.rest.protos.RequestProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code model.RequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:model.RequestProto)
      ru.project.cscm.rest.protos.RequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.project.cscm.rest.protos.CscmProto.internal_static_model_RequestProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.project.cscm.rest.protos.CscmProto.internal_static_model_RequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.project.cscm.rest.protos.RequestProto.class, ru.project.cscm.rest.protos.RequestProto.Builder.class);
    }

    // Construct using ru.project.cscm.rest.protos.RequestProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;

      if (filterBuilder_ == null) {
        filter_ = null;
      } else {
        filter_ = null;
        filterBuilder_ = null;
      }
      descx_ = "";

      isSended_ = false;

      requestDate_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.project.cscm.rest.protos.CscmProto.internal_static_model_RequestProto_descriptor;
    }

    public ru.project.cscm.rest.protos.RequestProto getDefaultInstanceForType() {
      return ru.project.cscm.rest.protos.RequestProto.getDefaultInstance();
    }

    public ru.project.cscm.rest.protos.RequestProto build() {
      ru.project.cscm.rest.protos.RequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ru.project.cscm.rest.protos.RequestProto buildPartial() {
      ru.project.cscm.rest.protos.RequestProto result = new ru.project.cscm.rest.protos.RequestProto(this);
      result.id_ = id_;
      if (filterBuilder_ == null) {
        result.filter_ = filter_;
      } else {
        result.filter_ = filterBuilder_.build();
      }
      result.descx_ = descx_;
      result.isSended_ = isSended_;
      result.requestDate_ = requestDate_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.project.cscm.rest.protos.RequestProto) {
        return mergeFrom((ru.project.cscm.rest.protos.RequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.project.cscm.rest.protos.RequestProto other) {
      if (other == ru.project.cscm.rest.protos.RequestProto.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.hasFilter()) {
        mergeFilter(other.getFilter());
      }
      if (!other.getDescx().isEmpty()) {
        descx_ = other.descx_;
        onChanged();
      }
      if (other.getIsSended() != false) {
        setIsSended(other.getIsSended());
      }
      if (other.getRequestDate() != 0L) {
        setRequestDate(other.getRequestDate());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.project.cscm.rest.protos.RequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.project.cscm.rest.protos.RequestProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private ru.project.cscm.rest.protos.RequestFilterProto filter_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.project.cscm.rest.protos.RequestFilterProto, ru.project.cscm.rest.protos.RequestFilterProto.Builder, ru.project.cscm.rest.protos.RequestFilterProtoOrBuilder> filterBuilder_;
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public boolean hasFilter() {
      return filterBuilder_ != null || filter_ != null;
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public ru.project.cscm.rest.protos.RequestFilterProto getFilter() {
      if (filterBuilder_ == null) {
        return filter_ == null ? ru.project.cscm.rest.protos.RequestFilterProto.getDefaultInstance() : filter_;
      } else {
        return filterBuilder_.getMessage();
      }
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public Builder setFilter(ru.project.cscm.rest.protos.RequestFilterProto value) {
      if (filterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        filter_ = value;
        onChanged();
      } else {
        filterBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public Builder setFilter(
        ru.project.cscm.rest.protos.RequestFilterProto.Builder builderForValue) {
      if (filterBuilder_ == null) {
        filter_ = builderForValue.build();
        onChanged();
      } else {
        filterBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public Builder mergeFilter(ru.project.cscm.rest.protos.RequestFilterProto value) {
      if (filterBuilder_ == null) {
        if (filter_ != null) {
          filter_ =
            ru.project.cscm.rest.protos.RequestFilterProto.newBuilder(filter_).mergeFrom(value).buildPartial();
        } else {
          filter_ = value;
        }
        onChanged();
      } else {
        filterBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public Builder clearFilter() {
      if (filterBuilder_ == null) {
        filter_ = null;
        onChanged();
      } else {
        filter_ = null;
        filterBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public ru.project.cscm.rest.protos.RequestFilterProto.Builder getFilterBuilder() {
      
      onChanged();
      return getFilterFieldBuilder().getBuilder();
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    public ru.project.cscm.rest.protos.RequestFilterProtoOrBuilder getFilterOrBuilder() {
      if (filterBuilder_ != null) {
        return filterBuilder_.getMessageOrBuilder();
      } else {
        return filter_ == null ?
            ru.project.cscm.rest.protos.RequestFilterProto.getDefaultInstance() : filter_;
      }
    }
    /**
     * <code>.model.RequestFilterProto filter = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.project.cscm.rest.protos.RequestFilterProto, ru.project.cscm.rest.protos.RequestFilterProto.Builder, ru.project.cscm.rest.protos.RequestFilterProtoOrBuilder> 
        getFilterFieldBuilder() {
      if (filterBuilder_ == null) {
        filterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.project.cscm.rest.protos.RequestFilterProto, ru.project.cscm.rest.protos.RequestFilterProto.Builder, ru.project.cscm.rest.protos.RequestFilterProtoOrBuilder>(
                getFilter(),
                getParentForChildren(),
                isClean());
        filter_ = null;
      }
      return filterBuilder_;
    }

    private java.lang.Object descx_ = "";
    /**
     * <code>string descx = 3;</code>
     */
    public java.lang.String getDescx() {
      java.lang.Object ref = descx_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        descx_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string descx = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDescxBytes() {
      java.lang.Object ref = descx_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        descx_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string descx = 3;</code>
     */
    public Builder setDescx(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      descx_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string descx = 3;</code>
     */
    public Builder clearDescx() {
      
      descx_ = getDefaultInstance().getDescx();
      onChanged();
      return this;
    }
    /**
     * <code>string descx = 3;</code>
     */
    public Builder setDescxBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      descx_ = value;
      onChanged();
      return this;
    }

    private boolean isSended_ ;
    /**
     * <code>bool isSended = 4;</code>
     */
    public boolean getIsSended() {
      return isSended_;
    }
    /**
     * <code>bool isSended = 4;</code>
     */
    public Builder setIsSended(boolean value) {
      
      isSended_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSended = 4;</code>
     */
    public Builder clearIsSended() {
      
      isSended_ = false;
      onChanged();
      return this;
    }

    private long requestDate_ ;
    /**
     * <code>int64 requestDate = 5;</code>
     */
    public long getRequestDate() {
      return requestDate_;
    }
    /**
     * <code>int64 requestDate = 5;</code>
     */
    public Builder setRequestDate(long value) {
      
      requestDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 requestDate = 5;</code>
     */
    public Builder clearRequestDate() {
      
      requestDate_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:model.RequestProto)
  }

  // @@protoc_insertion_point(class_scope:model.RequestProto)
  private static final ru.project.cscm.rest.protos.RequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.project.cscm.rest.protos.RequestProto();
  }

  public static ru.project.cscm.rest.protos.RequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestProto>
      PARSER = new com.google.protobuf.AbstractParser<RequestProto>() {
    public RequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestProto> getParserForType() {
    return PARSER;
  }

  public ru.project.cscm.rest.protos.RequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
