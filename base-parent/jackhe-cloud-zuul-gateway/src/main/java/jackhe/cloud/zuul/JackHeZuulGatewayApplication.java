package jackhe.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import jackhe.cloud.zuul.filter.PreRequestFilter;

/**
 * 网关服务实现路由的功能，主要实现Eureka的注册发现的服务和接口连接。的路由器功能。
 * 由于现实情况，网关的消费端都是在app多个终端，因此使用negix代理，将对外实现负载均衡和对外域名解析的功能。
 * @EnableZuulProxy 声明一个zuul代理，该代理使用Ribbon来定位注册在EurekaServer的微服务，还整合了Hystrix容错
 * @author hechangzhi 2017年11月30日
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class JackHeZuulGatewayApplication {
	
	/**
	 * 启动并且给过滤器使用
	 * @return
	 */
	@Bean
	public PreRequestFilter preRequestFilter(){
		return new PreRequestFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JackHeZuulGatewayApplication.class, args);
	}

}
