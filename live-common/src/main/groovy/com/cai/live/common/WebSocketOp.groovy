package com.cai.live.common

import com.cai.live.common.base.CustomerEndpoint
import com.cai.live.common.base.CustomerServerEndpointExporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.socket.server.standard.ServerEndpointExporter

@Component
class WebSocketOp {

    @Autowired
    CustomerServerEndpointExporter endpointExporter

    boolean addEndPoint(CustomerEndpoint endpoint){
        endpointExporter.addEndPoint(endpoint)
    }

}
