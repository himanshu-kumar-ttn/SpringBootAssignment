package com.spring.boot.jpa.controller;

import com.spring.boot.jpa.entity.inheritanceMapping.Person;
import com.spring.boot.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private PersonService personService;

    @PostMapping("/inheritance")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
