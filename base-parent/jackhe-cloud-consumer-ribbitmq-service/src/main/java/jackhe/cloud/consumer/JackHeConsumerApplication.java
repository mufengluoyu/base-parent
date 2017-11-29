package jackhe.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @EnableDiscoveryClient  用于注册到eureka的客户端兼容其他注册发现 或者 @EnableEurekaClient只能作用于Eureka的注册发现
 * @SpringBootApplication 启动springboot的注解
 * @EnableFeignClients 启动声明式，模板化的http客户端，可以调用其他的微服务的api
 * @EnableCircuitBreaker注解，这个注解的作用就是开启断路器功能原本的服务类也需要有一定的修改，首先是在原本调用的方法上加上@HystrixCommand
 * @author hechangzhi 2017年11月14日
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
//@EnableCircuitBreaker
public class JackHeConsumerApplication {
	/**
	 * @LoadBalanced 该注解可为resttemplate整合了ribbon客户端负载均衡的能力
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(JackHeConsumerApplication.class, args);
	}
}
