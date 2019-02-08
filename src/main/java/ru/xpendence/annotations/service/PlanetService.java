package ru.xpendence.annotations.service;

import ru.xpendence.annotations.dto.PlanetDto;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:20
 * e-mail: 2262288@gmail.com
 */
public interface PlanetService {

    PlanetDto save(PlanetDto dto);

    PlanetDto get(Long id);
}
