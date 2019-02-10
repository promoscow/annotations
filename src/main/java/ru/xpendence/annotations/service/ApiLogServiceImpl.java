package ru.xpendence.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.annotations.entity.ApiLog;
import ru.xpendence.annotations.repository.ApiLogRepository;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:42
 * e-mail: 2262288@gmail.com
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {

    private final ApiLogRepository repository;

    @Autowired
    public ApiLogServiceImpl(ApiLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(ApiLog log) {
        repository.save(log);
    }
}
