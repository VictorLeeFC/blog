package com.blog.config;

import com.blog.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-20
 * @author: li
 * @version: v0.1
 */
@Configuration
@EnableConfigurationProperties(MediaProperties.class)//自定义磁盘媒体文件路径配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MediaProperties mediaProperties;

    /**
     * 默认跳转index
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/admin/**")
                //除了下面这些全部都要拦截
                .excludePathPatterns("/","/admin","/admin/login","/admin/logout",
                        "/css/**", "/js/**","/webjars/**","/img/**","/asserts/**",
                        "/admin/media/**","/swagger-resources/**","/v2/**","/swagger-ui.html/**");
    }

    /**
     * 请求路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //所有静态资源映射到static目录下,静态时../static/js/..运行时格式是：/js/..
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        //判断是什么操作系统
        boolean isWin = System.getProperty("os.name").toLowerCase().contains("win");
        //根据不同系统设置不同映射
        if(isWin) {
            //win
            registry.addResourceHandler("/admin/media/music/**")
                    .addResourceLocations("file:" + mediaProperties.getMusicPath()[0] + "\\");

            registry.addResourceHandler("/admin/media/image/**")
                    .addResourceLocations("file:" + mediaProperties.getImagePath()[0] + "\\");

        //这个else不要的话需要:return;不然就是两个系统的路径同时存在
        }else {
            //linux
            registry.addResourceHandler("/admin/media/music/**")
                    .addResourceLocations("file:" + mediaProperties.getMusicPath()[1]);

            registry.addResourceHandler("/admin/media/image/**")
                    .addResourceLocations("file:" + mediaProperties.getImagePath()[1]);
        }
    }

}
