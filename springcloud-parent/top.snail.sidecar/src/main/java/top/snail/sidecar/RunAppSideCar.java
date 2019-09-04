package top.snail.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar  //sidecar
public class RunAppSideCar {

	public static void main(String[] args) {
		SpringApplication.run(RunAppSideCar.class, args);
	}
}
