package top.snail.eureka.consumer.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import top.snail.eureka.consumer.feign.HelloFeign;

@RestController
public class HelloController {
	
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping(value="/hello/{name}")
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello(@PathVariable String name) {
		return this.helloFeign.hello(name);
	}
	
	//对应上面的方法，参数必须一致，当访问失败时，hystrix直接回调用此方法
	public String helloFallback(String name) {
		return "hystrix page";
	}
	
	
}
