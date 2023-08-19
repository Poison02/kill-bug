package com.killbug.common.idempotent.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

    int interval() default 5000;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    String message() default "please try again later!";
}
