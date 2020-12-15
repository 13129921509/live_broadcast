package com.cai.live.anchor.service

import com.cai.live.common.base.CustomerServerEndpointExporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import javax.annotation.PostConstruct

@Configuration
class AnchorConfig {

    @Autowired
    CustomerServerEndpointExporter endpointExporter

    @PostConstruct
    void init(){
        endpointExporter.addEndPoint(new DefaultWebSocketServer())
    }
}
