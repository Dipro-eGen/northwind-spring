package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Product;
import com.example.northwindspring.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository
  extends JpaRepository<Region, String>, QuerydslPredicateExecutor<Region> {

}
