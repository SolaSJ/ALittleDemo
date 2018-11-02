package com.sola.alittledemo.annotation;

import java.lang.annotation.*;

/**
 * @author Sola
 * @date 2018/10/09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogTime {

    /**
     * 方法名称
     *
     * @return
     */
    String value();

}
