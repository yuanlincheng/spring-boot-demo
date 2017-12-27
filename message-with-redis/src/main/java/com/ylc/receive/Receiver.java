package com.ylc.receive;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 11:31
 * description: xxx
 * own: Aratek
 */
@AllArgsConstructor
public class Receiver {
    private static Logger log = LoggerFactory.getLogger(Receiver.class);

    //一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待
    private CountDownLatch countDownLatch;

    public void receiveMessage(String message) {
        log.info("Received < {} >",message);
        countDownLatch.countDown();
    }
}
