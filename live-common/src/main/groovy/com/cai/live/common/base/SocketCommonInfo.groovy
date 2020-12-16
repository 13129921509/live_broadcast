package com.cai.live.common.base

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

class SocketCommonInfo {

    final AtomicLong openCount = new AtomicLong(0L)

    final AtomicLong allCount = new AtomicLong(0L)

    final AtomicLong closeCount = new AtomicLong(0L)

    void incrementOneOpen(){
        openCount.incrementAndGet()
        allCount.incrementAndGet()
    }

    void delOneOpen(){
        closeCount.incrementAndGet()
    }
}
