package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 9:47
 * description: xxx
 * own: Aratek
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void greeting() throws Exception {
        mvc.perform(get("/greeting")).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"content\":\"Hello, World!\"}"));
    }

}