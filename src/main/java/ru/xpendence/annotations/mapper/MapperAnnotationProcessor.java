package ru.xpendence.annotations.mapper;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
        if (managedBeanClass.equals(AbstractMapper.class)) {
            Mapper mapper = managedBeanClass.getAnnotation(Mapper.class);
            if (Objects.nonNull(mapper)) {
                ((AbstractMapper) bean).setEntityClass(mapper.entity());
                ((AbstractMapper) bean).setDtoClass(mapper.dto());
            }
        }
        return bean;
    }
}
