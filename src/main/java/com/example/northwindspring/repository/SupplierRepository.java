package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository
  extends JpaRepository<Supplier, String>, QuerydslPredicateExecutor<Supplier> {

}
