package com.himanshu.Rest.APIs.service;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.error.EmployeeNotFoundException;
import com.himanshu.Rest.APIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //CREATE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //READ
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // DELETE
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    // UPDATE
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (emp.isPresent()) {
            Employee emp1 = emp.get();
            emp1.setName(employeeDetails.getName());
            emp1.setAge(employeeDetails.getAge());
            return employeeRepository.save(emp1);
        }
        return null;
    }


    public Long countEmployee() {
        return employeeRepository.count();
    }


    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }


    public Employee getEmployeeByAge(Integer age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> getEmployeeByAgeInBetween() {
        return employeeRepository.findAll().stream().filter(employee -> employee.getAge() >= 20 && employee.getAge() <= 25).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithNameChar(String ch) {
//        return employeeRepository.findByNameStartingWith(ch);
        return employeeRepository.findAll().stream().filter(employee -> employee.getName().startsWith(ch)).toList();
    }


    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee with the given id is not present");
        }

        return employee.get();
    }


    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }


}


