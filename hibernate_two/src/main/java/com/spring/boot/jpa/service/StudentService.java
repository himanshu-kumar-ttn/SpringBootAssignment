package com.spring.boot.jpa.service;

import com.spring.boot.jpa.entity.inheritanceMapping.Student;
import com.spring.boot.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student createPerson(Student student) {
        return studentRepository.save(student);
    }
}
