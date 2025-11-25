package com.codagonki.app.dependencies;

import com.codagonki.app.models.User;
import com.codagonki.app.utils.JwtUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    
    private final JwtUtils jwtUtils;
    
    public CurrentUserMethodArgumentResolver(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }
    
    @Override
    public boolean supportsParameter(@NonNull MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) && 
               parameter.getParameterType().equals(User.class);
    }
    
    @Override
    @Nullable
    public Object resolveArgument(@NonNull MethodParameter parameter, 
                                 @Nullable ModelAndViewContainer mavContainer,
                                 @NonNull NativeWebRequest webRequest, 
                                 @Nullable WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        return jwtUtils.getUserFromCookie(request);
    }
}