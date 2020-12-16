package com.cai.live.anchor.service

import com.cai.live.common.base.CustomerEndpoint
import com.cai.live.common.base.SocketCommonInfo
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.websocket.*

class AnchorWebSocketEndpoint extends CustomerEndpoint{

    private Logger logger = LoggerFactory.getLogger(AnchorWebSocketEndpoint.class);

    private String userId

    private SocketCommonInfo socketInfo = new SocketCommonInfo()

    AnchorWebSocketEndpoint(String userId, String path) {
        super(path)
        this.userId = userId
    }

    @Override
    String getPath() {
        return path
    }

    @OnClose
    void onClose(Session session, CloseReason closeReason) {
        socketInfo.delOneOpen()
        logger.info("[ 当前连接数 : $socketInfo.openCount ]")
    }


    //收到消息时执行
    @Override
    @OnMessage
    void onMessage(String message, Session session) throws IOException {

    }

    @OnError
    void onError(Session session, Throwable throwable) {

    }

    @OnOpen
    void onOpen(Session session, EndpointConfig config) {
        socketInfo.incrementOneOpen()
        logger.info("[ 当前连接数 : $socketInfo.openCount ]")
    }

}
