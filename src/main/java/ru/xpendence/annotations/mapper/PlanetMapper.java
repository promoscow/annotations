package ru.xpendence.annotations.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.annotations.dto.PlanetDto;
import ru.xpendence.annotations.entity.Planet;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Component
public class PlanetMapper extends AbstractMapper<Planet, PlanetDto> {

    PlanetMapper() {
        super(Planet.class, PlanetDto.class);
    }
}
