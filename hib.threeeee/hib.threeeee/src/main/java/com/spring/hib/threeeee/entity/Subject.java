package com.spring.hib.threeeee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

    @ManyToOne()
    @JoinColumn(name = "author_subject", referencedColumnName = "subjectId")
    private Author author;
}
