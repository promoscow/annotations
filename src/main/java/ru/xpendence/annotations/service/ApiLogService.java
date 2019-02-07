package ru.xpendence.annotations.service;

import ru.xpendence.annotations.entity.ApiLog;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:42
 * e-mail: 2262288@gmail.com
 */
public interface ApiLogService {

    void save(ApiLog log);
}
