package com.devsuperior.dsdeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DsdeliverApplication extends SpringBootServletInitializer{

	@RequestMapping("/")
	@ResponseBody
	public static void main(String[] args) {
		SpringApplication.run(DsdeliverApplication.class, args);
	}

}
