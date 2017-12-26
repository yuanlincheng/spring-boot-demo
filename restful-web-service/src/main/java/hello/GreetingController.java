package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/26 13:58
 * description: xxx
 * own: Aratek
 */
//@RestController 相当于 @Controller and @ResponseBody
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong atomicLong = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(atomicLong.incrementAndGet(), String.format(template, name));
    }
}
