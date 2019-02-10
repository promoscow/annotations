package ru.xpendence.annotations.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.xpendence.annotations.dto.PlanetDto;
import ru.xpendence.annotations.entity.ApiLog;
import ru.xpendence.annotations.repository.ApiLogRepository;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 10.02.19
 * Time: 13:07
 * e-mail: 2262288@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetControllerTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    private ApiLogRepository apiLogRepository;

    @Autowired
    private ObjectMapper mapper;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(post("/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(createPlanetDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<ApiLog> all = apiLogRepository.findAll();
        assertEquals(2, all.size());
    }

    private PlanetDto createPlanetDto() {
        return new PlanetDto("Planet " + (LocalTime.now().getNano() / 1000000));
    }
}