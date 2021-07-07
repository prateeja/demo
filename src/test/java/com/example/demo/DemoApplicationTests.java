package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    "feature.foo.by.id=Y",
    "feature.new.foo=Y",
    "last.active.after=2018-03-14T00:00:00Z",
    "first.active.after=2999-03-15T00:00:00Z",
    "logging.level.org.flips=info"

}, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class DemoApplicationTests {

	@Autowired private MockMvc mvc;

	@Test
    public void givenValidDayOfWeek_APIAvailable() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo/hello"))
            .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
