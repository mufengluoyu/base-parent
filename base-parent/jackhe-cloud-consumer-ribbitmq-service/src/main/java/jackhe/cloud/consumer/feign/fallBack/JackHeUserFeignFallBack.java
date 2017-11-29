package jackhe.cloud.consumer.feign.fallBack;

import java.util.Map;

import org.springframework.stereotype.Component;

import jackhe.cloud.consumer.entity.User;
import jackhe.cloud.consumer.feign.JackHeUserFeign;
import jackhe.cloud.user.common.vo.UserBaseVo;

/**
 * 
 * 回退类JackHeUserFallback需实现Feign Client接口
 * @author hechangzhi 2017年11月20日
 *
 */
@Component
public class JackHeUserFeignFallBack implements JackHeUserFeign{

	@Override
	public User findById(Long id) {
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

}
