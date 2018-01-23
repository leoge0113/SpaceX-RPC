package com.cainiao.transport;

public abstract class SConnection {
    private final UnresolvedAddress address;

    public SConnection(UnresolvedAddress address) {
        this.address = address;
    }

    public UnresolvedAddress getAddress() {
        return address;
    }

    public void operationComplete(Runnable callback) {
        //default do nothing
    }

    public abstract void setReconnect(boolean reconnect);
}
