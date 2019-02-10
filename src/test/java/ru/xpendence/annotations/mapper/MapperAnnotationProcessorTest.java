package ru.xpendence.annotations.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 10.02.19
 * Time: 10:36
 * e-mail: 2262288@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperAnnotationProcessorTest {

    @Autowired
    private PlanetMapper planetMapper;

    @Test
    public void isPlanetMapperInitiatedWithFields() {
        assertNotNull(planetMapper);

        Stream.of(planetMapper.getClass().getDeclaredFields())
                .peek(f -> f.setAccessible(true))
                .forEach(System.out::println);
    }
}