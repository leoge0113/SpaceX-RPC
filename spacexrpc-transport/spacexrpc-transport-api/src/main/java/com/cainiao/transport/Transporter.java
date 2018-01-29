package com.cainiao.transport;

public interface Transporter {
    Protocol protocal();

    enum Protocol {
        TCP
    }
}
