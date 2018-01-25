package com.cainiao.transport.netty.handle.acceptor;

import com.cainiao.transport.exception.IoSignals;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState idleState = ((IdleStateEvent) evt).state();
            if (idleState == IdleState.READER_IDLE) {
                throw IoSignals.READER_IDLE;
            } else {
                super.userEventTriggered(ctx, evt);
            }
        }
    }
}
