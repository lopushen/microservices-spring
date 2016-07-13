package lab4.eureka.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4EurekaSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaSubjectApplication.class, args);
	}
}