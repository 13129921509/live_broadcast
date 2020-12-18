package com.cai.live.common.base

import org.apache.tomcat.websocket.server.WsServerContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.socket.server.standard.ServerEndpointExporter

class CustomerServerEndpointExporter extends ServerEndpointExporter{

    @Autowired
    WebApplicationContext wc

    boolean addEndPoint(CustomerEndpoint endpoint){
        try{
            super.serverContainer.addEndpoint(endpoint)
            return true
        }catch(Throwable t){
            t.printStackTrace()
            return false
        }

    }

    @Override
    void afterPropertiesSet() {
        null
    }
}
