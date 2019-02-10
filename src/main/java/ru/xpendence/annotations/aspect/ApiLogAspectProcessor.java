package ru.xpendence.annotations.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.xpendence.annotations.attributes.TransferType;
import ru.xpendence.annotations.entity.ApiLog;
import ru.xpendence.annotations.service.ApiLogService;


/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.11.2018
 * Time: 13:07
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Aspect
@Component
@Slf4j
public class ApiLogAspectProcessor {

    private final ApiLogService service;

    @Autowired
    public ApiLogAspectProcessor(ApiLogService service) {
        this.service = service;
    }

    @Before(value = "@annotation(before) && args(param)")
    public void before(ApiLogRequest before, String param) {
        service.save(ApiLog.of(
                TransferType.REQUEST.name(),
                before.httpMethod().name(),
                before.path(),
                createBodyWithParams(param, before)
        ));
    }

    @Before(value = "@annotation(before) && args(param,..)")
    public void before(ApiLogRequest before, Long param) {
        service.save(ApiLog.of(
                TransferType.REQUEST.name(),
                before.httpMethod().name(),
                before.path(),
                createBodyWithParams(String.valueOf(param), before)
        ));
    }

    @Before(value = "@annotation(before) && args(param,..)")
    public void before(ApiLogRequest before, Object param) throws JsonProcessingException {
        service.save(ApiLog.of(
                TransferType.REQUEST.name(),
                before.httpMethod().name(),
                before.path(),
                new ObjectMapper().writeValueAsString(param)
        ));
    }

    @AfterReturning(value = "@annotation(after)", returning = "responseEntity")
    public void after(ResponseEntity responseEntity, ApiLogResponse after) throws JsonProcessingException {
        service.save(ApiLog.of(
                TransferType.RESPONSE.name(),
                after.httpMethod().name(),
                after.path(),
                new ObjectMapper().writeValueAsString(responseEntity)
        ));
    }

    private String createBodyWithParams(String param, ApiLogRequest before) {
        return String.format("%s=%s", before.param(), param);
    }
}
