package com.sales_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.sales_project", "com.speedment.jpastreamer"})
public class SalesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesProjectApplication.class, args);
	}

}
