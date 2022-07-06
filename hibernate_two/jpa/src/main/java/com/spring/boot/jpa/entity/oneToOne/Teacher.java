package com.spring.boot.jpa.entity.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

// this particular teacher and course have one to many relationship
// one teacher can have a list of courses inside a particular class


public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String firstName;
    private String lastName;

    // uni directional one to many mapping over here

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )


    // there will be two table one will be teacher and one will be course
    // the teacher which particular course is teaching that particular relationship will be having
    // the course table will be having a extra key foreign key i.e teacher id that extra column will
//    define this particular column will define this course is taught by which particular teacher
    private List<Course> courses;

}
