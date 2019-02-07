package ru.xpendence.annotations.aspect;

import org.springframework.http.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.11.2018
 * Time: 17:34
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiLogResponse {

    HttpMethod httpMethod();

    String path() default "";

    String body() default "";
}
