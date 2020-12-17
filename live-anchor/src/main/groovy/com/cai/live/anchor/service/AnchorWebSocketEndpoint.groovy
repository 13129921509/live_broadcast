package com.cai.live.anchor.service

import com.cai.live.common.base.CustomerEndpoint
import com.cai.live.common.base.SocketCommonInfo
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.websocket.*

class AnchorWebSocketEndpoint extends CustomerEndpoint{

    private Logger logger = LoggerFactory.getLogger(AnchorWebSocketEndpoint.class);

    private String userId

    final static String INFO_KEY = "socketInfo"

    static AnchorWebSocketEndpoint create(String path, String userId){
        AnchorWebSocketEndpoint endpoint = new AnchorWebSocketEndpoint()
        endpoint.path = path
        endpoint.userId = userId
        endpoint.addUserProperties(INFO_KEY, new SocketCommonInfo())
        return endpoint
    }

    @OnClose
    void onClose(Session session, CloseReason closeReason) {
        getInfo(session).delOneOpen()
        logger.info("[ 当前路径：${session.requestURI.path} , 当前连接数 : ${getInfo(session).openCount} ]")
    }


    //收到消息时执行
    @Override
    @OnMessage
    void onMessage(String message, Session session) throws IOException {
        logger.info("[ 消息：${message} ]")
        logger.info("[ 当前路径：${session.requestURI.path} , 当前连接数 : ${getInfo(session).openCount} ]")
    }

    @OnError
    void onError(Session session, Throwable throwable) {

    }

    @OnOpen
    void onOpen(Session session, EndpointConfig config) {
        getInfo(session).incrementOneOpen()
        logger.info("[ 当前路径：${session.requestURI.path} , 当前连接数 : ${getInfo(session).openCount} ]")
    }

    static SocketCommonInfo getInfo(Session session){
        return session.userProperties.get(INFO_KEY) as SocketCommonInfo
    }

}
