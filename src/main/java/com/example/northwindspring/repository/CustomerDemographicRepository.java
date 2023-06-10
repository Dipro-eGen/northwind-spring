package com.example.northwindspring.repository;


import com.example.northwindspring.entity.CustomerDemographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDemographicRepository
  extends JpaRepository<CustomerDemographic, String>, QuerydslPredicateExecutor<CustomerDemographic> {

}
