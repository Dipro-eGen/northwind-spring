package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
  extends JpaRepository<Employee, String>, QuerydslPredicateExecutor<Employee> {

}
