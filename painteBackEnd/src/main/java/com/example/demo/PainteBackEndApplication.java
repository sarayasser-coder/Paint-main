package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import shapescontroller.ShapesFactory;

@SpringBootApplication
@ComponentScan(basePackageClasses=ShapesFactory.class)
public class PainteBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(PainteBackEndApplication.class, args);
	}

}

