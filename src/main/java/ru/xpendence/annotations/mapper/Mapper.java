package ru.xpendence.annotations.mapper;

import java.lang.annotation.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * Time: 22:28
 * e-mail: 2262288@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Mapper {

    Class<?> entity();

    Class<?> dto();
}
