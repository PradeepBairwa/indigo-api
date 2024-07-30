package com.indigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirIndiGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirIndiGoApplication.class, args);
	}

}
