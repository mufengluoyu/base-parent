package com.jackhe.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author hechangzhi 2017年11月14日
 * @EnableDiscoveryClient  用于注册到eureka的客户端兼容其他注册发现 或者 @EnableEurekaClient只能作用于Eureka的注册发现
 * @SpringBootApplication 启动springboot的注解发现
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JackHeUserServiceApplication{
	public static void main(String[] args) {
		SpringApplication.run(JackHeUserServiceApplication.class, args);
	}
}
