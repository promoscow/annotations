package ru.xpendence.annotations.dto;

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

    private String name;
    private Long planet;
}
