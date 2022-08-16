package com.dyne.viid.common.annotation;

import java.lang.annotation.*;

/**
 * 需要鉴权
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireAuth {
}
