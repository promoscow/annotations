package ru.xpendence.annotations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.annotations.entity.ApiLog;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:41
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}
