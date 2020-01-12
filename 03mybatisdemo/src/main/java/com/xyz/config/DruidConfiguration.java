package com.xyz.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * druid监控
 */
@Configuration
public class DruidConfiguration {

   @Bean
   public ServletRegistrationBean stateServlet() {
      //创建servlete实体
      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
      //设置白名单
      servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
      //设置黑名单
      servletRegistrationBean.addInitParameter("deny", "192.169.1.100");
      //设置用户名
      servletRegistrationBean.addInitParameter("loginUsername", "druid");
      //设置密码
      servletRegistrationBean.addInitParameter("loginPassword", "123456");
      //是否可以充值数据
       servletRegistrationBean.addInitParameter("resetEable", "false");

      return servletRegistrationBean;
   }

   @Bean
   public FilterRegistrationBean filterRegistrationBean() {
      //创建过滤器
      FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
      //设置过滤器过滤路径
      filterRegistrationBean.addUrlPatterns("/");
      //忽略过滤的形式
      filterRegistrationBean.addInitParameter("exclusion", "*.js,*.css,*.gif,*.png");

      return filterRegistrationBean;
   }

}
