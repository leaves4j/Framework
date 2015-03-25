package com.leaves.framework.common.annotation;

import com.leaves.framework.common.Authority;

import java.lang.annotation.*;

/**
 * User: jiangq
 * Date: 2015/1/7
 * Time: 10:42
 * Description:
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    String[] value() default "";
    Class authClass() default Authority.class;
}

