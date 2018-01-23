package com.cainiao.transport.netty.channel;

import com.cainiao.transport.channel.SChannel;
import com.cainiao.transport.channel.SFutureListener;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.net.SocketAddress;


public class NettyChannel implements SChannel {
    private static final AttributeKey<NettyChannel> NETTY_CHANNEL_KEY = AttributeKey.valueOf("netty.channel");
    private final Channel channel;

    public static NettyChannel attachChannel(Channel channel) {
        Attribute<NettyChannel> att = channel.attr(NETTY_CHANNEL_KEY);
        NettyChannel nettyChannel = att.get();
        if (nettyChannel == null) {
            nettyChannel = new NettyChannel(channel);
            NettyChannel nChannel1 = att.setIfAbsent(nettyChannel);
            if (nChannel1 == null) {
                nChannel1 = nettyChannel;
            }
        }
        return nettyChannel;
    }

    public NettyChannel(Channel channel) {
        this.channel = channel;
    }

    public Channel channel() {
        return channel;
    }

    @Override
    public String id() {
        return channel.id().asShortText();
    }

    @Override
    public boolean isActive() {
        return channel.isActive();
    }

    @Override
    public boolean inIoThread() {
        return channel.eventLoop().inEventLoop();
    }

    @Override
    public SocketAddress localAddress() {
        return channel.localAddress();
    }

    @Override
    public SocketAddress remoteAddress() {
        return channel.remoteAddress();
    }

    @Override
    public boolean isWritable() {
        return channel.isWritable();
    }

    @Override
    public boolean isMarkedReconnect() {
        return true;//?
    }

    @Override
    public boolean isAutoRead() {
        return channel.config().isAutoRead();
    }

    @Override
    public void setAutoRead(boolean autoRead) {
        channel.config().setAutoRead(autoRead);
    }

    @Override
    public SChannel close() {
        channel.close();
        return this;
    }

    @Override
    public SChannel close(final SFutureListener<SChannel> listener) {
        SChannel schannel = this;
        channel.close().addListener((ChannelFutureListener) (future) -> {
            if (future.isSuccess()) {
                listener.operationSuccess(schannel);
            } else {
                listener.operationFailure(schannel, future.cause());
            }
        });
        return schannel;
    }

    @Override
    public SChannel write(Object msg) {
        channel.writeAndFlush(msg, channel.voidPromise());//没看懂
        return this;
    }

    @Override
    public SChannel write(Object msg, SFutureListener<SChannel> listener) {
        SChannel sChannel = this;
        channel.writeAndFlush(msg).addListener((ChannelFutureListener) (future) -> {
            if (future.isSuccess()) {
                listener.operationSuccess(sChannel);
            } else {
                listener.operationFailure(sChannel, future.cause());
            }
        });
        return sChannel;
    }

    @Override
    public boolean equals(Object object) {
        return object == this || (object instanceof NettyChannel && this.channel.equals(((NettyChannel) object).channel));
    }

    @Override
    public int hashCode() {
        return this.channel.hashCode();
    }

    @Override
    public String toString() {
        return channel.toString();
    }
}

