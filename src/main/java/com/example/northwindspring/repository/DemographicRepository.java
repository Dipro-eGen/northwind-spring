package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository
  extends JpaRepository<Demographic, String>, QuerydslPredicateExecutor<Demographic> {

}
