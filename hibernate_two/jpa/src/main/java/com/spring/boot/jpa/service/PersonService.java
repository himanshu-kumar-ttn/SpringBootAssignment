package com.spring.boot.jpa.service;

import com.spring.boot.jpa.entity.inheritanceMapping.Person;
import com.spring.boot.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
