package com.bgi.uams.beans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UamsMethod {
    /**
     * 方法版本
     * 
     * @return
     */
    String version() default "1.0";
    /**
     * 方法名称
     * 
     * @return
     */
    String value();
}