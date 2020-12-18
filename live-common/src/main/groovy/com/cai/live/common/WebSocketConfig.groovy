package com.cai.live.common

import com.cai.live.common.base.CustomerServerEndpointExporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.server.standard.ServerEndpointExporter

@Configuration
class WebSocketConfig {

    @Bean
    CustomerServerEndpointExporter serverEndpointExporter(){
        return new CustomerServerEndpointExporter();
    }


}
