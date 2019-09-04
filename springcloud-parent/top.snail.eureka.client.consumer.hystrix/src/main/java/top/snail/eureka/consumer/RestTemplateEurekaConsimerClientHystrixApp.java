package top.snail.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients //开启feign
public class RestTemplateEurekaConsimerClientHystrixApp {


	public static void main(String[] args) {
		SpringApplication.run(RestTemplateEurekaConsimerClientHystrixApp.class, args);
	}
}
