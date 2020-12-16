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

abstract class CustomerEndpoint implements ServerEndpointConfig{


    final private Map<String, Object> userProperties = [:]

    private static ServerEndpointConfig config

    protected String path

    abstract void onMessage(String message, Session session)

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
       return Builder.create(this.class, getPath()).configurator().build().configurator
    }

    List<Class<? extends Encoder>> getEncoders() {
        return []
    }

    List<Class<? extends Decoder>> getDecoders() {
        return []
    }

    Map<String, Object> getUserProperties() {
        return userProperties
    }

    @Override
    String getPath() {
        return path
    }
}