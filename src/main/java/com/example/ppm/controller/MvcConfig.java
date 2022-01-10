package com.example.ppm.controller;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
       // registry.addViewController("/admin_home").setViewName("admin_home");
        registry.addViewController("/manager_home").setViewName("manager_home");
        registry.addViewController("/employee_home").setViewName("employee_home");
    }
 

}
