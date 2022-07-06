package com.spring.boot.jpa.entity.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
// This particular courseMaterial table will have one extra column that will be course_id, so it will refer for which particular course it belongs to
// two table course and courseMaterial has been created in the course_material table there is course_id column too
// in this way have added primary and foreign key relationship between two tables

public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    // for which particular column that a foreign key will be applied
    @JoinColumn(name = "course_id", // name of that column will be course_id
            referencedColumnName = "courseId" // which particular column it is referencing to
    )
    private Course course;
}
