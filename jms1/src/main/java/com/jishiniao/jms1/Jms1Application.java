package com.jishiniao.jms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Jms1Application {

	public static void main(String[] args) {
		SpringApplication.run(Jms1Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		String str = "asdfjasdf";
		System.out.println(str);
		return String.format("Hello %s!", name);
	}
}
