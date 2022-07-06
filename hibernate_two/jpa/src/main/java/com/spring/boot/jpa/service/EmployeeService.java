package com.spring.boot.jpa.service;

import com.spring.boot.jpa.entity.Employee;
import com.spring.boot.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//    ii -> Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.

    @Transactional
    public void updateSalary(Integer newSalary) {
        List<Integer> desiredEmployeeId = employeeRepository.IdOfexistingEmployeeWithSalaryLessThanAverageSalary();
        for (Integer id : desiredEmployeeId) {
            employeeRepository.updateEmployeeSalary(newSalary, id);
        }
    }

    //    iii -> Delete all employees with minimum salary.
    @Transactional
    public void deleteEmployeeWithMinimumSalary(Integer minimumSalary) {
        employeeRepository.deleteEmployeeOfMinSalary(minimumSalary);
    }

    // Native query
//     i -> Display the id, first name, age of all employees where last name ends with "singh"
//    public void getEmployeeBasedOnUsingNativeQuery() {
//
//    }

    //    Delete all employees with age greater than 45(Should be passed as a parameter)
    public void deleteEmployeeBasedOnAge(Integer age) {
        employeeRepository.deleteEmployeeBasedOnAge(age);
    }

}

