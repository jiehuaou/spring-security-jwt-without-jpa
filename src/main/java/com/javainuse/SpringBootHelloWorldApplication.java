package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		System.out.println(SpringVersion.getVersion());
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}