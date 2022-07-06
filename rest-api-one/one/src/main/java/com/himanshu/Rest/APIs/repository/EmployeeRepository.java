package com.himanshu.Rest.APIs.repository;

import com.himanshu.Rest.APIs.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    public Employee findByName(String name);
    public Employee findByNameIgnoreCase(String name);

    public Employee findByAge(Integer age);



}
