package com.spring.boot.jpa.repository;

import com.spring.boot.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL
    @Query("select id from Employee where salary < (select avg(salary) from Employee")
    List<Integer> IdOfexistingEmployeeWithSalaryLessThanAverageSalary();

//    @Modifying
    @Query("UPDATE Employee set salary = :newSalary where id= forId")
    void updateEmployeeSalary(@Param("newSalary") Integer newSalary,@Param("forId") Integer id);

//    @Modifying
    @Query("DELETE from Employee where salary < :minimumSalary")
    void deleteEmployeeOfMinSalary(@Param("minimumSalary") Integer minimumSalary);

    // Native query
//    @Query(value = "select emp_id, emp_first_name, emp_age from employee_table where emp_last_name = 'Singh' ", nativeQuery = true)
//    getEmployeeBasedOnUsingNativeQuery();


//    @Modifying
    @Query(value = "DELETE FROM employee_table where emp_age > :inputAge", nativeQuery = true)
    void deleteEmployeeBasedOnAge(@Param("inputAge") Integer age);
}

