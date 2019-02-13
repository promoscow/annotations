package ru.xpendence.annotations.mapper;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:15
 * e-mail: 2262288@gmail.com
 */
@Component
public class MapperAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) {
        return Objects.nonNull(bean) ? init(bean) : null;
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) {
        return bean;
    }

    private Object init(Object bean) {
        Class<?> managedBeanClass = bean.getClass();
        Mapper mapper = managedBeanClass.getAnnotation(Mapper.class);
        if (Objects.nonNull(mapper)) {
            ReflectionUtils.doWithFields(managedBeanClass, field -> {
                assert field != null;
                String fieldName = field.getName();
                if (!fieldName.equals("entityClass") && !fieldName.equals("dtoClass")) {
                    return;
                }
                ReflectionUtils.makeAccessible(field);
                Class<?> targetClass = fieldName.equals("entityClass") ? mapper.entity() : mapper.dto();
                Class<?> expectedClass = Stream.of(ResolvableType.forField(field).getGenerics()).findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Unable to get generic type for " + fieldName)).resolve();
                if (expectedClass != null && !expectedClass.isAssignableFrom(targetClass)) {
                    throw new IllegalArgumentException(String.format(
                            "Unable to assign Class %s to expected Class: %s",
                            targetClass, expectedClass));
                }
                field.set(bean, targetClass);
            });
        }
        return bean;
    }
}