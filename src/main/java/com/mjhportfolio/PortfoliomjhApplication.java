package com.mjhportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PortfoliomjhApplication {

    @Autowired
    private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(PortfoliomjhApplication.class, args);
	}
       
}
