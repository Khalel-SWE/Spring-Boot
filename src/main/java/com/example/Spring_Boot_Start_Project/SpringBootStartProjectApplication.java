package com.example.Spring_Boot_Start_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//Accept-Language
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class SpringBootStartProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartProjectApplication.class, args);
	}
}
