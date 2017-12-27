package com.ylc.controller;

import com.ylc.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 16:53
 * description: xxx
 * own: Aratek
 */
@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong atomicLong = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(atomicLong.incrementAndGet(), String.format(template,name));
    }
}
