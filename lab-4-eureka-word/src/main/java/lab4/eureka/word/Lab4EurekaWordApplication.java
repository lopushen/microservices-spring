package lab4.eureka.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class Lab4EurekaWordApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaWordApplication.class, args);
	}

	@PostConstruct
	public void post() {
		System.out.println(env.getProperty("words"));
		System.out.println(env.getProperty("spring.profiles.active"));
	}
}
