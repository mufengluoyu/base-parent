package jackhe.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * @EnableConfigServer主要作用是作为配置中心的服务提供
 * @author hechangzhi 2017年12月8日
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class JackHeConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(JackHeConfigApplication.class, args);
	}
}
