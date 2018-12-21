package com.sola.alittledemo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于直接类转换
 * @author chao.lan@karakal.com.cn (兰超)
 * @version 1.0
 * @Date 2018/10/30 15: 22
 * Copyright (c) 2018, 北京卡拉卡尔科技股份有限公司 All rights reserved.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CopyPropertyAnnotation {
    /** 注解名称 */
    String nickFieldName() default "";

    /** 是否转换 默认转换*/
    boolean copy() default true;
}
