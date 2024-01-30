package com.sumanta.springboot.restcrud.rest;

import com.sumanta.springboot.restcrud.dao.EmployeeDAO;
import com.sumanta.springboot.restcrud.entity.Employee;
import com.sumanta.springboot.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee not found. ID: " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0); //this id doesn't reflect dB id. Id=0 makes sure that hibernate's merge() knows it's a new employee and saves it to the dB
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeID}")
    public String delete(@PathVariable int employeeID){
        employeeService.deleteById(employeeID);
        return "employee with ID: " + employeeID + " is deleted.";
    }
}
