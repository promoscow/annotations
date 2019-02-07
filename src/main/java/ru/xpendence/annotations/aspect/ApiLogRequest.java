package ru.xpendence.annotations.aspect;

import org.springframework.http.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.11.2018
 * Time: 13:12
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiLogRequest {

    HttpMethod httpMethod();

    String path() default "";

    String param() default "";

    String body() default "";
}
