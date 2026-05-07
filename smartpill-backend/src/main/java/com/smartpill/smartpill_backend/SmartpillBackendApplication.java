package com.smartpill.smartpill_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartpillBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartpillBackendApplication.class, args);
	}
}