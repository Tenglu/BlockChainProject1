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
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/index_copy").setViewName("index_copy");
		registry.addViewController("/index2").setViewName("index2");
		registry.addViewController("/index3").setViewName("index3");
		registry.addViewController("/BC/route_path").setViewName("route_path");
		registry.addViewController("/route_path").setViewName("route_path");
		registry.addViewController("/warehouse_order").setViewName("warehouse_order");
		registry.addViewController("/update_warehouse_order").setViewName("update_warehouse_order");
		registry.addViewController("/create_repair_order").setViewName("create_repair_order");
		registry.addViewController("/update_repair_order").setViewName("update_repair_order");
		registry.addViewController("/pages/forms/general").setViewName("pages/forms/general");
		registry.addViewController("/pages/UI/buttons").setViewName("pages/UI/buttons");
		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/pages/charts/chartjs").setViewName("pages/charts/chartjs");
		registry.addViewController("/send_report").setViewName("send_report");
		registry.addViewController("/notify_supplier").setViewName("notify_supplier");
		registry.addViewController("/track_and_trace").setViewName("track_and_trace");
		registry.addViewController("/part_history").setViewName("part_history");
		logger.info("======WebMvcConfigurer:  access login url.");
	}

}
