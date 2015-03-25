package com.leaves.framework.common.annotation;

import java.lang.annotation.*;

/**
 * User: jiangq
 * Date: 2015/3/24
 * Time: 13:33
 * Description:
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
