package jackhe.cloud.consumer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jackhe.cloud.consumer.entity.User;
import jackhe.cloud.consumer.feign.JackHeUserFeign;
import jackhe.cloud.consumer.feign.JackHeUserFeignFactoryHystrix;
import jackhe.cloud.consumer.feign.JackHeUserFeignStopHystrix;
import jackhe.cloud.user.common.vo.UserBaseVo;

@RestController
public class JackHeConsumerController {
	
	private static final Logger logger =  (Logger) LoggerFactory.getLogger(JackHeConsumerController.class);
	
	@Autowired
	private JackHeUserFeign jackHeUserService;	//正常无问题的情况
	
//	@Autowired
//	private JackHeUserFeignFactoryHystrix jackHeUserService;	//正常无问题的情况
	
//	@Autowired
//	private JackHeUserFeignStopHystrix jackHeUserService;	//加入容错机制，自己控制返回结果
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping(value="/consumer/{id}")
	public User findbyId(@PathVariable Long id){
		return this.jackHeUserService.findById(id);
	}
	@GetMapping(value="/consumer/user/{id}")
	public UserBaseVo findbyUserId(@PathVariable Long id){
		return this.jackHeUserService.findByUserId(id);
	}
	@GetMapping(value="/consumer/userBasePost/{id}")
	public UserBaseVo findByUserBasePost(@PathVariable Long id){
		UserBaseVo vo = new UserBaseVo();
		vo.setId(id);
		return this.jackHeUserService.getUserPost(vo);
	}
	@GetMapping(value="/consumer/userPost/{id}")
	public User findByUserPost(@PathVariable Long id){
		User vo = new User();
		vo.setId(id);
		return this.jackHeUserService.getUser(vo);
	}
	/**
	 * 测试负载均衡
	 * @return
	 */
	@GetMapping(value="/consumer/testUser")
	public String testUser(){
		return this.jackHeUserService.testUser();
	}
	
	/**
	 * 查看用户调用那个节点的微服务
	 */
	@GetMapping(value="consumer/log-instance")
	public void logUserInstance(){
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("jackhe-cloud-user-service");
		// 打印当前选择的是哪个节点
		JackHeConsumerController.logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}
}
