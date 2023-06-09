package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
  extends JpaRepository<Customer, String>, QuerydslPredicateExecutor<Customer> {

}
