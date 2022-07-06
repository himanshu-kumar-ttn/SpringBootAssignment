package com.spring.boot.jpa.service.oneToOne;

import com.spring.boot.jpa.entity.oneToOne.Course;
import com.spring.boot.jpa.repository.oneToOne.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // ideally when you are getting courses you want course material as well
    // there's no point in getting the details separately
    // when you are working with course material you are getting courses as well
    // but when you are working with course you are not getting course material because you have defined
//    unidirectional one to one mapping over here
    // in the course material entity you have reference for course
    // but if you go to course entity you have no reference for course material because of uni directional one to one mapping
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}
