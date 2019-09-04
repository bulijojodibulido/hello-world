package top.snail.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientProviderUser2App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderUser2App.class, args);
	}
}
