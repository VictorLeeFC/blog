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
                        "/admin/media/music");
    }

    /**
     * 请求路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        //判断是什么操作系统
        boolean isWin = System.getProperty("os.name").toLowerCase().contains("win");
        //根据不同系统设置不同映射
        if(isWin) {
            //win
            registry.addResourceHandler("/admin/media/music/**")
                    .addResourceLocations("file:" + mediaProperties.getMusicPath() + "\\");

            registry.addResourceHandler("/admin/media/image/**")
                    .addResourceLocations("file:" + mediaProperties.getImagePath() + "\\");
        }

        //linux
        registry.addResourceHandler("/admin/media/music/**")
                .addResourceLocations(mediaProperties.getMusicPath() + "/");

        registry.addResourceHandler("/admin/media/image/**")
                .addResourceLocations(mediaProperties.getImagePath() + "/");

    }

}
