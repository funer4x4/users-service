package com.example.examen_liverpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamenLiverpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenLiverpoolApplication.class, args);
	}

}
