package com.storage.cn.config;

import com.storage.cn.properties.CorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域安全问题的配置类
 * @Auther: Lei Li
 * @Date: 2019/11/20 16:43
 * @Version 1.0
 */
@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter(CorsProperties prop) {
        // 1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 1) 允许的域,不要写*，否则cookie就无法使用了
        prop.getAllowedOrigins().forEach(config::addAllowedOrigin);
        // 2) 是否发送Cookie信息
        config.setAllowCredentials(prop.getAllowCredentials());
        // 3) 允许的请求方式
        prop.getAllowedMethods().forEach(config::addAllowedMethod);
        // 4) 允许的头信息
        prop.getAllowedHeaders().forEach(config::addAllowedHeader);
        // 5) 跨域许可的有效期
        config.setMaxAge(prop.getMaxAge());
        // 2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new
                UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration(prop.getFilterPath(), config);
        // 3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
