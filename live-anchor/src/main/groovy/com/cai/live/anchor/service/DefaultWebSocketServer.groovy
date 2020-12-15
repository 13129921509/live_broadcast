package com.cai.live.anchor.service

import com.cai.live.common.base.CustomerEndpoint
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin

import javax.websocket.CloseReason
import javax.websocket.EndpointConfig
import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@CrossOrigin("http://192.168.81.28:8081/")
//@ServerEndpoint("/socket/v1/anchor/{userId}")
//@Service
class DefaultWebSocketServer extends CustomerEndpoint{

    private static String userId

    private Logger logger = LoggerFactory.getLogger(DefaultWebSocketServer.class);

    @Override
    String getPath() {
        return "/socket/v1/anchor/{userId}"
    }

    @Override
    void onClose(Session session, CloseReason closeReason) {
        logger.debug("$userId close")
    }


    //收到消息时执行
    @Override
    void onMessage(String message, Session session) throws IOException {
        logger.debug("收到用户{}的消息{}",userId, message);
        session.getBasicRemote().sendText("收到 "+ userId+" 的消息 "); //回复用户
    }

    @Override
    void onError(Session session, Throwable throwable) {
        logger.debug("用户id为：{}的连接发送错误", session);
        throwable.printStackTrace();

    }

    @Override
    void onOpen(Session session, EndpointConfig config) {
//        userId = user
        logger.debug("$session open")
    }

}
