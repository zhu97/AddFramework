package com.zadd.config.advice;

import com.zadd.common.annotation.DontResult;
import com.zadd.common.model.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * use as controller response interceptor
 * except for annotation DontResult and DontResult's value is true
 *
 * @see DontResult
 */
@Configuration
@ControllerAdvice(basePackages = "com.zadd")
public class ResponseResultAdvise implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return getData(object, methodParameter);
    }

    private Object getData(Object object, MethodParameter methodParameter) {
        if (object instanceof Result) {
            return object;
        }
        if (methodParameter.hasMethodAnnotation(DontResult.class)) {
            DontResult annotation = methodParameter.getAnnotatedElement().getAnnotation(DontResult.class);
            if (annotation != null && annotation.value()) {
                return object;
            }
        }
        return Result.successData(object);
    }
}
