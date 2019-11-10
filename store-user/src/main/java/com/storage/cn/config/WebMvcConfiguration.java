package com.storage.cn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/**
 * <p>
 *      此配置类可配置拦截器、参数解析器、返回值解析器、跨域支持等等
 * </p>
 *
 * @author: Lei Li
 * @Date: 2019/11/10 14:04
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 如果配置跨域，就增加这个配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/",
                                      "classpath:/resources/",
                                      "classpath:/static/");
    }

    /**
     * Add interceptors.
     *
     * @param registry the registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

}