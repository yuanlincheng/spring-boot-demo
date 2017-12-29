package com.ylc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 16:11
 * description: xxx
 * own: Araek
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("Message", "Hello World");
    }
}
