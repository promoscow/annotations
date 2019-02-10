package ru.xpendence.annotations.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PlanetDto extends AbstractDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ContinentDto> continents;

    public PlanetDto(String name) {
        this.name = name;
    }
}
