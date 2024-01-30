package com.sumanta.springboot.restcrud.dao;

import com.sumanta.springboot.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
