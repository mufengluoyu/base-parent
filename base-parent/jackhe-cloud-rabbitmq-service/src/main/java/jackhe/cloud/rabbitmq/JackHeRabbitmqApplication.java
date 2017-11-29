package jackhe.cloud.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * 
 * @EnableTurbineStream主要作用是引入了turbine的微服务监控
 * @author hechangzhi 2017年11月22日
 *
 */
@SpringBootApplication
@EnableTurbineStream
public class JackHeRabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(JackHeRabbitmqApplication.class, args);
	}
}
