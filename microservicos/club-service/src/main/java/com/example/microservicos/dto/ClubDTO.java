package com.example.microservicos.dto;

import com.example.microservicos.model.validation.UniqueClubName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClubDTO {
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 20)
    @UniqueClubName
    private String name;

    @NotBlank
    @Size(min = 5, max = 500)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
