package ru.xpendence.annotations.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:27
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "continents")
@EqualsAndHashCode(callSuper = false)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Continent extends AbstractEntity {

    private String name;
    private Planet planet;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planet_id")
    public Planet getPlanet() {
        return planet;
    }
}
