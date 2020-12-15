package com.cai.live

import com.cai.LiveApplication
import com.cai.live.anchor.service.DefaultWebSocketServer
import com.cai.live.common.WebSocketOp
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = LiveApplication)
class LiveTest {

    @Autowired
    WebSocketOp webSocketOp

    @Test
    void addSocket(){
        webSocketOp.addEndPoint(new DefaultWebSocketServer())
    }
}
