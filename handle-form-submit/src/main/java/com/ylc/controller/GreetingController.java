package com.ylc.controller;

import com.ylc.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 9:54
 * description: xxx
 * own: Aratek
 */
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting(322123,"jgiuisdsdyui"));
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSub(@ModelAttribute Greeting greeting) {
        return "result";
    }
}
