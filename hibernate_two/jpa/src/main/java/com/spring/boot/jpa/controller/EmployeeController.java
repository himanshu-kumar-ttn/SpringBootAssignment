package com.spring.boot.jpa.controller;

import com.spring.boot.jpa.entity.Employee;
import com.spring.boot.jpa.entity.oneToOne.Course;
import com.spring.boot.jpa.entity.oneToOne.CourseMaterial;
import com.spring.boot.jpa.service.EmployeeService;
import com.spring.boot.jpa.service.oneToOne.CourseMaterialService;
import com.spring.boot.jpa.service.oneToOne.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private CourseMaterialService courseMaterialService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployees(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/courseMaterial")
    public CourseMaterial saveCourse(@RequestBody CourseMaterial courseMaterial) {
        return courseMaterialService.saveCourseMaterial(courseMaterial);
    }

    @GetMapping("course")
    public List<Course> getCourse() {
        return courseService.getCourses();
    }

}
