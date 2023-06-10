package com.example.northwindspring.repository;


import com.example.northwindspring.entity.Region;
import com.example.northwindspring.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository
  extends JpaRepository<Shipper, String>, QuerydslPredicateExecutor<Shipper> {

}
