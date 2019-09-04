package top.snail.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientProviderUserApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderUserApp.class, args);
	}
}
