package top.snail.eureka.client.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 此类必须加，否则 提供者宕机，hystrix生效 返回 hytrix page  。
 * zuul虽然调用了consumer-hystrix，但是不会调用它的fallback 反而会抛出500错误
 * @author uid
 *
 */
@Component	//zuul环境中启动它作为一个断路器
public class HelloFallback implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		return "*"; //路由 发布所有
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {

			@Override //返回内容
			public InputStream getBody() throws IOException {
				String msg = "zuul hystrix page"; //json
				return new 	ByteArrayInputStream(msg.getBytes()) ;
			}

			@Override  //头信息
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}

			@Override	//状态码
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}

			@Override //状态码的值
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override //状态描述
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override
			public void close() {
				
			}};
	}

}
