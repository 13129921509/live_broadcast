package com.cai.live.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin

import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@CrossOrigin("http://192.168.81.28:8081/")
@ServerEndpoint("/socket/v1/anchor/{userId}")
@Service
class DefaultWebSocketServer {

    private static String userId

    private Logger logger = LoggerFactory.getLogger(DefaultWebSocketServer.class);

    @OnOpen
    void onOpen(@PathParam("userId") String user, Session session){
        userId = user
        logger.debug("$userId open")
    }

    //关闭时执行
    @OnClose
    void onClose(){
        logger.debug("$userId close")
    }

    //收到消息时执行
    @OnMessage
    void onMessage(String message, Session session) throws IOException {
        logger.debug("收到用户{}的消息{}",userId, message);
        session.getBasicRemote().sendText("收到 "+ userId +" 的消息 "); //回复用户
    }

    //连接错误时执行
    @OnError
    void onError(Session session, Throwable error){
        logger.debug("用户id为：{}的连接发送错误", userId);
        error.printStackTrace();
    }

}
