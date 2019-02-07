package ru.xpendence.annotations.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.02.19
 * Time: 22:18
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "planets")
@EqualsAndHashCode(callSuper = false)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planet extends AbstractEntity {

    private String name;
    private List<Continent> continents;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "planet")
    public List<Continent> getContinents() {
        return continents;
    }
}
