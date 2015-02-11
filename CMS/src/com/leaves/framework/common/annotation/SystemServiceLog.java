package com.leaves.framework.common.annotation;

import java.lang.annotation.*;

/**
 * User: jiangq
 * Date: 2015/1/7
 * Time: 10:45
 * Description:
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description()  default "";
}

