package ru.xpendence.annotations.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.annotations.dto.ContinentDto;
import ru.xpendence.annotations.entity.Continent;
import ru.xpendence.annotations.repository.PlanetRepository;

import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Component
@Mapper(entity = Continent.class, dto = ContinentDto.class)
public class ContinentMapper extends AbstractMapper<Continent, ContinentDto> {

    private final PlanetRepository planetRepository;

    @Autowired
    ContinentMapper(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public void init() {
        mapper.createTypeMap(Continent.class, ContinentDto.class)
                .addMappings(m -> m.skip(ContinentDto::setPlanet)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ContinentDto.class, Continent.class)
                .addMappings(m -> m.skip(Continent::setPlanet)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Continent source, ContinentDto destination) {
        if (Objects.nonNull(source) && Objects.nonNull(source.getPlanet())) {
            destination.setPlanet(source.getPlanet().getId());
        }
    }

    @Override
    void mapSpecificFields(ContinentDto source, Continent destination) {
        if (Objects.nonNull(destination)) {
            destination.setPlanet(planetRepository.findById(source.getId()).orElse(null));
        }
    }
}
