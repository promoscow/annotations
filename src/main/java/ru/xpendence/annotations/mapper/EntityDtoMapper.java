package ru.xpendence.annotations.mapper;

import ru.xpendence.annotations.dto.AbstractDto;
import ru.xpendence.annotations.entity.AbstractEntity;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 04.02.19
 * Time: 21:53
 * e-mail: 2262288@gmail.com
 */
public interface EntityDtoMapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
