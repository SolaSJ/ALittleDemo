package com.sola.alittledemo.common.aop;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.common.bean.Response;
import com.sola.alittledemo.common.consts.Const;
import com.sola.alittledemo.common.consts.RespCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author Sola
 * @date 2018/10/24
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object globalHandleException(Exception e) {
        RespCodeEnum codeEnum;
        Object data;
        if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            data = Optional.ofNullable(constraintViolations).orElse(Collections.emptySet())
                    .stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(Const.COMMA));
            codeEnum = RespCodeEnum.VALIDATION_EXCEPTION;
        } else if (e instanceof MethodArgumentNotValidException) {
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            data = Optional.ofNullable(allErrors).orElse(Collections.emptyList())
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(Const.COMMA));
            codeEnum = RespCodeEnum.VALIDATION_EXCEPTION;
        } else {
            log.error("未知异常", e);
            data = JSON.toJSONString(e);
            codeEnum = RespCodeEnum.UNKNOWN_EXCEPTION;
        }
        return new Response<>(codeEnum.getCode(), codeEnum.getMsg(), data);
    }

}
