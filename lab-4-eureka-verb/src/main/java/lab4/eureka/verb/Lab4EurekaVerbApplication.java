package lab4.eureka.verb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class Lab4EurekaVerbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaVerbApplication.class, args);
	}
}
