package com.spring.jpa.hibernate.three.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAddress {

    private int streetName;
    private String location;
    private String state;

}
