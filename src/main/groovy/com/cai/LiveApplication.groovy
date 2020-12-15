package com.cai

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
class LiveApplication {

    static void main(String[] args) {
        SpringApplication.run(LiveApplication, args)
    }
}
