package com.cainiao.transport;

import com.cainiao.transport.channel.CopyOnWriteGroupList;
import com.cainiao.transport.channel.DirectoryJChannelGroup;
import com.cainiao.transport.channel.SChannelGroup;
import com.cainiao.transport.processor.ConsumerProcessor;

import java.util.Collection;

public interface SConnector<C> extends Transporter {
    JConfig config();

    void withProcessor(ConsumerProcessor processor);

    C connect(UnresolvedAddress addredd);

    C connect(UnresolvedAddress address, boolean async);

    SChannelGroup group(UnresolvedAddress address);

    Collection<SChannelGroup> groups();

    boolean addChannelGroup(Directory directory, SChannelGroup sChannelGroup);

    boolean removeChannleGroup(Directory directory, SChannelGroup sChannelGroup);

    CopyOnWriteGroupList directory(Directory directory);

    boolean isDirectoryAvailable(Directory directory);

    DirectoryJChannelGroup directoryGroup();

    JConnectionManager connectionManager();

    /**
     * Shutdown the server.
     */
    void shutdownGracefully();

    interface ConnectionWatcher {

        /**
         * Start to connect to server.
         */
        void start();

        /**
         * Wait until the connections is available or timeout,
         * if available return true, otherwise return false.
         */
        boolean waitForAvailable(long timeoutMillis);
    }
}
