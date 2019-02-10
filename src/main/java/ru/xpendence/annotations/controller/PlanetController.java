package ru.xpendence.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.annotations.aspect.ApiLogRequest;
import ru.xpendence.annotations.aspect.ApiLogResponse;
import ru.xpendence.annotations.dto.PlanetDto;
import ru.xpendence.annotations.service.PlanetService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:25
 * e-mail: 2262288@gmail.com
 */
@RequestMapping("/planet")
@RestController
public class PlanetController {

    private final PlanetService service;

    @Autowired
    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @ApiLogRequest(httpMethod = HttpMethod.POST, path = "/planet")
    @ApiLogResponse(httpMethod = HttpMethod.POST, path = "/planet")
    @PostMapping
    public ResponseEntity<PlanetDto> save(@RequestBody PlanetDto dto) {
        Long requestId;
        return ResponseEntity.ok(service.save(dto));
    }

    @ApiLogRequest(httpMethod = HttpMethod.GET, path = "/planet", param = "id")
    @ApiLogResponse(httpMethod = HttpMethod.GET, path = "/planet")
    @GetMapping
    public ResponseEntity<PlanetDto> get(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
