package com.cainiao.transport.netty.channel;

import com.cainiao.common.atomic.AtomicUpdater;
import com.cainiao.transport.UnresolvedAddress;
import com.cainiao.transport.channel.SChannel;
import com.cainiao.transport.channel.SChannelGroup;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class NettyChannelGroup implements SChannelGroup {

    private static final AtomicReferenceFieldUpdater<CopyOnWriteArrayList, Object[]> channelsUpdate =
            AtomicUpdater.newAtomicReferenceFieldUpdater(CopyOnWriteArrayList.class, Object[].class, "array");
    private static final AtomicIntegerFieldUpdater<NettyChannel> signalNeededUpdater = AtomicIntegerFieldUpdater.newUpdater(NettyChannel.class, "signalNeeded");
    private static final AtomicIntegerFieldUpdater<NettyChannel> indexUpdate = AtomicIntegerFieldUpdater.newUpdater(NettyChannel.class, "index");
    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
       protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSz");
        }
    };



    @Override
    public UnresolvedAddress remoteAddress() {
        return null;
    }

    @Override
    public SChannel next() {
        return null;
    }

    @Override
    public List<? extends SChannel> channels() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(SChannel sChannel) {
        return false;
    }

    @Override
    public boolean remove(SChannel sChannel) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void setCapacity(int capacity) {

    }

    @Override
    public int getCapacity() {
        return 0;
    }
}
