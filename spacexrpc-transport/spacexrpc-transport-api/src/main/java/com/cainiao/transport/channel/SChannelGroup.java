package com.cainiao.transport.channel;

import com.cainiao.transport.UnresolvedAddress;

import java.util.List;

public interface SChannelGroup {
    UnresolvedAddress remoteAddress();

    SChannel next();

    List<? extends SChannel> channels();
    boolean isEmpty();
    boolean add(SChannel sChannel);
    boolean remove(SChannel sChannel);
    int size();
    void setCapacity(int capacity);
    int getCapacity();

}
