package com.iStudent.microservicos.studentmark.model.base;

import com.iStudent.microservicos.studentmark.model.enums.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class NewBasePersonEntity extends BaseEntityWithIdLong {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String EGN;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "town_id") // Nomeie a coluna conforme necessário
    private Long town_id;

    @Column
    private String email;

    public Long getTownId() {
        return town_id;
    }

    public void setTownId(Long townId) {
        this.town_id = townId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(GenderEnum genderEnum) {
        this.gender = genderEnum;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEGN() {
        return EGN;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append("First name: ").append(firstName).append(System.lineSeparator())
                .append("Middle name: ").append(middleName).append(System.lineSeparator())
                .append("Last name: ").append(lastName).append(System.lineSeparator())
                .append("EGN: ").append(EGN).append(System.lineSeparator())
                .append("Age: ").append(age).append(System.lineSeparator())
                .append("Gender: ").append(gender).append(System.lineSeparator())
                .append("Town ID: ").append(town_id).append(System.lineSeparator())
                .append("Email: ").append(email);

        return info.toString();
    }
}
