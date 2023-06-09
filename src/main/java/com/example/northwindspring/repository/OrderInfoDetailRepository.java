package com.example.northwindspring.repository;


import com.example.northwindspring.entity.OrderInfoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoDetailRepository
  extends JpaRepository<OrderInfoDetail, String>, QuerydslPredicateExecutor<OrderInfoDetail> {

}
