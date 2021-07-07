package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/demo")
public class DemoController {
	//Unused field
        private int abc;

        private String ip = "127.0.0.1";

	@GetMapping("/hello")
	public String hello() {
		test1();
		return "hello";
	}

    	public void test1() {

        	String[] field = {"a", "b", "c", "s", "e"};

        	String s = "";
        	for (int i = 0; i < field.length; ++i) {
            		s = s + field[i];
        	}

        	System.out.println(ip);

    	}

    public Boolean shouldBeWarning() {
        return null;
    }
}
