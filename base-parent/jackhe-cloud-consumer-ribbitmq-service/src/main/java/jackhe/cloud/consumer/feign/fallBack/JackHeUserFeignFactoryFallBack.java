package jackhe.cloud.consumer.feign.fallBack;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import jackhe.cloud.consumer.entity.User;
import jackhe.cloud.consumer.feign.JackHeUserFeignFactoryHystrix;
import jackhe.cloud.user.common.vo.UserBaseVo;

/**
 * JackHeUserFeignFactoryHystrix的fallbackFactory类，该类需实现FallbackFactory接口，并覆写create方法
 * 主要是可以通过throwable判断错误原因，从而获取到不同的日子处理模式
 * @author hechangzhi 2017年11月20日
 *
 */
@Component
public class JackHeUserFeignFactoryFallBack implements FallbackFactory<JackHeUserFeignFactoryHystrix>{

	private static final Logger logger = LoggerFactory.getLogger(JackHeUserFeignFactoryFallBack.class);
	
	@Override
	public JackHeUserFeignFactoryHystrix create(final Throwable cause) {
		return new JackHeUserFeignFactoryHystrix(){

			@Override
			public User findById(Long id) {
				 // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
		        // 否则在引用启动时，就会打印该日志。
		        // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
				JackHeUserFeignFactoryFallBack.logger.info("fallback; reason was:", cause);
				User user = new User();
			    user.setId(-1L);
			    user.setUsername("默认回滚用户（降级处理）");
			    return user;
			}

			@Override
			public UserBaseVo findByUserId(Long id) {
				UserBaseVo user = new UserBaseVo();
				user.setId(-1L);
			    user.setUsername("默认回滚用户（降级处理）");
			    return user;
			}

			@Override
			public String testUser() {
				// TODO Auto-generated method stub
				return "未找到服务降级处理";
			}

			@Override
			public User getUserGet(Map<String, Object> map) {
				User user = new User();
			    user.setId(-1L);
			    user.setUsername("默认回滚用户（降级处理）");
			    return user;
			}

			@Override
			public UserBaseVo getUserPost(UserBaseVo userBase) {
				UserBaseVo user = new UserBaseVo();
				user.setId(-1L);
			    user.setUsername("默认回滚用户（降级处理）");
			    return user;
			}
			
		};
	}

}
