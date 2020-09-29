package com.lwf.springboot01.first.Config;

import com.lwf.springboot01.first.component.LoginHandlerInterceptor;
import com.lwf.springboot01.first.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 创建人:CP
 * 创建时间:2020/6/15 11:06 上午
 * 项目名称:first
 * 类名:Myconfig
 * 类描述:TODO
 **/
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean//将组件注册在容器中
   public WebMvcConfigurer webMvcConfigurer(){
       WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/index.html").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }
            //注册拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/static/**");
           }
       };
       return webMvcConfigurer;
   }
   @Bean
   public LocaleResolver localeResolver(){
        return new MyLocalResolver();
   }
}

