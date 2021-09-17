package com.zadd.config.advice;

import com.zadd.common.model.Result;
import com.zadd.common.result.CodeMsgConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result bindException(BindException bindException) {
        BindingResult bindingResult = bindException.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors.size() != 0) {
            String defaultMessage = allErrors.get(0).getDefaultMessage();
            return Result.create(null, CodeMsgConstant.errorCode, defaultMessage);
        }
        return Result.error();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result globalException(Exception ex) {
        log.error("response throw exception", ex);
        return Result.create(null, CodeMsgConstant.errorCode, ex.getMessage());
    }
}
