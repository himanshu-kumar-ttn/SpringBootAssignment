package com.rest.api.two.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Tag(name = "User")
//@ApiModel(description = "Contains all the details about User")
//@JsonIgnoreProperties(value = {"password"})
@JsonFilter("SomeBeanFilter")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ApiModelProperty(notes = "Name should be least of 5 characters and first letter as capital")
    private String name;
    private String age;

//    @JsonIgnore
    private String password;

    public User(String name, String age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User() {
    }
}
