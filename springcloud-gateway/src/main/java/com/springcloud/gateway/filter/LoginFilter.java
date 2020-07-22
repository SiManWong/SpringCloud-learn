package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SiMan
 * @date 2020/7/23 0:56
 */
@Component
public class LoginFilter extends ZuulFilter {
	/**
	 * 过滤器的类型：pre route post error
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 执行顺序，返回值越小，优先级越高
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 10;
	}

	/**
	 * 是否执行run方法
	 * true：执行run方法
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 编写过滤器的业务逻辑
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		// 初始化context上下文对象，servlet spring
		RequestContext context = RequestContext.getCurrentContext();
		// 获取request对象
		HttpServletRequest request = context.getRequest();
		// 获取参数
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)) {
			// 拦截，不转发请求
			context.setSendZuulResponse(false);
			// 响应状态码，401=身份未认证
			context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			// 设置响应提示
			context.setResponseBody("request error!");
		}
		return null;
	}
}