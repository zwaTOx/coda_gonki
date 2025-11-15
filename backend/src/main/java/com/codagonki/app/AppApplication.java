package com.codagonki.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codagonki.app.config.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class) 
@EnableWebMvc
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
