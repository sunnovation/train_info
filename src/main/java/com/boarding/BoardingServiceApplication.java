package com.boarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BoardingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardingServiceApplication.class, args);
	}

}
