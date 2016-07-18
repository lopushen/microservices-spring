package lab4.eureka.noun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4EurekaNounApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaNounApplication.class, args);
	}
}
