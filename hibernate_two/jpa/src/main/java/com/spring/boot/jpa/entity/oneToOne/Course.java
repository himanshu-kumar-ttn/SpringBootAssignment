package com.spring.boot.jpa.entity.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    // Defining many to one relationship

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

}

class Singelton {

    static Singelton var;

    public Singelton() {
    }

    static Singelton singletonStaticMethod() {
        if (var == null) {
            var = new Singelton();
        }
        return var;

    }
}

// transactional propagation type
// cascading types
// create a singleton class using thread