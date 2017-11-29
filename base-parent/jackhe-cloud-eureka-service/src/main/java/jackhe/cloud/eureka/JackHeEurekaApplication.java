package jackhe.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @EnableEurekaServer 注解eureka的服务发现的微服务
 * @author hechangzhi 2017年11月14日
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class JackHeEurekaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JackHeEurekaApplication.class, args);
	}
}
