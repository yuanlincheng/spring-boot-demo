package com.ylc.listener;

import com.ylc.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 17:31
 * description: xxx
 * own: Aratek
 */
@Component
public class Receiver {
    private static Logger log = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "mailbox",containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        log.info("Received < {} >",email);
    }
}
