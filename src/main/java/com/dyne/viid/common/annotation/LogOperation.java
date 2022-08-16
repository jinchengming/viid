package com.dyne.viid.common.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogOperation {
    String value() default "";
}