package com.spring.boot.jpa.repository;

import com.spring.boot.jpa.entity.inheritanceMapping.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
