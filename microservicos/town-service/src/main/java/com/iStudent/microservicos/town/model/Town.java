package com.iStudent.microservicos.town.model;

import com.iStudent.microservicos.town.model.base.BaseEntityWithIdLong;
import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntityWithIdLong {

    @Column
    private String name;

    @Column
    private Long population;

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long poplation) {
        this.population = poplation;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
