package ru.xpendence.annotations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.annotations.entity.Planet;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:19
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
