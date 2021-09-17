package com.zadd.common.annotation;

import java.lang.annotation.*;


/**
 * whether result data annotation
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DontResult {

    /**
     * true : default and don't result data
     * false : result data
     *
     * @return true for don't result
     */
    boolean value() default true;
}
