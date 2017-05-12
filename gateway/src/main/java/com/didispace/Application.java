package com.didispace;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter;
import org.springframework.cloud.netflix.zuul.filters.pre.FormBodyWrapperFilter;
import org.springframework.context.annotation.Bean;

import com.didispace.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

//	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}
	
	@Bean
	public FormBodyWrapperFilter f() {
		return new FormBodyWrapperFilter();
	}
	
	@Bean
	public SendResponseFilter postFilter() {
		return new SendResponseFilter();
	}

}