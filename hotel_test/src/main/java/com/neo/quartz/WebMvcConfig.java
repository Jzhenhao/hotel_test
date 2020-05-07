package com.neo.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址

        List<String> excludeList=new ArrayList<>();
        //用户没有登录会拦截然后返回登录页面，除了下面这些路径
        excludeList.add("/js/**");//js引用
        excludeList.add("/css/**");//css引用
        excludeList.add("/");//登录页面
        excludeList.add("/user/dologin");//登录
        excludeList.add("/toRegister");//注册页面
        excludeList.add("/admin/**");//管理员的所有页面
        excludeList.add("/user/register");//注册
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns(excludeList);
    }
}