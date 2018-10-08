package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/index2").setViewName("index2");
		registry.addViewController("/index3").setViewName("index3");
		registry.addViewController("/BC/route_path").setViewName("route_path");
		registry.addViewController("/route_path").setViewName("route_path");
		registry.addViewController("/work_order").setViewName("work_order");
		logger.info("======WebMvcConfigurer:  access login url.");
	}

}
