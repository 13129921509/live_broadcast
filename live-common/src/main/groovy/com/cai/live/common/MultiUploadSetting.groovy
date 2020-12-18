package com.cai.live.common

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("multi-upload")
class MultiUploadSetting {

    String path

}
