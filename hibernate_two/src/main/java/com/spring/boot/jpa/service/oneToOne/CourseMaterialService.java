package com.spring.boot.jpa.service.oneToOne;

import com.spring.boot.jpa.entity.oneToOne.CourseMaterial;
import com.spring.boot.jpa.repository.oneToOne.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

// create one method to save the courseMaterial with the course

    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial){

        return courseMaterialRepository.save(courseMaterial);
    }

}
