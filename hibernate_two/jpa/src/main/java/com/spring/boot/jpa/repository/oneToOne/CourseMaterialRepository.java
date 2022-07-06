package com.spring.boot.jpa.repository.oneToOne;

import com.spring.boot.jpa.entity.oneToOne.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
