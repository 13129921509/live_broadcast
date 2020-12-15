package com.cai.live.common.base

import org.apache.tomcat.websocket.server.Constants
import org.apache.tomcat.websocket.server.WsSci
import org.apache.tomcat.websocket.server.WsServerContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.WebApplicationObjectSupport
import org.springframework.web.socket.server.standard.ServerEndpointExporter

import javax.annotation.PostConstruct
import javax.servlet.ServletContext
import javax.websocket.server.ServerContainer

@Component
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
