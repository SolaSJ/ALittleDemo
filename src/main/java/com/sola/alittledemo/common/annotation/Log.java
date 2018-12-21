package com.sola.alittledemo.common.annotation;

import java.lang.annotation.*;

/**
 * @author Sola
 * @date 2018/10/09
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 方法名称
     *
     * @return
     */
    String value();

}
