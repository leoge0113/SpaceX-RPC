package com.cainiao.transport;

public class UnresolvedAddress {
    private final String host;
    private final int port;

    public UnresolvedAddress(String host, int port) {
        if (host.isEmpty() || host == null) {
            throw new NullPointerException("host can be empty!");
        }
        if (port < 0 || port > 0xFFFF) {
            throw new IllegalArgumentException("port is out of range, port" + port);
        }
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        UnresolvedAddress that = (UnresolvedAddress) o;
        return that.port == port && that.host.equals(host);
    }

    @Override
    public int hashCode() {
        int result = host.hashCode();
        return 31 * result + port;
    }

    @Override
    public String toString() {
        return host + ":" + port;
    }
}
