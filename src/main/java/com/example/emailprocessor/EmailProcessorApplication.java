package com.example.emailprocessor;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class EmailProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailProcessorApplication.class, args);
	}

}
