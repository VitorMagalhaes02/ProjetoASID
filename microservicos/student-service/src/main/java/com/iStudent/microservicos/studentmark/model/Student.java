package com.iStudent.microservicos.studentmark.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.iStudent.microservicos.studentmark.model.base.NewBasePersonEntity;


@Entity
@Table(name = "students")
public class Student extends NewBasePersonEntity {

    @Column(name = "parent_id")
    private Long parent_id;

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    @Column(name = "club_id")
    private Long club_id;

    public Long getClub_id() {
        return club_id;
    }

    public void setClub_id(Long club_id) {
        this.club_id = club_id;
    }

    @Column(name = "enroll_date", nullable = false)
    private LocalDate enrollDate;

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }
    
    public void removeParent() {
        this.parent_id = null;
    }

}
