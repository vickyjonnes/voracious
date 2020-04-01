package edu.micoservices.moviesdiscoveryservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/properties/application.properties")
@SpringBootApplication
@EnableEurekaServer
public class MoviesDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesDiscoveryServiceApplication.class, args);
	}

}
