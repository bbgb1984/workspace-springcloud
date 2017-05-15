package com.bingo.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter;

import com.netflix.zuul.context.RequestContext;

public class PostFilter extends SendResponseFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response=ctx.getResponse();
		String responseBody=ctx.getResponseBody();
		System.out.println("返回结果："+responseBody);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}


}
