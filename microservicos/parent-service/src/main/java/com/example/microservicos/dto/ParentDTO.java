package com.example.microservicos.dto;

import com.example.microservicos.dto.base.PersonEntityDTO;
import com.example.microservicos.model.validation.PhoneNumber;
import jakarta.validation.constraints.NotBlank;


public class ParentDTO extends PersonEntityDTO {

    @NotBlank
    @PhoneNumber
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
