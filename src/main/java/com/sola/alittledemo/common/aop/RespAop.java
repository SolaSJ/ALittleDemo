package com.sola.alittledemo.common.aop;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.common.bean.Response;
import com.sola.alittledemo.common.consts.RespCodeEnum;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 用于统一处理controller返回结果以及异常返回结果
 *
 * @author Sola
 * @date 2018/11/19
 */
@RestControllerAdvice
public class RespAop implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Response) {
            return o;
        }

        RespCodeEnum ok = RespCodeEnum.OK;
        Response<Object> resp = new Response<>(ok.getCode(), ok.getMsg(), o);

        // 处理controller返回为字符串, 转换报异常的bug
        return o instanceof String ? JSON.toJSONString(resp) : o;
    }

}
