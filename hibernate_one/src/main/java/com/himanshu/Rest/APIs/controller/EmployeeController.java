package com.himanshu.Rest.APIs.controller;

import com.himanshu.Rest.APIs.entity.Employee;
import com.himanshu.Rest.APIs.error.EmployeeNotFoundException;
import com.himanshu.Rest.APIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    //POST
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    //GET
    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }


    @PutMapping("/employees/{employeeId}")
    public Employee readEmployees(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employeeDetail) {
        return employeeService.updateEmployee(employeeId, employeeDetail);
    }


    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployees(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully!");
    }

    @GetMapping("/employees/count")
    public Long countEmployees() {
        return employeeService.countEmployee();
    }

    // get employee by id
    @GetMapping("employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable("employeeId") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }

    // get employee by name
    @GetMapping("/employees/name/{name}")
    public Employee getEmployeesByName(@PathVariable("name") String name) {

        return employeeService.getEmployeeByName(name);
    }

    // get employee by age
    @GetMapping("/employees/age/{age}")
    public Employee getEmployeesByAge(@PathVariable("age") Integer age) {
        return employeeService.getEmployeeByAge(age);
    }


    //     employee between age of 20 to 30
    @GetMapping("/employees/{age1}{age2}")
    public List<Employee> getEmployeesByAgeInBetween(@Param("age1") Integer age1, @Param("age2") Integer age2) {
        return employeeService.getEmployeeByAgeInBetween(age1, age2);
    }

    // employee whose name starts with char S or {char}
    @GetMapping("employees/char/{char}")
    public List<Employee> getEmployeesWithNameChar(@PathVariable("char") String ch) {
        return employeeService.getEmployeesWithNameChar(ch);
    }


    @GetMapping("/pageandsort")
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "age") String sortBy)
    {
        List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
