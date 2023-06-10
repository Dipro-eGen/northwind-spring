package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryRepository
  extends JpaRepository<Territory, String>, QuerydslPredicateExecutor<Territory> {

}
