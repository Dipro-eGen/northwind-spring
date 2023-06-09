package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
  extends JpaRepository<Product, String>, QuerydslPredicateExecutor<Product> {

}
