package com.example.microservicos.dto;

public class AggregationDTO {
    
    private StudentDTO student;
    private ParentDTO parent;
    private TownDTO town;
    private ClubDTO club;

    // Construtores, Getters e Setters
    public AggregationDTO(StudentDTO student, ParentDTO parent, TownDTO town, ClubDTO club) {
        this.student = student;
        this.parent = parent;
        this.town = town;
        this.club = club;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public TownDTO getTown() {
        return town;
    }

    public void setTown(TownDTO town) {
        this.town = town;
    }

    public ClubDTO getClub() {
        return club;
    }

    public void setClub(ClubDTO club) {
        this.club = club;
    }
}

