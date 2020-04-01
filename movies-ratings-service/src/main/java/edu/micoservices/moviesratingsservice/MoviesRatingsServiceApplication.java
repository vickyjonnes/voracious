package edu.micoservices.moviesratingsservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/properties/application.properties")
@SpringBootApplication
@EnableEurekaClient
public class MoviesRatingsServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoviesRatingsServiceApplication.class, args);
	}

}
