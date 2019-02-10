package ru.xpendence.annotations.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.02.19
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ContinentDto extends AbstractDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long planet;
}
