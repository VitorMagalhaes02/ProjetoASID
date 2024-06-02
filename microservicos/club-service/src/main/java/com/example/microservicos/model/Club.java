package com.example.microservicos.model;

import com.example.microservicos.model.base.BaseEntityWithIdLong;
import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Club extends BaseEntityWithIdLong {

    @Column(unique = true)
    private String name;

    @Column(length = 500, columnDefinition = "text")
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Club's name: " + name + System.lineSeparator()
                + "Club's description: " + description;
    }
}

