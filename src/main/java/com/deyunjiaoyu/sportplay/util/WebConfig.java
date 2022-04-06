package com.deyunjiaoyu.sportplay.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//全局配置类配置跨域请求
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("Http://localhost:8082", "null").allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE").allowCredentials(true).maxAge(3600);
    }
}
