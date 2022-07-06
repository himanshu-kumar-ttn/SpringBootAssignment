package com.spring.jpa.hibernate.three.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String name;

    @Embedded
    private AuthorAddress authorAddress;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Subject> subjectSet = new HashSet<>();

}
