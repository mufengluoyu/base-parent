package jackhe.cloud.consumer.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jackhe.cloud.config.FeignDisableHystrixConfiguration;
import jackhe.cloud.consumer.entity.User;
import jackhe.cloud.user.common.vo.UserBaseVo;
/**
 * 不建议使用继承接口实现，可以将该接口抽象出来放入到一个jar包当中，类似dubbo的调用
 * 每个微服务根据自身需求新建接口实现
 * feign会自动使用断路器hystrix，其中容错机制，熔断，降级，分流，异步rpc
 * @FeignClient 用于发现调用的微服务，以及创建负载均衡器，   value为Eureka注册的服务名，会将注册的jackhe-cloud-user-two-service的所有服务方法都禁止使用断路器
 * 				FeignDisableHystrixConfiguration禁用熔断器针对的是该类的所有方法
 * @author hechangzhi 2017年11月14日
 *
 */
@FeignClient(value="jackhe-cloud-user-two-service",configuration=FeignDisableHystrixConfiguration.class)
public interface JackHeUserFeignStopHystrix {
	
	/**
	 * get传参
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@RequestParam("id") Long id);
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public UserBaseVo findByUserId(@RequestParam("id") Long id);
	
	@RequestMapping(value="/user/get",method=RequestMethod.GET)
	public User getUserGet(@RequestParam Map<String,Object> map);
	
	@RequestMapping(value="/testUser")
	public String testUser();
	
	
	/**
	 * post传值
	 * @param userBase
	 * @return
	 */
	@RequestMapping(value = "/user/post", method = RequestMethod.POST)
	public UserBaseVo getUserPost(UserBaseVo userBase);
}
