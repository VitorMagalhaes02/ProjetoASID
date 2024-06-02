package com.example.microservicos.model;

import com.example.microservicos.model.base.NewBasePersonEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "parents")
public class Parent extends NewBasePersonEntity {

    @Column
    private String phoneNumber;

    @Column(name = "student_id")
    private Long student_id;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

}
