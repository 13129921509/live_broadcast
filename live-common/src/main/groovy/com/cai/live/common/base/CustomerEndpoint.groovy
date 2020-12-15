package com.cai.live.common.base

import javax.websocket.CloseReason
import javax.websocket.Decoder
import javax.websocket.Encoder
import javax.websocket.Endpoint
import javax.websocket.EndpointConfig
import javax.websocket.Extension
import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpointConfig
import static javax.websocket.server.ServerEndpointConfig.*

abstract class CustomerEndpoint extends Endpoint implements ServerEndpointConfig{

    private static ServerEndpointConfig config

    abstract String getPath()

    @OnClose
    abstract void onClose(Session session, CloseReason closeReason)

    @OnMessage
    abstract void onMessage(String message, Session session)

    @OnError
    abstract void onError(Session session, Throwable throwable)

    @OnOpen
    abstract void onOpen(Session session, EndpointConfig config)

    Class<?> getEndpointClass() {
        return this.class
    }

    List<String> getSubprotocols() {
        return []
    }

    List<Extension> getExtensions() {
        return []
    }

    Configurator getConfigurator() {
        if (!config)
            config = Builder.create(this.class, getPath()).configurator().build()
        return config.configurator
    }

    List<Class<? extends Encoder>> getEncoders() {
        return []
    }

    List<Class<? extends Decoder>> getDecoders() {
        return []
    }

    Map<String, Object> getUserProperties() {
        return [:]
    }
}