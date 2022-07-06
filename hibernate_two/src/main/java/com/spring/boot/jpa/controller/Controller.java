package com.spring.boot.jpa.controller;

import com.spring.boot.jpa.entity.inheritanceMapping.Person;
import com.spring.boot.jpa.entity.inheritanceMapping.Student;
import com.spring.boot.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private StudentService personService;

    @PostMapping("/student")
    public Person createPerson(@RequestBody Student student){
        return personService.createPerson(student);
    }
}
