package com.ylc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 11:32
 * description: xxx
 * own: Aratek
 */
@RestController
public class RouteWebController {
    @GetMapping("/available")
    public String available() {
        return "the rout book available";
    }

    @GetMapping("/book")
    public String book() {
        return "the rout book ok";
    }
}
