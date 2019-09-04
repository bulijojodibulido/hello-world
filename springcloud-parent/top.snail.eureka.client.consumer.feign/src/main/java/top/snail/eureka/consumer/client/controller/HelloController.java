package top.snail.eureka.consumer.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.snail.eureka.consumer.feign.HelloFeign;

@RestController
public class HelloController {
	
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping(value="/hello/{name}")
	public String hello(@PathVariable String name) {
		return this.helloFeign.hello(name);
	}
}
