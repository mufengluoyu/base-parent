package jackhe.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * 
 * 该类为Feign的配置类 为Feign禁用Hystrix功能  
 * 注意：该不应该在主应用程序上下文的@ComponentScan中。
 * 
 * 不建议使用该标签，该标签标示自己定义是否启用返回参数
 * 
 * 
 * @author hechangzhi 2017年11月29日
 *
 */
@Configuration
public class FeignDisableHystrixConfiguration {
	@Bean  
	@Scope("prototype")   
	public Feign.Builder feignBuilder() {  
	    return Feign.builder();  
	} 
}
