package ru.xpendence.annotations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.annotations.entity.Continent;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
