package jackhe.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * zuul过滤器
 * @author hechangzhi 2017年12月7日
 *
 */
public class PreRequestFilter extends ZuulFilter{
	
	private static final Logger log = LoggerFactory.getLogger(PreRequestFilter.class);
	/**
	 * 过滤器的具体逻辑
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	/**
	 * 判断该过滤器是否要执行，true：执行，false：不执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 制定过滤的执行顺序，不同的过滤器允许返回相同的数字
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * 返回过滤类型。
	 * 		pre:请求被路由之前
	 * 		route:在路由请求被调用
	 * 		post:在route和error过滤器之后被调用
	 * 		error:处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
