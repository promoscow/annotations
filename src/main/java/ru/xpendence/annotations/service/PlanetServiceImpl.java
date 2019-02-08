package ru.xpendence.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.annotations.dto.PlanetDto;
import ru.xpendence.annotations.exception.PlanetException;
import ru.xpendence.annotations.mapper.PlanetMapper;
import ru.xpendence.annotations.repository.PlanetRepository;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:21
 * e-mail: 2262288@gmail.com
 */
@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository repository;
    private final PlanetMapper mapper;

    @Autowired
    public PlanetServiceImpl(PlanetRepository repository, PlanetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PlanetDto save(PlanetDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public PlanetDto get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new PlanetException(String.format("Unable to get by id %d", id))));
    }
}
