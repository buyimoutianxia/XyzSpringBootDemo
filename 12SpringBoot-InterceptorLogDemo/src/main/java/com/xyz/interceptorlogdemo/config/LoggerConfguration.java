package com.xyz.interceptorlogdemo.config;

import com.xyz.interceptorlogdemo.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggerConfguration implements WebMvcConfigurer {

   @Override
   public void  addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
   }

}
