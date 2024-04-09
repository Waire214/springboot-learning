package com.example.goninja.restCrudDemo.dao;

import com.example.goninja.restCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it...no need to write anymore code
}

//{{base_url}}/api/employees?sort=lastName,asc