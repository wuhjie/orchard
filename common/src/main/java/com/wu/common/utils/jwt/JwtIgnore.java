package com.wu.common.utils.jwt;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName JwtIgnore
 * @Description
 * @Author wuhjie
 * @Data 2020/10/16 10:57 am
 * @Version 1.0
 **/

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JwtIgnore {
}
