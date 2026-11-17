package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaserver2Application.class, args);
	}

}
