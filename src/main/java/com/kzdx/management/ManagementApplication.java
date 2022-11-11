package com.kzdx.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Scanner;

@SpringBootApplication
@EnableSwagger2
public class ManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ManagementApplication.class);
	}

}
