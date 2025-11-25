package com.codagonki.app.config;

import com.codagonki.app.dependencies.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    private final CurrentUserMethodArgumentResolver currentUserResolver;
    
    public WebMvcConfig(CurrentUserMethodArgumentResolver currentUserResolver) {
        this.currentUserResolver = currentUserResolver;
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserResolver);
    }
}