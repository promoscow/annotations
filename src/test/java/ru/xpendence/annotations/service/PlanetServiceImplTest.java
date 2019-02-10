package ru.xpendence.annotations.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.xpendence.annotations.dto.PlanetDto;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 10.02.19
 * Time: 11:01
 * e-mail: 2262288@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetServiceImplTest {

    @Autowired
    private PlanetService service;

    @Test
    public void save() {
        assertEquals("Planet", service.save(createPlanetDto()).getName().substring(0, 6));
    }

    private PlanetDto createPlanetDto() {
        return new PlanetDto("Planet " + (LocalTime.now().getNano() / 1000000));
    }
}