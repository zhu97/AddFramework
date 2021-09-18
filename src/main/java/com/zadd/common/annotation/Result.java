package com.zadd.common.annotation;

import java.lang.annotation.*;


/**
 * whether result data annotation
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Result {

    /**
     * true : default and result data
     * false : don't result data
     *
     * @return true for result
     */
    boolean value() default true;
}
