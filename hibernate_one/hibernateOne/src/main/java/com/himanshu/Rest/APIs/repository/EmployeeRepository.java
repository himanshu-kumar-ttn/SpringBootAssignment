package com.himanshu.Rest.APIs.repository;

import com.himanshu.Rest.APIs.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    public Employee findByName(String name);

    public Employee findByNameIgnoreCase(String name);

    public Employee findByAge(Integer age);

//    @Query("from Employee where age between : and 25")
    List<Employee> findByAgeBetween(int age1, int age2);


//    @Query("from Employee where name like 'a%'")
    List<Employee> findByNameLike(String ch);




}
