package com.example.Student.Management.Student;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    public Student() {
    }

    @Id
    @GeneratedValue()
    Long id;

    @NotNull
    @Column(unique = true)
    @Email
    String email;

    @NotNull
    String firstName;

    @NotNull
    String lastName;





    @Column(precision = 3, scale =2 )
    @Min(value = 0)
    @Max(value = 4)
    @NotNull
    BigDecimal gpa;

    @NotNull
    @Pattern(regexp = "[MF]")
    String gender;


    @NotNull
    LocalDate dob;  // date of birth

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Transient
    public int getAge() {
        if (dob == null) {
            return 0;
        }
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getGpa() {
        return gpa;
    }
}
