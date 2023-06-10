package com.example.northwindspring.repository;


import com.example.northwindspring.entity.EmployeeTerritory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTerritoryRepository
  extends JpaRepository<EmployeeTerritory, String>, QuerydslPredicateExecutor<EmployeeTerritory> {

}
